package giss.mad.catalogo.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import giss.mad.catalogo.exception.ErrorHandler;
import giss.mad.catalogo.model.AtributoEje;
import giss.mad.catalogo.model.AtributoEjePorTipoElemento;
import giss.mad.catalogo.model.TipoElementoCatalogo;
import giss.mad.catalogo.model.ValorDominio;
import giss.mad.catalogo.model.auxejes.EjeReduced;
import giss.mad.catalogo.model.auxejes.TipoElementoReduced;
import giss.mad.catalogo.repository.AtributoEjePorTipoElementoRepository;
import giss.mad.catalogo.repository.AtributoEjeRepository;
import giss.mad.catalogo.repository.TipoElementoCatalogoRepository;
import giss.mad.catalogo.repository.ValorDominioCondicionadoRepository;
import giss.mad.catalogo.repository.ValorDominioRepository;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import giss.mad.catalogo.utilities.Constantes;

@Service
@Component
public class AtributoEjeService {
    @Autowired
    private AtributoEjeRepository atributoEjeRepository;

    @Autowired
    private AtributoEjePorTipoElementoRepository atributoEjePorTipoElementoRepository;

    @Autowired
    private ValorDominioService valorDominioService;
    @Autowired
    private ValorDominioRepository valorDominioRepository;

    @Autowired
    private ValorDominioCondicionadoRepository valorDominioCondicionadoRepository;
    @Autowired
    private TipoElementoCatalogoRepository tipoElementoCatalogoRepository;
    @Autowired
    private CacheManager cacheManager;


    private Pageable pageable = new Pageable() {
        @Override
        public int getPageNumber() {
            return 0;
        }

        @Override
        public int getPageSize() {
            return Constantes.NUMBER_250;
        }

        @Override
        public long getOffset() {
            return 0;
        }

        @Override
        public Sort getSort() {
            Sort sort = Sort.by(
                    Sort.Order.desc("axis"),
                    Sort.Order.asc("code")
            );
            return sort;
        }

        @Override
        public Pageable next() {
            return null;
        }

        @Override
        public Pageable previousOrFirst() {
            return null;
        }

        @Override
        public Pageable first() {
            return null;
        }

        @Override
        public Pageable withPage(final int pageNumber) {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }
    };

    public final void setValorDominioService(final ValorDominioService valorDominioService) {
        this.valorDominioService = valorDominioService;
    }
    public final void setValorDominioRepository(final ValorDominioRepository valorDominioRepository) {
        this.valorDominioRepository = valorDominioRepository;
    }
    public final void setValorDominioCondicionadoRepository(
            final ValorDominioCondicionadoRepository valorDominioCondicionadoRepository) {
        this.valorDominioCondicionadoRepository = valorDominioCondicionadoRepository;
    }

   public final void setCacheManager(final CacheManager cacheManagerIn) {
        this.cacheManager = cacheManagerIn;
        this.tipoElementoCatalogoRepository.findAllTypes().forEach((tipoElementoCatalogo) -> {
            this.getAllAttributesByTypeElement(tipoElementoCatalogo.getId(), false);
            this.getAllAttributesByTypeElement(tipoElementoCatalogo.getId(), true);
        });
        this.atributoEjeRepository.findAllAttributesIds().forEach((attrId) -> {
            this.get(attrId, true);
            this.get(attrId, false);
        });
    }

    public final void setAtributoEjePorTipoElementoRepository(final AtributoEjePorTipoElementoRepository
        atributoEjePorTipoElementoRepository) {
        this.atributoEjePorTipoElementoRepository = atributoEjePorTipoElementoRepository;
    }

    public final void setAtributoEjeRepository(final AtributoEjeRepository atributoEjeRepository) {
        this.atributoEjeRepository = atributoEjeRepository;
    }

    public final void setTipoElementoCatalogoRepository(final TipoElementoCatalogoRepository
        tipoElementoCatalogoRepository) {
        this.tipoElementoCatalogoRepository = tipoElementoCatalogoRepository;
    }

    private boolean atributoContenidoEnValues(final Integer idValueDomain, final List<ValorDominio> valuesDomain) {
        boolean foundValue = false;
        int i = 0;
        while (i < valuesDomain.size() && !foundValue) {
            ValorDominio valIesimo = valuesDomain.get(i);
            if (valIesimo.getId().intValue() == idValueDomain.intValue()) {
                foundValue = true;
            }
            i++;
        }
        return foundValue;
    }

