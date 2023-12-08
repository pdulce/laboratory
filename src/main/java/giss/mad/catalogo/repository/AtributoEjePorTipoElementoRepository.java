package giss.mad.catalogo.repository;

import java.util.List;

import giss.mad.catalogo.model.AtributoEje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import giss.mad.catalogo.model.AtributoEjePorTipoElemento;

@Repository
public interface AtributoEjePorTipoElementoRepository extends
    JpaRepository<AtributoEjePorTipoElemento, Integer> {

    List<AtributoEjePorTipoElemento> findAllByDeletedIsNull();

    AtributoEjePorTipoElemento findByIdAndDeletedIsNull(Integer id);

    List<AtributoEjePorTipoElemento> findAllByAxisAttributeId(Integer axisAttributeId);

    @Query("SELECT b FROM AtributoEje b, AtributoEjePorTipoElemento a WHERE b.id = a.axisAttributeId"
            + " AND a.catalogElementTypeId = :catalogElementTypeId AND a.forCatalogue = 1 AND a.deleted IS NULL"
            + " AND b.code != 'ATTR1' AND b.code != 'ATTR3' ORDER BY b.axis DESC, b.code ASC")
    List<AtributoEje> getAtributosOrdenadosForElementType(Integer catalogElementTypeId);

    @Query("SELECT b FROM AtributoEje b, AtributoEjePorTipoElemento a WHERE b.id = a.axisAttributeId"
            + " AND a.catalogElementTypeId = :catalogElementTypeId AND a.forDelivery = 1 AND a.deleted IS NULL"
            + " AND b.code != 'ATTR1' AND b.code != 'ATTR3' ORDER BY b.axis DESC, b.code ASC")
    List<AtributoEje> getAtributosOrdenadosForDelivery(Integer catalogElementTypeId);


    @Query("SELECT COUNT(b) FROM AtributoEje b, AtributoEjePorTipoElemento a WHERE b.id = a.axisAttributeId"
            + " AND a.catalogElementTypeId = :catalogElementTypeId AND a.forCatalogue = 1 AND a.deleted IS NULL"
            + " AND b.code != 'ATTR1' AND b.code != 'ATTR3' AND a.axisAttributeId IN :idsValuesCol"
    )
    Integer countAtributosContenidosForElementType(Integer catalogElementTypeId, List<Integer> idsValuesCol);

    @Query("SELECT COUNT(b) FROM AtributoEje b, AtributoEjePorTipoElemento a WHERE b.id = a.axisAttributeId"
            + " AND a.catalogElementTypeId = :catalogElementTypeId AND a.forDelivery = 1 AND a.deleted IS NULL"
            + " AND b.code != 'ATTR1' AND b.code != 'ATTR3' AND a.axisAttributeId IN :idsValuesCol"
    )
    Integer countAtributosContenidosForDelivery(Integer catalogElementTypeId, List<Integer> idsValuesCol);

    List<AtributoEjePorTipoElemento> findAllByDeletedIsNullAndCatalogElementTypeIdAndAxisAttributeId(
        Integer catalogElementType, Integer axisAttributeId);

}

