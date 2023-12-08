package giss.mad.catalogo.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import giss.mad.catalogo.model.AtributoEjePorTipoElemento;
import giss.mad.catalogo.utilities.Constantes;
import giss.mad.catalogo.model.TipoElementoCatalogo;
import giss.mad.catalogo.repository.AtributoEjePorTipoElementoRepository;
import giss.mad.catalogo.repository.TipoElementoCatalogoRepository;

@Service
public class TipoElementoCatalogoService {

    @Autowired
    private TipoElementoCatalogoRepository tipoElementoCatalogoRepository;

    @Autowired
    private AtributoEjePorTipoElementoRepository atributoEjePorTipoElementoRepository;

    public final void setAtributoEjePorTipoElementoRepository(
        final AtributoEjePorTipoElementoRepository atributoEjePorTipoElementoRepository) {
        this.atributoEjePorTipoElementoRepository = atributoEjePorTipoElementoRepository;
    }

    public final void setTipoElementoCatalogoRepository(
        final TipoElementoCatalogoRepository tipoElementoCatalogoRepository) {
        this.tipoElementoCatalogoRepository = tipoElementoCatalogoRepository;
    }

    public final List<TipoElementoCatalogo> findOnlyTypes() {
        return this.tipoElementoCatalogoRepository.findOnlyTypes();
    }


    public final List<String> getLabelsOrdered() {
        List<String> labelsOrderedById = new ArrayList<>();
        List<TipoElementoCatalogo> c = this.tipoElementoCatalogoRepository.
            findAllByDeletedIsNull(Sort.by(Sort.Order.asc("id")));
        for (TipoElementoCatalogo t : c) {
            labelsOrderedById.add(t.getName());
        }
        return labelsOrderedById;
    }

    public final TipoElementoCatalogo get(final Integer idTipoElementoCat) {
        return this.tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(idTipoElementoCat);
    }

    public final List<TipoElementoCatalogo> getAllWithInfo() {
        return this.tipoElementoCatalogoRepository.findAllByDeletedIsNull(
                Sort.by(Sort.Order.asc("hierarchyLevel")));
    }

    @Transactional
    public final TipoElementoCatalogo insertar(final TipoElementoCatalogo tipoElementoCat) {

        List<AtributoEjePorTipoElemento> listOfAttrs = new ArrayList<>(tipoElementoCat.getAtributosAsociados());
        tipoElementoCat.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        tipoElementoCat.setAtributosAsociados(new ArrayList<>());
        TipoElementoCatalogo tipoElementoCatBBDD = this.tipoElementoCatalogoRepository.save(tipoElementoCat);

        for (AtributoEjePorTipoElemento attrByTipoElem : listOfAttrs) {
            attrByTipoElem.setCatalogElementTypeId(tipoElementoCatBBDD.getId());
            attrByTipoElem.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            attrByTipoElem.setForCatalogue(Constantes.NUMBER_1);
            attrByTipoElem.setForDelivery(Constantes.NUMBER_1);
        }
        tipoElementoCat.setAtributosAsociados(listOfAttrs);
        return this.tipoElementoCatalogoRepository.save(tipoElementoCat);
    }