    public final List<AtributoEje> getAllActive() {
        List<AtributoEje> results = this.atributoEjeRepository.findAllActive();
        results.forEach((attr) -> {
           this.valorDominioService.getByAttributeId(attr.getId());
        });
        return results;
    }

    public final List<AtributoEje> getAllWithHistoric() {

        Page<AtributoEje> pager = this.atributoEjeRepository.findAllWithoutDomainValues(pageable);
        pager.getContent().forEach((attr) -> {
            attr.setDomainValues(this.valorDominioService.getByAttributeId(attr.getId()));
        });
        return pager.getContent();
    }


    private AtributoEje searchInList(final Integer id, final List<AtributoEje> ejesQA) {
        AtributoEje searched = null;
        boolean found = false;
        for (int i = 0; i < ejesQA.size() && !found; i++) {
            AtributoEje attr = ejesQA.get(i);
            if (attr.getId().intValue() == id.intValue()) {
                found = true;
                boolean condition = attr.getDomainValues() != null && !attr.getDomainValues().isEmpty();
                attr.setValuesInDomain(condition ? 1 : 0);
                searched = attr;
            }
        }
        return searched;
    }

    @Cacheable(cacheNames = "atributos-cache")
    public final List<AtributoEje> getAllAttributesByTypeElement(final Integer idTypeElemen,
                                                                 final boolean isDelivery) {
        List<AtributoEje> cached;
        if (cacheManager == null || cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
            cached = this.getAttrsFromDatabase(idTypeElemen, isDelivery);
        } else {
            Cache cacheAttributes = cacheManager.getCache(Constantes.ATRIBUTOS_POR_TIPOELEM_CACHE);
            Integer cacheKey = Integer.parseInt(String.valueOf(idTypeElemen).concat(isDelivery ? "1" : "0"));
            SimpleValueWrapper cachedVal = (SimpleValueWrapper) cacheAttributes.get(cacheKey);
            if (cachedVal != null) {
                cached = (List<AtributoEje>) cachedVal.get();
            } else {
                cached = this.getAttrsFromDatabase(idTypeElemen, isDelivery);
                cacheAttributes.put(cacheKey, cached);
            }
        }
        return cached;
    }

    private List<AtributoEje> getAttrsFromDatabase(final Integer idTipoElement, final boolean isDelivery) {

        List<AtributoEje> allAttributesCandidates;
        if (isDelivery) {
            allAttributesCandidates = this.atributoEjePorTipoElementoRepository.
                    getAtributosOrdenadosForDelivery(idTipoElement);
        } else {
            allAttributesCandidates = this.atributoEjePorTipoElementoRepository.
                    getAtributosOrdenadosForElementType(idTipoElement);
        }

        List<AtributoEje> allAttributes = new ArrayList<>();
        allAttributesCandidates.forEach((atributo) -> {
            // una de las cosas a mirar para incorporar a este valor de dominio es que exista para su
            // tipologia: entrega o catalogo
            List<ValorDominio> valsDomAttr = this.valorDominioRepository.findAllByAxisAttributeId(atributo.getId());
            List<ValorDominio> onlyDomainValuesForThisType = new ArrayList<>();
            valsDomAttr.forEach((valDomain) -> {
                if (valDomain.getForCatalogue().intValue() == Constantes.NUMBER_1 && !isDelivery) {
                    onlyDomainValuesForThisType.add(valDomain);
                } else if (valDomain.getForDelivery().intValue() == Constantes.NUMBER_1 && isDelivery) {
                    onlyDomainValuesForThisType.add(valDomain);
                }
            });
            if (atributo.getValuesInDomain().intValue() == 0 || !onlyDomainValuesForThisType.isEmpty()) {
                atributo.setDomainValues(onlyDomainValuesForThisType);
                atributo.setAtributosAsociados(this.atributoEjePorTipoElementoRepository.
                        findAllByAxisAttributeId(atributo.getId()));
                List<ValorDominio> listCLeaned = new ArrayList<>();
                atributo.getDomainValues().forEach((domainVal) -> {
                    if (domainVal.getDeleted() == null) {
                        domainVal.setDeliveryDomainValues(null);
                        domainVal.setElementDomainValues(null);
                        domainVal.setMasterDomainValues(this.valorDominioCondicionadoRepository.
                                findAllByDeletedIsNullAndDomainValueId(domainVal.getId()));
                        listCLeaned.add(domainVal);
                    }
                });
                atributo.getDomainValues().clear();
                atributo.getDomainValues().addAll(listCLeaned);
                allAttributes.add(atributo);
            }
        });
        return allAttributes;
    }

