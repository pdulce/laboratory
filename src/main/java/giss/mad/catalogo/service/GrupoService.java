package giss.mad.catalogo.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import giss.mad.catalogo.repository.ElementoCatalogoRepository;
import giss.mad.catalogo.repository.EntregaElementoCatalogoRepository;
import giss.mad.catalogo.utilities.Constantes;
import giss.mad.catalogo.utilities.IntegerComparator;
import giss.mad.catalogo.utilities.UnOrganizativaComparator;
import giss.mad.catalogo.model.TipoUnidadOrganizativa;
import giss.mad.catalogo.model.filters.UnidadOrganizativaMinimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import giss.mad.catalogo.exception.ValidationErrorMessage;
import giss.mad.catalogo.model.Grupo;
import giss.mad.catalogo.repository.GrupoRepository;

@Service
public class GrupoService {
    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private ElementoCatalogoRepository elementoCatalogoRepository;

    @Autowired
    private EntregaElementoCatalogoRepository entregaElementoCatalogoRepository;

    @Autowired
    private CacheManager cacheManager;


    public final CacheManager getCacheManager() {
        return this.cacheManager;
    }
    public final void setCacheManager(final CacheManager cacheManagerIn) {

        this.cacheManager = cacheManagerIn;
        this.getAllActiveGroups().forEach((group) -> {
            group.setChildrenIds(grupoRepository.getAllChildrenIdsByParent(group.getId()));
            this.cacheManager.getCache(Constantes.GRUPOS_ORG_CACHE).put(group.getCodigo(), group);
            this.cacheManager.getCache(Constantes.GRUPOS_ORG_CACHE_BY_ID).put(group.getId(), group);
        });
    }

    public final void setGrupoRepository(final GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }
    public final void setElementoCatalogoRepository(final ElementoCatalogoRepository elementoCatalogoRepository) {
        this.elementoCatalogoRepository = elementoCatalogoRepository;
    }
    public final void setEntregaElementoCatalogoRepository(final EntregaElementoCatalogoRepository
                                                                   entregaElementoCatalogoRepository) {
        this.entregaElementoCatalogoRepository = entregaElementoCatalogoRepository;
    }
    @Cacheable(cacheNames = "gruposorg-cache")
    public final Grupo getByCode(final String code) {
        Grupo cached;
        if (cacheManager == null || cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
            cached = this.grupoRepository.findByCodigoAndDeletedIsNull(code);
            if (cached != null) {
                cached.setChildrenIds(grupoRepository.getAllChildrenIdsByParent(cached.getId()));
            }
        } else {
            Cache unidadesOrg = cacheManager.getCache(Constantes.GRUPOS_ORG_CACHE);
            SimpleValueWrapper cachedVal = (SimpleValueWrapper) unidadesOrg.get(code);
            if (cachedVal != null) {
                cached = (Grupo) cachedVal.get();
            } else {
                cached = this.grupoRepository.findByCodigoAndDeletedIsNull(code);
                if (cached != null) {
                    cached.setChildrenIds(grupoRepository.getAllChildrenIdsByParent(cached.getId()));
                    unidadesOrg.put(cached.getCodigo(), cached);
                }
            }
        }
        return cached;
    }


    @Cacheable(cacheNames = "gruposorg2-cache")
    public final Grupo getById(final Integer id) {
        Grupo cached;
        if (this.cacheManager == null || this.cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
            cached = this.grupoRepository.findById(id).get();
        } else {
            Cache unidadesOrg = this.cacheManager.getCache(Constantes.GRUPOS_ORG_CACHE_BY_ID);
            SimpleValueWrapper cachedVal = (SimpleValueWrapper) unidadesOrg.get(id);
            if (cachedVal != null) {
                cached = (Grupo) cachedVal.get();
            } else {
                cached = this.grupoRepository.findById(id).get();
                unidadesOrg.put(cached.getId(), cached);
            }
        }
        return cached;
    }