    @Transactional
    public final TipoElementoCatalogo actualizar(final TipoElementoCatalogo tipoElementoCat) {
        if (tipoElementoCat.getId() == null) {
            throw new IllegalArgumentException("el campo de clave primaria ID no viene en el registro a modificar");
        }
        List<AtributoEjePorTipoElemento> nuevosAttrs = new ArrayList(tipoElementoCat.getAtributosAsociados());
        TipoElementoCatalogo tipoElementoCatBBDD = this.tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(
            tipoElementoCat.getId());
        List<AtributoEjePorTipoElemento> listaAntiguaAttrs = new ArrayList<>(
            tipoElementoCatBBDD.getAtributosAsociados());
        for (AtributoEjePorTipoElemento attrByTipoElem : nuevosAttrs) {
            AtributoEjePorTipoElemento nuevoAtributo = buscarAtributoAsociado(listaAntiguaAttrs,
                attrByTipoElem.getAxisAttributeId());
            if (nuevoAtributo == null) {
                // damos de insertar el elemento
                attrByTipoElem.setCatalogElementTypeId(tipoElementoCat.getId());
                attrByTipoElem.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
                attrByTipoElem.setForCatalogue(attrByTipoElem.getForCatalogue());
                attrByTipoElem.setForDelivery(attrByTipoElem.getForDelivery());
            } else {
                attrByTipoElem.setId(nuevoAtributo.getId());
                attrByTipoElem.setCreationDate(nuevoAtributo.getCreationDate());
                attrByTipoElem.setForCatalogue(attrByTipoElem.getForCatalogue());
                attrByTipoElem.setForDelivery(attrByTipoElem.getForDelivery());
            }
        }

        tipoElementoCat.setCreationDate(tipoElementoCatBBDD.getCreationDate());
        tipoElementoCat.setHierarchyLevel(tipoElementoCatBBDD.getHierarchyLevel());
        tipoElementoCat.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        tipoElementoCat.setAtributosAsociados(nuevosAttrs);
        this.tipoElementoCatalogoRepository.save(tipoElementoCat);

        // eliminamos los elementos que ya no viajan en la actualización
        for (AtributoEjePorTipoElemento attrByTipoElem : listaAntiguaAttrs) {
            AtributoEjePorTipoElemento antiguoAttr = buscarAtributoAsociado(nuevosAttrs,
                attrByTipoElem.getAxisAttributeId());
            if (antiguoAttr == null) {
                // lo eliminamos de la tabla N_M
                this.atributoEjePorTipoElementoRepository.deleteById(attrByTipoElem.getId());
            }
        }
        return tipoElementoCat;
    }

    private AtributoEjePorTipoElemento buscarAtributoAsociado(final List<AtributoEjePorTipoElemento> attrs,
        final Integer axisIdAtr) {
        AtributoEjePorTipoElemento searched = null;
        boolean found = false;
        int i = 0;
        while (!found && i < attrs.size()) {
            AtributoEjePorTipoElemento attrByTipoElem = attrs.get(i);
            if (attrByTipoElem.getAxisAttributeId().intValue() == axisIdAtr.intValue()) {
                searched = attrByTipoElem;
                found = true;
            }
            i++;
        }
        return searched;
    }

    @Transactional
    public final TipoElementoCatalogo borradoLogico(final Integer idTipoElementoCat) {
        TipoElementoCatalogo removedObject = null;
        Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTime().getTime());
        TipoElementoCatalogo tipoElementoCat = this.tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(
            idTipoElementoCat);
        List<AtributoEjePorTipoElemento> listaAntiguaAttrs = new ArrayList<>(tipoElementoCat.getAtributosAsociados());
        for (AtributoEjePorTipoElemento attrByTipoElem : tipoElementoCat.getAtributosAsociados()) {
            attrByTipoElem.setUpdateDate(timeStamp);
            attrByTipoElem.setDeleted(Constantes.NUMBER_1);
        }
        tipoElementoCat.setUpdateDate(timeStamp);
        tipoElementoCat.setName(tipoElementoCat.getName() + "[deleted at " + timeStamp.getTime() + "]");
        tipoElementoCat.setDeleted(Constantes.NUMBER_1);
        removedObject = this.tipoElementoCatalogoRepository.save(tipoElementoCat);

        // eliminamos los elementos que ya no tienen que ocupar espacio
        for (AtributoEjePorTipoElemento attrByTipoElem : listaAntiguaAttrs) {
            // lo eliminamos de la tabla N_M
            this.atributoEjePorTipoElementoRepository.deleteById(attrByTipoElem.getId());
        }
        return removedObject;
    }

  /*@Transactional
  public final TipoElementoCatalogo removePhysical(final Integer idTipoElementoCat) {
    TipoElementoCatalogo tipoEl = this.tipoElementoCatalogoRepository.findById(idTipoElementoCat).get();
    this.tipoElementoCatalogoRepository.delete(tipoEl);
    return tipoEl;
  }*/

}