    public final List<String> getAxisNamesOrderedById() {
        List<String> labelsOrderedById = new ArrayList<>();
        List<AtributoEje> nombresEjesOrdered = this.atributoEjeRepository.findByAxisAndDeletedIsNull(
            Constantes.NUMBER_1,
            Sort.by(Sort.Order.asc("id")));
        int min = 1;
        int last = (nombresEjesOrdered != null && !nombresEjesOrdered.isEmpty()) ? nombresEjesOrdered.
            get(nombresEjesOrdered.size() - 1).getId() : 0;
        for (int i = min; i <= last; i++) {
            AtributoEje searched = searchInList(i, nombresEjesOrdered);
            if (searched != null) {
                labelsOrderedById.add(searched.getName());
                boolean condition = searched.getDomainValues() != null && !searched.getDomainValues().isEmpty();
                searched.setValuesInDomain(condition ? 1 : 0);
            } else {
                labelsOrderedById.add("");
            }
        }
        return labelsOrderedById;
    }

    public final List<EjeReduced> getEjesReduced() {
        List<EjeReduced> listaEjeReduceds = new ArrayList<>();
        List<AtributoEje> all = this.atributoEjeRepository.findByAxisAndDeletedIsNull(Constantes.NUMBER_1,
            Sort.by(Sort.Order.asc("id")));
        for (AtributoEje ejeOrAttr : all) {
            if (ejeOrAttr.getAxis() == Constantes.NUMBER_1) {
                EjeReduced newEjeReduced = new EjeReduced(ejeOrAttr.getId(), ejeOrAttr.getName());
                listaEjeReduceds.add(newEjeReduced);
            }
        }
        return listaEjeReduceds;
    }

    public final List<AtributoEje> getAllCachedAtributos(final Integer nivelCatalogue, final boolean isRelease) {
        List<AtributoEje> allAttrs;
        if (nivelCatalogue == -1) {
            allAttrs = new ArrayList<>();
            List<AtributoEje> attrsNivel1 =
                    this.getAllAttributesByTypeElement(TipoElementoCatalogo.ELEMENTO_PROMOCIONABLE, isRelease);
            List<AtributoEje> attrsNivel4 =
                    this.getAllAttributesByTypeElement(TipoElementoCatalogo.APLICACION, isRelease);
            List<AtributoEje> attrsNivel2 =
                    this.getAllAttributesByTypeElement(TipoElementoCatalogo.AGRUPACION_FUNCIONAL, isRelease);
            List<AtributoEje> attrsNivel3 =
                    this.getAllAttributesByTypeElement(TipoElementoCatalogo.PROYECTO, isRelease);

            allAttrs.addAll(attrsNivel1);
            attrsNivel4.forEach((attr) -> {
                if (!allAttrs.contains(attr)) {
                    allAttrs.add(attr);
                }
            });
            attrsNivel2.forEach((attr) -> {
                if (!allAttrs.contains(attr)) {
                    allAttrs.add(attr);
                }
            });
            attrsNivel3.forEach((attr) -> {
                if (!allAttrs.contains(attr)) {
                    allAttrs.add(attr);
                }
            });

        } else {
            allAttrs = this.getAllAttributesByTypeElement(nivelCatalogue, isRelease);
        }
        return allAttrs;
    }

    public final List<AtributoEje> getSoloAtributos() {
        List<AtributoEje> c = this.atributoEjeRepository.findByAxisAndDeletedIsNull(Constantes.NUMBER_0,
                Sort.by(Sort.Order.asc("id")));
        for (AtributoEje attr : c) {
            boolean condition = attr.getDomainValues() != null && !attr.getDomainValues().isEmpty();
            attr.setValuesInDomain(condition ? 1 : 0);
        }
        return c;
    }

