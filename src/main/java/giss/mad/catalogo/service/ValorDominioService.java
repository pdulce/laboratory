package giss.mad.catalogo.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import giss.mad.catalogo.exception.ValidationErrorMessage;
import giss.mad.catalogo.model.TipoElementoCatalogo;
import giss.mad.catalogo.repository.AtributoEjePorTipoElementoRepository;
import giss.mad.catalogo.repository.AtributoEjeRepository;
import giss.mad.catalogo.utilities.Constantes;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import giss.mad.catalogo.model.AtributoEje;
import giss.mad.catalogo.model.ValorDominio;
import giss.mad.catalogo.model.ValorDominioCondicionadoPor;
import giss.mad.catalogo.repository.ValorDominioCondicionadoRepository;
import giss.mad.catalogo.repository.ValorDominioRepository;

@Service
public class ValorDominioService {

    @Autowired
    private ValorDominioRepository valorDominioRepository;

    @Autowired
    private ValorDominioCondicionadoRepository valorDominioCondicionadoRepository;

    @Autowired
    private AtributoEjeRepository atributoEjeRepository;

    @Autowired
    private AtributoEjePorTipoElementoRepository atributoEjePorTipoElementoRepository;

    @Autowired
    private CacheManager cacheManager;
    
    public final void setCacheManager(final CacheManager cacheManagerIn) {
        this.cacheManager = cacheManagerIn;
    }

    public final void setValorDominioCondicionadoRepository(final ValorDominioCondicionadoRepository
        valorDominioCondicionadoRepository) {
        this.valorDominioCondicionadoRepository = valorDominioCondicionadoRepository;
    }

    public final void setValorDominioRepository(final ValorDominioRepository valorDominioRepository) {
        this.valorDominioRepository = valorDominioRepository;
    }

    public final void setAtributoEjePorTipoElementoRepository(final AtributoEjePorTipoElementoRepository
                                                                      atributoEjePorTipoElementoRepository) {
        this.atributoEjePorTipoElementoRepository = atributoEjePorTipoElementoRepository;
    }
    public final void setAtributoEjeRepository(final AtributoEjeRepository atributoEjeRepository) {
        this.atributoEjeRepository = atributoEjeRepository;
    }

    public final AtributoEje buscarEnCache(final Integer idAtributoEje, final boolean forDelivery) {
        Cache cacheListOfAttributes = cacheManager.getCache(Constantes.ATRIBUTOS_POR_TIPOELEM_CACHE);
        List<Integer> claves = List.of(
         Integer.parseInt(String.valueOf(TipoElementoCatalogo.ELEMENTO_PROMOCIONABLE).concat(forDelivery ? "1" : "0")),
         Integer.parseInt(String.valueOf(TipoElementoCatalogo.APLICACION).concat(forDelivery ? "1" : "0")),
         Integer.parseInt(String.valueOf(TipoElementoCatalogo.AGRUPACION_FUNCIONAL).concat(forDelivery ? "1" : "0")),
                Integer.parseInt(String.valueOf(TipoElementoCatalogo.PROYECTO).concat(forDelivery ? "1" : "0")));
        AtributoEje atributeCached = null;
        boolean foundAttr = false;
        int i = 0;
        while (!foundAttr && i < claves.size()) {
            Integer cacheKey = claves.get(i++);
            SimpleValueWrapper cachedVal = (SimpleValueWrapper) cacheListOfAttributes.get(cacheKey);
            if (cachedVal != null) {
                List<AtributoEje> listaattrsCached = (List<AtributoEje>) cachedVal.get();
                int j = 0;
                while (!foundAttr && j < listaattrsCached.size()) {
                    AtributoEje atrrCandidate = listaattrsCached.get(j++);
                    if (atrrCandidate.getId().intValue() == idAtributoEje.intValue()) {
                        foundAttr = true;
                        atributeCached = atrrCandidate;
                    }
                }
            }
        }
        if (!foundAttr) {
            AtributoEje attrFromBD = this.atributoEjeRepository.findById(idAtributoEje).get();
            if (attrFromBD != null) {
                attrFromBD.setDomainValues(this.valorDominioRepository.findAllByAxisAttributeId(attrFromBD.getId()));
                attrFromBD.setAtributosAsociados(this.atributoEjePorTipoElementoRepository.
                        findAllByAxisAttributeId(attrFromBD.getId()));
                if (attrFromBD.getDeleted() == null) {
                    List<ValorDominio> listCLeaned = new ArrayList<>();
                    attrFromBD.getDomainValues().forEach((domainVal) -> {
                        if (domainVal.getDeleted() == null) {
                            domainVal.setDeliveryDomainValues(null);
                            domainVal.setElementDomainValues(null);
                            domainVal.setMasterDomainValues(this.valorDominioCondicionadoRepository.
                                    findAllByDeletedIsNullAndDomainValueId(domainVal.getId()));
                            listCLeaned.add(domainVal);
                        }
                    });
                    attrFromBD.getDomainValues().clear();
                    attrFromBD.getDomainValues().addAll(listCLeaned);
                }
                atributeCached = attrFromBD;
            }
        }
        return atributeCached;
    }

