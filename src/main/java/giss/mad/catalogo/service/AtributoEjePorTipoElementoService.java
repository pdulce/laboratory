package giss.mad.catalogo.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import giss.mad.catalogo.model.AtributoEjePorTipoElemento;
import giss.mad.catalogo.utilities.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Service;

import giss.mad.catalogo.repository.AtributoEjePorTipoElementoRepository;
import giss.mad.catalogo.repository.AtributoEjeRepository;
import giss.mad.catalogo.repository.ElementoCatalogoRepository;
import giss.mad.catalogo.repository.ValorDominioRepository;
import giss.mad.catalogo.repository.ValoresEjesDeElemenCatalogoUsuarioRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AtributoEjePorTipoElementoService {

    @Autowired
    private AtributoEjePorTipoElementoRepository atributoEjePorTipoElementoRepository;

    @Autowired
    private ValoresEjesDeElemenCatalogoUsuarioRepository valoresEjesDeElemenCatalogoUsuarioRepository;

    @Autowired
    private ElementoCatalogoRepository elementoCatalogoRepository;
    @Autowired
    private AtributoEjeRepository atributoEjeRepository;

    @Autowired
    private ValorDominioRepository valorDominioRepository;

    @Autowired
    private CacheManager cacheManager;

    public final void setCacheManager(final CacheManager cacheManagerIn) {
        this.cacheManager = cacheManagerIn;
    }
    public final void setValorDominioRepository(final ValorDominioRepository valorDominioRepository) {
        this.valorDominioRepository = valorDominioRepository;
    }

    public final void setAtributoEjePorTipoElementoRepository(
        final AtributoEjePorTipoElementoRepository atributoEjePorTipoElementoRepository) {
        this.atributoEjePorTipoElementoRepository = atributoEjePorTipoElementoRepository;
    }

    public final void setValoresEjesDeElemenCatalogoUsuarioRepository(
        final ValoresEjesDeElemenCatalogoUsuarioRepository valoresEjesDeElemenCatalogoUsuarioRepository) {
        this.valoresEjesDeElemenCatalogoUsuarioRepository = valoresEjesDeElemenCatalogoUsuarioRepository;
    }

    public final void setElementoCatalogoRepository(
        final ElementoCatalogoRepository elementoCatalogoRepository) {
        this.elementoCatalogoRepository = elementoCatalogoRepository;
    }

    public final void setAtributoEjeRepository(final AtributoEjeRepository atributoEjeRepository) {
        this.atributoEjeRepository = atributoEjeRepository;
    }

    public final List<AtributoEjePorTipoElemento> getAll() {
        return this.atributoEjePorTipoElementoRepository.findAllByDeletedIsNull();
    }

    public final AtributoEjePorTipoElemento get(final Integer idAtributoEje) {
        return this.atributoEjePorTipoElementoRepository.findByIdAndDeletedIsNull(idAtributoEje);
    }

    @Transactional
    public final AtributoEjePorTipoElemento insertar(final AtributoEjePorTipoElemento attr) {
        attr.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        AtributoEjePorTipoElemento savedNew = this.atributoEjePorTipoElementoRepository.save(attr);
        if (this.cacheManager != null) {
            Cache cacheListOfAttributes = cacheManager.getCache(Constantes.ATRIBUTOS_POR_TIPOELEM_CACHE);
            Integer cacheKey = Integer.parseInt(String.valueOf(savedNew.getCatalogElementTypeId()).concat("1"));
            SimpleValueWrapper cachedVal = (SimpleValueWrapper) cacheListOfAttributes.get(cacheKey);
            if (cachedVal != null) {
                cacheListOfAttributes.evict(cacheKey);
            }
            Integer cacheKey2 = Integer.parseInt(String.valueOf(savedNew.getCatalogElementTypeId()).concat("0"));
            SimpleValueWrapper cachedVal2 = (SimpleValueWrapper) cacheListOfAttributes.get(cacheKey);
            if (cachedVal2 != null) {
                cacheListOfAttributes.evict(cacheKey2);
            }
        }
        return savedNew;
    }

    @Transactional
    public final AtributoEjePorTipoElemento update(final AtributoEjePorTipoElemento attr) {
        if (attr.getId() == null) {
            throw new IllegalArgumentException("el campo de clave primaria ID no viene en el registro a modificar");
        }
        AtributoEjePorTipoElemento attribute = this.atributoEjePorTipoElementoRepository.findByIdAndDeletedIsNull(
            attr.getId());
        if (attribute != null) {
            attribute.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            attribute = this.atributoEjePorTipoElementoRepository.save(attribute);
            if (this.cacheManager != null) {
                Cache cacheListOfAttributes = cacheManager.getCache(Constantes.ATRIBUTOS_POR_TIPOELEM_CACHE);
                Integer cacheKey = Integer.parseInt(String.valueOf(attribute.getCatalogElementTypeId()).concat("1"));
                SimpleValueWrapper cachedVal = (SimpleValueWrapper) cacheListOfAttributes.get(cacheKey);
                if (cachedVal != null) {
                    cacheListOfAttributes.evict(cacheKey);
                }
                Integer cacheKey2 = Integer.parseInt(String.valueOf(attribute.getCatalogElementTypeId()).concat("0"));
                SimpleValueWrapper cachedVal2 = (SimpleValueWrapper) cacheListOfAttributes.get(cacheKey);
                if (cachedVal2 != null) {
                    cacheListOfAttributes.evict(cacheKey2);
                }
            }
        }
        return attribute;
    }

    @Transactional
    public final AtributoEjePorTipoElemento remove(final Integer attrId) {
        AtributoEjePorTipoElemento toDelete = this.atributoEjePorTipoElementoRepository.findByIdAndDeletedIsNull(
            attrId);
        if (toDelete != null) {
            Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTime().getTime());
            toDelete.setUpdateDate(timeStamp);
            toDelete.setDeleted(1);
            toDelete = this.atributoEjePorTipoElementoRepository.save(toDelete);
            if (this.cacheManager != null) {
                Cache cacheListOfAttributes = cacheManager.getCache(Constantes.ATRIBUTOS_POR_TIPOELEM_CACHE);
                Integer cacheKey = Integer.parseInt(String.valueOf(toDelete.getCatalogElementTypeId()).concat("1"));
                SimpleValueWrapper cachedVal = (SimpleValueWrapper) cacheListOfAttributes.get(cacheKey);
                if (cachedVal != null) {
                    cacheListOfAttributes.evict(cacheKey);
                }
                Integer cacheKey2 = Integer.parseInt(String.valueOf(toDelete.getCatalogElementTypeId()).concat("0"));
                SimpleValueWrapper cachedVal2 = (SimpleValueWrapper) cacheListOfAttributes.get(cacheKey);
                if (cachedVal2 != null) {
                    cacheListOfAttributes.evict(cacheKey2);
                }
            }
        }
        return toDelete;
    }

  /*@Transactional
  public final void removePhysical(final Integer idattr) {
      this.atributoEjePorTipoElementoRepository.deleteById(idattr);
  }*/

}