    public final AtributoEje getFromDatabase(final Integer idAtributoEje) {
        AtributoEje atributo = this.atributoEjeRepository.findById(idAtributoEje).get();
        atributo.setElementypes(new ArrayList<>());
        atributo.getAtributosAsociados().forEach((attrType) -> {
            TipoElementoReduced t = new TipoElementoReduced();
            t.setName(this.tipoElementoCatalogoRepository.
                    findByIdAndDeletedIsNull(attrType.getCatalogElementTypeId()).getName());
            t.setId(attrType.getCatalogElementTypeId());
            atributo.getElementypes().add(t);
        });
        List<AtributoEjePorTipoElemento> attrsTipoCat = this.atributoEjePorTipoElementoRepository.
                findAllByAxisAttributeId(atributo.getId());
        for (AtributoEjePorTipoElemento attrByTipoElem : attrsTipoCat) {
            atributo.setAplicaAReleases(attrByTipoElem.getForDelivery());
            atributo.setAplicaACatalogo(attrByTipoElem.getForCatalogue());
        }
        if (attrsTipoCat == null || attrsTipoCat.isEmpty()) {
            atributo.setAplicaAReleases(Constantes.NUMBER_1);
            atributo.setAplicaACatalogo(Constantes.NUMBER_1);
        }
        return atributo;
    }

    private AtributoEje get(final Integer idAtributoEje, final boolean isRelease) {
        AtributoEje cached;
        if (cacheManager == null || cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
            cached = this.atributoEjeRepository.findByIdAndDeletedIsNull(idAtributoEje);
        } else {
            cached = this.valorDominioService.buscarEnCache(idAtributoEje, isRelease);
        }
        return cached;
    }

    public final AtributoEje getForDelivery(final Integer idAtributoEje) {
        AtributoEje cached;
        if (cacheManager == null || cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
            cached = this.atributoEjeRepository.findByIdAndDeletedIsNull(idAtributoEje);
        } else {
            cached = this.valorDominioService.buscarEnCache(idAtributoEje, true);
        }
        return cached;
    }

    public final AtributoEje getForCatalogue(final Integer idAtributoEje) {
        AtributoEje cached;
        if (cacheManager == null || cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
            cached = this.atributoEjeRepository.findByIdAndDeletedIsNull(idAtributoEje);
        } else {
            cached = this.valorDominioService.buscarEnCache(idAtributoEje, false);
        }
        return cached;
    }

    @Transactional
    public final AtributoEje insertar(final AtributoEje attr) {
        attr.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        AtributoEje attrBBDD = this.atributoEjeRepository.save(attr);
        attrBBDD.setDomainValues(new ArrayList<>());
        attrBBDD.setElementypes(attr.getElementypes());
        List<TipoElementoReduced> reduceds = attr.getElementypes() == null ? new ArrayList<>() : attr.getElementypes();
        List<AtributoEjePorTipoElemento> attrsTipoCat = new ArrayList<>();
        for (TipoElementoReduced reduced : reduceds) {
            if (attrsTipoCat.isEmpty()) {
                AtributoEjePorTipoElemento nuevoAttrByTipoElem = new AtributoEjePorTipoElemento();
                nuevoAttrByTipoElem.setAxisAttributeId(attr.getId());
                nuevoAttrByTipoElem.setCatalogElementTypeId(reduced.getId());
                nuevoAttrByTipoElem.setForDelivery(attr.getAplicaAReleases());
                nuevoAttrByTipoElem.setForCatalogue(attr.getAplicaACatalogo());
                nuevoAttrByTipoElem.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
                attrsTipoCat.add(nuevoAttrByTipoElem);
            }
        }
        attrBBDD.setAtributosAsociados(attrsTipoCat);
        this.atributoEjeRepository.save(attr);
        if (cacheManager != null && !cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
            cacheManager.getCache(Constantes.ATRIBUTOS_POR_TIPOELEM_CACHE).invalidate();
        }
        return attrBBDD;
    }