    private void chargeAttrNameInfo(final ValorDominio v) {
        if (v.getAxisAttributeId() != null) {
            AtributoEje attribute = this.buscarEnCache(v.getAxisAttributeId(), false);
            if (attribute == null) {
                attribute = this.buscarEnCache(v.getAxisAttributeId(), true);
            }
            String denominacionAttr = "(".concat(attribute.getCode()).concat(")").concat(" ").
                    concat(attribute.getName());
            v.setAttributeName(denominacionAttr);
            if (v.getMasterDomainValues() != null) {
                for (ValorDominioCondicionadoPor conditionedBy : v.getMasterDomainValues()) {
                    conditionedBy.setName(
                        this.valorDominioRepository.getById(conditionedBy.getDomainValueId()).getName());
                    String denoAttrMaster = "(".concat(attribute.getCode()).concat(")").concat(" ").
                            concat(attribute.getName());
                    conditionedBy.setAttributeName(denoAttrMaster);
                }
            }
        }
    }

    public final Page<ValorDominio> getAllHistoric(final Pageable pageable, final String nameFilter) {
        return this.valorDominioRepository.findAllHistoric(nameFilter, pageable);
    }

    private ValorDominio searchInList(final Integer id, final List<ValorDominio> valoresDominio) {
        ValorDominio searched = null;
        boolean found = false;
        for (int i = 0; i < valoresDominio.size() && !found; i++) {
            ValorDominio t = valoresDominio.get(i);
            if (t.getId().intValue() == id.intValue()) {
                found = true;
                searched = t;
            }
        }
        return searched;
    }

    /*** Invocado por necesidades de Itinerario **/
    public final List<String> getlabelsOrderById() {
        List<String> labelsOrderedById = new ArrayList<>();
        List<ValorDominio> valoresDominio = this.valorDominioRepository.findAllByNameIsNotNullAndDeletedIsNull(
            Sort.by(Sort.Order.asc("id")));
        int min = 1;
        int last = (valoresDominio != null && !valoresDominio.isEmpty())
            ? valoresDominio.get(valoresDominio.size() - 1).getId() : 0;
        for (int i = min; i <= last; i++) {
            ValorDominio searched = searchInList(i, valoresDominio);
            if (searched != null) {
                labelsOrderedById.add(searched.getName());
            } else {
                labelsOrderedById.add("");
            }
        }
        return labelsOrderedById;
    }

    public final ValorDominio get(final Integer id) {
        return this.valorDominioRepository.findByIdAndNameIsNotNull(id);
    }

    public final List<ValorDominio> getByAttributeId(final Integer idAtributoEje) {
        List<ValorDominio> valoresDominio1 = buscarEnCache(idAtributoEje, false).getDomainValues();
        List<ValorDominio> valoresDominio2 = buscarEnCache(idAtributoEje, true).getDomainValues();
        List<ValorDominio> valores = new ArrayList<>();
        valores.addAll(valoresDominio1 == null || valoresDominio1.isEmpty() ? new ArrayList<>() : valoresDominio1);
        if (valoresDominio2 != null) {
            valoresDominio2.forEach((val) -> {
                if (!valores.contains(val)) {
                    valores.add(val);
                }
            });
        }
        return valores;
    }