    public final List<Integer> getGruposIds(final Integer idGroup) {
        List<Integer> inferiores = new ArrayList<>();
        if (idGroup != null) {
            Collection<Integer> col = this.recursiveHirarchyGroupsMap(getById(idGroup)).keySet();
            if (col != null) {
                inferiores.addAll(col);
            }
            if (inferiores.size() > 1) {
                Collections.sort(inferiores, new IntegerComparator());
            }
        }
        return inferiores;
    }


    public final List<Grupo> getAllActiveGroups() {
        return this.grupoRepository.findAllActiveGroups();
    }

    public final Page<Grupo> getAll(final Pageable pageable) {
        Page<Grupo> allGroups = this.grupoRepository.findAllWithoutChildren(pageable);
        for (Grupo group: allGroups) {
            if (group.getParentGroupId() != null) {
                group.setParentGroupName(getById(group.getParentGroupId()).getName());
            }
        }
        return allGroups;
    }

    public final Grupo getByIdWithoutChildren(final Integer id) {
        return this.grupoRepository.getByIdWithoutChildren(id);
    }

    public final List<UnidadOrganizativaMinimal> getGruposInferiorByCode(final String code) {
        List<UnidadOrganizativaMinimal> unidadesOrg = new ArrayList<>();
        if (code != null) {
            Grupo grupo = getByCode(code);
            Collection<UnidadOrganizativaMinimal> col = recursiveHirarchyGroupsMap(grupo).values();
            if (col != null) {
                unidadesOrg.addAll(col);
            }
        }
        Collections.sort(unidadesOrg, new UnOrganizativaComparator());
        return unidadesOrg;
    }

    public final List<UnidadOrganizativaMinimal> getGrupos(final Grupo userGroup) {
        List<UnidadOrganizativaMinimal> unidadesOrg = new ArrayList<>();
        if (userGroup == null) {
            unidadesOrg = this.grupoRepository.findAllGroups("codigo", "ASC");
        } else {
            Collection<UnidadOrganizativaMinimal> col = recursiveHirarchyGroupsMap(userGroup).values();
            if (col != null) {
                unidadesOrg.addAll(col);
            }
        }
        Collections.sort(unidadesOrg, new UnOrganizativaComparator());
        return unidadesOrg;
    }

    public final List<UnidadOrganizativaMinimal> getHierarchyUntilOrganismo(final String codigo) {
        List<UnidadOrganizativaMinimal> unidadesOrg = new ArrayList<>();
        if (codigo != null) {
            // recuperar el organismo de esta unidad organizativa
            Grupo organismo = getOrganismo(codigo);
            Collection<UnidadOrganizativaMinimal> col = recursiveHirarchyGroupsMap(organismo).values();
            if (col != null) {
                unidadesOrg.addAll(col);
            }
        }
        Collections.sort(unidadesOrg, new UnOrganizativaComparator());
        return unidadesOrg;
    }

    public final List<UnidadOrganizativaMinimal> getGruposOfCenter(final String codigoSILCONdpto) {
        List<UnidadOrganizativaMinimal> unidadesOrg = new ArrayList<>();
        if (codigoSILCONdpto != null && codigoSILCONdpto.contentEquals("*")) {
            unidadesOrg = grupoRepository.findAllGroups("codigo", "ASC");
        } else if (codigoSILCONdpto != null) {
            // recuperar el centro de este codigoSILCONdpto
            Grupo centro = getCentroSuperior(codigoSILCONdpto);
            Collection<UnidadOrganizativaMinimal> col = recursiveHirarchyGroupsMap(centro).values();
            if (col != null) {
                unidadesOrg.addAll(col);
            }
        }
        Collections.sort(unidadesOrg, new UnOrganizativaComparator());
        return unidadesOrg;
    }

    public final Grupo getOrganismo(final String codeOfDpto) {
        Grupo returnedGroup = null;
        Grupo grupo = getByCode(codeOfDpto);
        if (grupo.getParentGroupId() == null) {
            returnedGroup = grupo;
        } else if (grupo.getParentGroupId() != null) {
            Grupo grupoPadre = getById(grupo.getParentGroupId());
            if (grupoPadre != null) {
                returnedGroup = getOrganismo(grupoPadre.getCodigo());
            }
        }
        return returnedGroup;
    }