    @Transactional
    public final AtributoEje actualizar(final AtributoEje attr) throws RuntimeException{
        if (attr.getId() == null) {
            throw new RuntimeException( "El campo de clave primaria ID no viaja en la petición");
        }
        List<ValorDominio> nuevosValoresDeDominio = new ArrayList<>();
        if (attr.getDomainValues() != null) {
            nuevosValoresDeDominio.addAll(attr.getDomainValues());
        }
        AtributoEje attrBBDD = this.atributoEjeRepository.findById(attr.getId()).get();
        if (attrBBDD != null) {
            if (cacheManager != null && !cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
                cacheManager.getCache(Constantes.ATRIBUTOS_POR_TIPOELEM_CACHE).invalidate();
            }
            attr.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            attr.setCreationDate(attrBBDD.getCreationDate());
            attr.setDomainValues(attrBBDD.getDomainValues());
            if (attr.getValuesInDomain() == null) {
                attr.setValuesInDomain(attrBBDD.getValuesInDomain());
            }
            attr.setDeleted((attr.getDeleted() == null || attr.getDeleted() == 0) ? null : attr.getDeleted());
            this.atributoEjeRepository.save(attr);
            List<ValorDominio> valuesOfDomainAttr = this.valorDominioRepository.
                    findAllByAxisAttributeId(attrBBDD.getId());
            /*attrBBDD.getDomainValues() != null && attrBBDD.getDomainValues().size()*/
            if (valuesOfDomainAttr != null && valuesOfDomainAttr.size() != nuevosValoresDeDominio.size()) {
                //desenganchamos aquellas apariciones en BBDD que no viajan en la lista 'nuevosValoresDeDominio'
                for (ValorDominio valorDominioBBDD : valuesOfDomainAttr) {
                    if (!atributoContenidoEnValues(valorDominioBBDD.getId(), nuevosValoresDeDominio)) {
                        // baja lógica de ese valor de dominio del atributo
                        valorDominioBBDD = this.valorDominioService.get(valorDominioBBDD.getId());
                        valorDominioBBDD.setDeleted(1);
                        this.valorDominioService.actualizar(valorDominioBBDD);
                    }
                }
                List<ValorDominio> lista = new ArrayList<>();
                for (ValorDominio valorDominio : nuevosValoresDeDominio) {
                    valorDominio = this.valorDominioService.get(valorDominio.getId());
                    lista.add(valorDominio);
                }
                attr.getDomainValues().clear();
                attr.setDomainValues(lista);
            }
            this.atributoEjeRepository.save(attr);

            List<TipoElementoReduced> reduceds =
                attr.getElementypes() == null ? new ArrayList<>() : attr.getElementypes();
            for (TipoElementoReduced reduced : reduceds) {
                List<AtributoEjePorTipoElemento> attrsTipoCat = this.atributoEjePorTipoElementoRepository.
                    findAllByDeletedIsNullAndCatalogElementTypeIdAndAxisAttributeId(reduced.getId(), attr.getId());
                if (attrsTipoCat.isEmpty()) {
                    AtributoEjePorTipoElemento nuevoAttrByTipoElem = new AtributoEjePorTipoElemento();
                    nuevoAttrByTipoElem.setCatalogElementTypeId(reduced.getId());
                    nuevoAttrByTipoElem.setAxisAttributeId(attr.getId());
                    nuevoAttrByTipoElem.setForDelivery(attr.getAplicaAReleases());
                    nuevoAttrByTipoElem.setForCatalogue(attr.getAplicaACatalogo());
                    nuevoAttrByTipoElem.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
                    this.atributoEjePorTipoElementoRepository.save(nuevoAttrByTipoElem);
                }
            }
        }
        return attr;
    }

    @Transactional
    public final AtributoEje borradoLogico(final Integer idattr) {
        AtributoEje attr = this.atributoEjeRepository.findByIdAndDeletedIsNull(idattr);
        if (attr != null) {
            Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTime().getTime());
            attr.setUpdateDate(timeStamp);
            attr.setDeleted(1);
            this.atributoEjeRepository.save(attr);
            //hay que borrarlo de la tabla de relacioón con atributos por tipo elemento
            this.atributoEjePorTipoElementoRepository.findAllByAxisAttributeId(idattr).forEach((tipAtr) -> {
                this.atributoEjePorTipoElementoRepository.delete(tipAtr);
            });
            for (ValorDominio valorDominio : attr.getDomainValues()) {
                this.valorDominioService.borradoLogico(valorDominio.getId());
            }
            if (cacheManager != null && !cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
                cacheManager.getCache(Constantes.ATRIBUTOS_POR_TIPOELEM_CACHE).invalidate();
            }
        }

        return attr;
    }


}