    public final Map<Integer, List<ValorDominio>>
        getDependentsOfAttrCodeAndValueMasterId(final Integer idAxisAttributeMaster,
                                                final Integer domainValueIdMaster) {

        Map<Integer, List<ValorDominio>> resultados = new HashMap<>();

        // Obtenemos el atributo asociado a este padre
        AtributoEje attributeMaster = this.buscarEnCache(idAxisAttributeMaster, false);
        ValorDominio valorDominioMaster = this.valorDominioRepository.findByIdAndDeletedIsNull(domainValueIdMaster);

        // buscamos este atributo master en todos los atributos actuales
        List<AtributoEje> atributosDependientes =
                this.atributoEjeRepository.findAllByAxisAttributeCollateralIdAndDeletedIsNull(attributeMaster.getId());
        for (AtributoEje childAttr: atributosDependientes) {
            List<ValorDominio> filteredList = new ArrayList<>();
            // vemos cuales de estos valores del hijo dependen del padre seleccionado: imaginemos que todos
            for (ValorDominio valueDomainChild: childAttr.getDomainValues()) {
                if (valueDomainChild.getMasterDomainValues() == null
                        || valueDomainChild.getMasterDomainValues().size() == 0) {
                    // no tenemos dependencias, de ningún valores master para este, lo incorporamos
                    filteredList.add(valueDomainChild);
                } else {
                    // si hay dependencias, entonces debemos asegurarnos que son las que tenemos anotadas en BBDD
                    boolean hayDependencias = false;
                    for (int i = 0; i < valueDomainChild.getMasterDomainValues().size() && !hayDependencias; i++) {
                        ValorDominioCondicionadoPor valorCondicionadoMaster =
                                valueDomainChild.getMasterDomainValues().get(i);
                        if (valorCondicionadoMaster.getDomainValueCollateralId().intValue()
                                == valorDominioMaster.getId().intValue()) {
                            filteredList.add(valueDomainChild);
                            hayDependencias = true;
                        }
                    }
                }
            }
            resultados.put(childAttr.getId(), filteredList);
        }

        return resultados;
    }

    public final List<ValorDominio> getByName(final String name) {
        return this.valorDominioRepository.findByName(name);
    }

    @Transactional
    public final  Map<ValorDominio, List<ValidationErrorMessage>> insertar(final ValorDominio valorDominio) {
        ValorDominio valorDominioExistente = this.valorDominioRepository.
                findByAxisAttributeIdAndNameAndDeletedIsNull(valorDominio.getAxisAttributeId(),
                        valorDominio.getName());
        Map<ValorDominio, List<ValidationErrorMessage>> mapRetorno = new HashMap<>();
        List<ValidationErrorMessage> errMsgs = new ArrayList<>();
        if (valorDominioExistente != null) {
            errMsgs.add(new ValidationErrorMessage("El nombre indicado ya existe para otro valor de dominio de "
                    + "este atributo"));
            mapRetorno.put(null, errMsgs);
        } else {
            valorDominio.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            ValorDominio valorDominioInserted = this.valorDominioRepository.save(valorDominio);
            chargeAttrNameInfo(valorDominioInserted);
            if (cacheManager != null && !cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
                cacheManager.getCache(Constantes.ATRIBUTOS_POR_TIPOELEM_CACHE).invalidate();
            }
            mapRetorno.put(valorDominioInserted, errMsgs);
        }
        return mapRetorno;
    }

    private ValorDominioCondicionadoPor valueConditionedInList(final ValorDominioCondicionadoPor valueCondPor,
        final List<ValorDominioCondicionadoPor> listOfDomainVals) {
        ValorDominioCondicionadoPor foundValue = null;
        boolean foundDomainValue = false;
        int i = 0;
        while (i < listOfDomainVals.size() && !foundDomainValue) {
            ValorDominioCondicionadoPor val = listOfDomainVals.get(i);
            if (val.getDomainValueCollateralId().intValue() == valueCondPor.getDomainValueCollateralId().intValue()) {
                foundDomainValue = true;
                foundValue = val;
            }
            i++;
        }
        return foundValue;
    }