    public final Grupo getCentroSuperior(final String codeOfDpto) {
        Grupo returnedGroup = null;
        Grupo grupo = getByCode(codeOfDpto);
        if (grupo.getTipoId() != null && grupo.getTipoId().intValue() == TipoUnidadOrganizativa.CENTRO) {
            returnedGroup = grupo;
        } else if (grupo.getParentGroupId() != null) {
            Grupo grupoPadre = getById(grupo.getParentGroupId());
            if (grupoPadre != null) {
                returnedGroup = getCentroSuperior(grupoPadre.getCodigo());
            }
        }
        return returnedGroup;
    }


    public final Grupo getAreaSuperior(final String codeOfDpto) {
        Grupo returnedGroup = null;
        Grupo grupo = getByCode(codeOfDpto);
        if (grupo.getTipoId() != null &&  grupo.getTipoId().intValue() == TipoUnidadOrganizativa.AREA) {
            returnedGroup = grupo;
        } else if (grupo.getParentGroupId() != null) {
            Grupo grupoPadre = getById(grupo.getParentGroupId());
            if (grupoPadre != null) {
                returnedGroup = getAreaSuperior(grupoPadre.getCodigo());
            }
        }
        return returnedGroup;
    }

    private Map<Integer, UnidadOrganizativaMinimal> recursiveHirarchyGroupsMap(final Grupo grupo) {
        String centro = grupo.getTipoId() != null && grupo.getTipoId().intValue() == TipoUnidadOrganizativa.CENTRO
                ? grupo.getName()
                : (getCentroSuperior(grupo.getCodigo()) == null ? ""
                : getCentroSuperior(grupo.getCodigo()).getName());
        List<Integer> gruposChilren = grupo.getChildrenIds();
        Map<Integer, UnidadOrganizativaMinimal> retorno = new HashMap<>();
        if (gruposChilren == null || gruposChilren.isEmpty()) {
            UnidadOrganizativaMinimal nuevaItem = new UnidadOrganizativaMinimal(grupo.getId(),
                    grupo.getCodigo(), grupo.getName(), centro);
            retorno.put(grupo.getId(), nuevaItem);
        } else {
            UnidadOrganizativaMinimal nuevaItem = new UnidadOrganizativaMinimal(grupo.getId(),
                    grupo.getCodigo(), grupo.getName(), centro);
            retorno.put(grupo.getId(), nuevaItem);
            for (Integer subElementId : gruposChilren) {
                Grupo subElement = getById(subElementId);
                if (subElement.getDeleted() == null || subElement.getDeleted().intValue() == 0) {
                    retorno.putAll(recursiveHirarchyGroupsMap(subElement));
                }
            }
        }
        return retorno;
    }

    @Transactional
    public final Grupo alta(final Grupo grupo) {
        grupo.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        Grupo grupoInserted = this.grupoRepository.save(grupo);
        if (grupoInserted != null && cacheManager != null && !cacheManager.getCacheNames().isEmpty()) {
            // for tests-compliance
            Cache cache = this.cacheManager.getCache(Constantes.GRUPOS_ORG_CACHE);
            cache.put(grupoInserted.getCodigo(), grupoInserted);
        }
        return grupoInserted;
    }

    @Transactional
    public final Grupo update(final Grupo grupo) {
        if (grupo.getId() == null) {
            throw new IllegalArgumentException("el campo de clave primaria ID no viene en el registro a modificar");
        }
        Grupo updatedObject = null;
        Grupo grupoBBDD = this.getById(grupo.getId());
        if (grupoBBDD != null) {
            Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTime().getTime());
            grupo.setUpdateDate(timeStamp);
            grupo.setCreationDate(grupoBBDD.getCreationDate());
            updatedObject = this.grupoRepository.save(grupo);
        }
        if (cacheManager != null && !cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
            Cache cache = this.cacheManager.getCache(Constantes.GRUPOS_ORG_CACHE);
            SimpleValueWrapper cachedVal = (SimpleValueWrapper) cache.get(grupo.getCodigo());
            if (cachedVal != null) {
                cache.evict(updatedObject.getCodigo());
                cache.put(updatedObject.getCodigo(), updatedObject);
            }
        }
        return updatedObject;
    }

    @Transactional
    public final Map<Grupo, List<ValidationErrorMessage>> remove(final Integer idGrupo) {
        Grupo grupoRemoved = null;
        List<ValidationErrorMessage> errorMessages = new ArrayList<>();
        Grupo grupoBBDD = this.getById(idGrupo);
        long countElements = this.elementoCatalogoRepository.countByGroupIdAndDeletedIsNull(idGrupo);
        long countDeliveries = this.entregaElementoCatalogoRepository.countByGroupIdAndDeletedIsNull(idGrupo);
        if (grupoBBDD != null) {
            if (countElements > 0) {
                errorMessages.add(new ValidationErrorMessage(
                    "Debe eliminar antes los elementos de catálogo asociados a este grupo"));
            }
            if (countDeliveries > 0) {
                errorMessages.add(new ValidationErrorMessage(
                    "Debe eliminar antes las entregas de los elementos de catálogo asociados a este grupo"));
            }
            if (errorMessages.isEmpty()) {
                Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTime().getTime());
                grupoBBDD.setUpdateDate(timeStamp);
                grupoBBDD.setName(grupoBBDD.getName() + "[deleted]");
                grupoBBDD.setDeleted(1);
                grupoRemoved = this.grupoRepository.save(grupoBBDD);
            }
        }
        Map<Grupo, List<ValidationErrorMessage>> retorno = new HashMap<>();
        retorno.put(grupoRemoved, errorMessages);
        if (errorMessages.isEmpty() && cacheManager != null && !cacheManager.getCacheNames().isEmpty()) {
            //for tests-compliance
            Cache cache = this.cacheManager.getCache(Constantes.GRUPOS_ORG_CACHE);
            SimpleValueWrapper cachedVal = (SimpleValueWrapper) cache.get(grupoRemoved.getCodigo());
            if (cachedVal != null) {
                cache.evict(grupoRemoved.getCodigo());
            }
        }
        return retorno;
    }

    /**
     * Retorna verdadero si el grupo pasado como primer argumento se encuentra bajo la jerarquía del segundo,
     * o si ambos tienen el mismo código SILCON.
     * Retorna falso en caso contrario
     * @return
     */
    public final boolean estaContenido(final Grupo candidatoDescendent, final Grupo grupoSuperior) {
        boolean retorno;
        if (grupoSuperior == null) { //rol admin
            retorno = true;
        } else if (candidatoDescendent.getTipoId() != null && grupoSuperior.getTipoId() != null
            && candidatoDescendent.getTipoId().intValue() > grupoSuperior.getTipoId().intValue()) {
            retorno = false;
        } else {
            //vamos a subir en la jerarquía del candidato hasta nivel organismo;
            // si no hemos encontrado al candidato de unidad superior, retornamos false
            // en cuanto lo encontremos, retornamos true y paramos la recursividad
            retorno = searchUnidadSuperior(candidatoDescendent, grupoSuperior);
        }
        return retorno;
    }

    public final boolean searchUnidadSuperior(final Grupo candidatoHijo, final Grupo searched) {
        Boolean retorno = false;
        if (candidatoHijo.getId().intValue() == searched.getId().intValue()) {
            retorno = true;
        } else if (candidatoHijo.getParentGroupId() != null) {
            Grupo parentCandidatoHijo = this.getById(candidatoHijo.getParentGroupId());
            if (parentCandidatoHijo == null) {
                retorno = false; //padre de baja, no sigo buscando
            } else {
                retorno = searchUnidadSuperior(parentCandidatoHijo, searched);
            }
        } else if (candidatoHijo.getParentGroupId() == null) {
            retorno = false;
        }
        return retorno;
    }


}