    @Transactional
    public final Map<ValorDominio, List<ValidationErrorMessage>> actualizar(final ValorDominio valorDominio) {
        if (valorDominio.getId() == null) {
            throw new IllegalArgumentException("el campo de clave primaria ID no viene en el registro a modificar");
        }
        ValorDominio valorDominioExistente = this.valorDominioRepository.
                findByAxisAttributeIdAndNameAndDeletedIsNull(valorDominio.getAxisAttributeId(),
                        valorDominio.getName());
        Map<ValorDominio, List<ValidationErrorMessage>> mapRetorno = new HashMap<>();
        List<ValidationErrorMessage> errMsgs = new ArrayList<>();
        if (valorDominioExistente != null
                && valorDominioExistente.getId().intValue() != valorDominio.getId().intValue()) {
            errMsgs.add(new ValidationErrorMessage("El nombre indicado ya existe para otro valor de dominio de "
                    + "este atributo"));
            mapRetorno.put(null, errMsgs);
        } else {
            List<ValorDominioCondicionadoPor> nuevosValuesMaster = new ArrayList();
            if (valorDominio.getMasterDomainValues() != null) {
                nuevosValuesMaster.addAll(valorDominio.getMasterDomainValues());
            }
            ValorDominio valorDominioBBDD = this.valorDominioRepository.findById(valorDominio.getId()).get();
            List<ValorDominioCondicionadoPor> listaAntiguaValuesMaster = new ArrayList<>();
            if (valorDominioBBDD.getMasterDomainValues() != null) {
                listaAntiguaValuesMaster.addAll(valorDominioBBDD.getMasterDomainValues());
            }
            for (ValorDominioCondicionadoPor valorDominioCondicionadoPor : nuevosValuesMaster) {
                ValorDominioCondicionadoPor nuevoValueMaster = valueConditionedInList(valorDominioCondicionadoPor,
                        listaAntiguaValuesMaster);
                ValorDominio valorDominioCollateralBBDD = this.valorDominioRepository.findById(
                        valorDominioCondicionadoPor.getDomainValueCollateralId()).get();
                AtributoEje attrSearched = this.buscarEnCache(valorDominioCollateralBBDD.
                        getAxisAttributeId(), true);
                if (attrSearched == null) {
                    attrSearched = this.buscarEnCache(valorDominioCollateralBBDD.getAxisAttributeId(), false);
                }
                String attrName = attrSearched.getName();
                if (nuevoValueMaster == null) {
                    // damos de insertar el elemento
                    valorDominioCondicionadoPor.setCreationDate(new Timestamp(Calendar.getInstance().getTime().
                            getTime()));
                    valorDominioCondicionadoPor.setName(this.valorDominioRepository.
                            findById(valorDominioCondicionadoPor.getDomainValueCollateralId()).get().getName());
                    valorDominioCondicionadoPor.setAttributeName(attrName); //nombre del atributo
                    valorDominioCondicionadoPor.setDomainValueId(valorDominio.getId());
                    valorDominioCondicionadoPor.setDomainValueCollateralId(valorDominioCondicionadoPor.
                            getDomainValueCollateralId());
                } else {
                    valorDominioCondicionadoPor.setId(nuevoValueMaster.getId());
                    valorDominioCondicionadoPor.setCreationDate(nuevoValueMaster.getCreationDate());
                    valorDominioCondicionadoPor.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().
                            getTime()));
                    valorDominioCondicionadoPor.setName(this.valorDominioRepository.
                            findById(valorDominioCondicionadoPor.getDomainValueCollateralId()).get().getName());
                    valorDominioCondicionadoPor.setAttributeName(attrName); //nombre del atributo
                    valorDominioCondicionadoPor.setDomainValueId(nuevoValueMaster.getDomainValueId());
                    valorDominioCondicionadoPor.setDomainValueCollateralId(nuevoValueMaster.
                            getDomainValueCollateralId());
                }
            }
            valorDominio.setCreationDate(valorDominioBBDD.getCreationDate());
            valorDominio.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            valorDominio.setMasterDomainValues(nuevosValuesMaster);
            this.valorDominioRepository.save(valorDominio);

            //borramos la lista de valores condicionados que no exista en el objeto de entrada
            for (ValorDominioCondicionadoPor oldvalue : listaAntiguaValuesMaster) {
                if (valueConditionedInList(oldvalue, valorDominio.getMasterDomainValues()) == null) {
                    this.valorDominioCondicionadoRepository.delete(this.valorDominioCondicionadoRepository.
                            findById(oldvalue.getId()).get());
                }
            }
            chargeAttrNameInfo(valorDominio);
            if (cacheManager != null && !cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
                cacheManager.getCache(Constantes.ATRIBUTOS_POR_TIPOELEM_CACHE).invalidate();
            }
            mapRetorno.put(valorDominio, errMsgs);
        }
        return mapRetorno;
    }

    @Transactional
    public final ValorDominio borradoLogico(final Integer valorDominioId) {
        Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTime().getTime());
        ValorDominio valorDominio = this.valorDominioRepository.findByIdAndDeletedIsNull(valorDominioId);
        List<ValorDominioCondicionadoPor> listaAntiguaValuesMaster = new ArrayList<>();
        if (valorDominio != null) {
            if (valorDominio.getMasterDomainValues() != null) {
                listaAntiguaValuesMaster.addAll(valorDominio.getMasterDomainValues());
            }
            valorDominio.setUpdateDate(timeStamp);
            valorDominio.setDeleted(1);
            for (ValorDominioCondicionadoPor valConditionedMaster : listaAntiguaValuesMaster) {
                valConditionedMaster.setUpdateDate(timeStamp);
                valConditionedMaster.setDeleted(1);
            }
            this.valorDominioRepository.save(valorDominio);
        }
        if (cacheManager != null && !cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
            cacheManager.getCache(Constantes.ATRIBUTOS_POR_TIPOELEM_CACHE).invalidate();
        }
        return valorDominio;
    }

}
