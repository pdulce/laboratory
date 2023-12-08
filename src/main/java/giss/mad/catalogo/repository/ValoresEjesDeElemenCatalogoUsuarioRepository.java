package giss.mad.catalogo.repository;

import java.util.List;

import giss.mad.catalogo.model.auxejes.AttributeValDomain;
import giss.mad.catalogo.model.auxejes.AxisValDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import giss.mad.catalogo.model.ValoresEjesDeElemenCatalogoUsuario;

@Repository
public interface ValoresEjesDeElemenCatalogoUsuarioRepository extends
    JpaRepository<ValoresEjesDeElemenCatalogoUsuario, Integer> {

    List<ValoresEjesDeElemenCatalogoUsuario> findAllByDeletedIsNull();
    ValoresEjesDeElemenCatalogoUsuario findByIdAndDeletedIsNull(Integer id);

    @Query(value = "SELECT NEW giss.mad.catalogo.model.auxejes.AxisValDomain(vda.id, vda.axisAttributeId, "
            + "vdaDom.domainValueId) "
            + "FROM ValoresEjesDeElemenCatalogoUsuario vda "
            + "JOIN "
            + "ValorDominioDeAttrElemCat vdaDom ON vda.id = vdaDom.valorEjeElemCatId "
            + "JOIN "
            + "AtributoEje attr ON attr.id = vda.axisAttributeId AND attr.axis = 1 "
            + "WHERE vda.catalogElementId= :id AND vdaDom.domainValueId IS NOT NULL AND vda.deleted IS NULL "
            + "AND attr.deleted IS NULL"
    )
    List<AxisValDomain> getAxisListByIdOfElement(Integer id);

    @Query(value = "SELECT NEW giss.mad.catalogo.model.auxejes.AttributeValDomain(vda.id, vda.axisAttributeId, "
            + "vda.creationDate, vda.userValue, vdaDom.id, vdaDom.domainValueId, vdaDom.creationDate) "
            + "FROM ValoresEjesDeElemenCatalogoUsuario vda "
            + "JOIN "
            + "ValorDominioDeAttrElemCat vdaDom ON vda.id = vdaDom.valorEjeElemCatId "
            + "JOIN "
            + "AtributoEje attr ON attr.id = vda.axisAttributeId "
            + "WHERE vda.catalogElementId= :id AND attr.deleted IS NULL AND "
            + "vda.deleted IS NULL ORDER BY vda.axisAttributeId ASC"
    )
    List<AttributeValDomain> getAttributesListByIdOfElement(Integer id);

    @Query("SELECT COUNT(*) "
            + "FROM AtributoEjePorTipoElemento attrByType "
            + "JOIN AtributoEje attr ON attr.id = attrByType.axisAttributeId AND attr.mandatory = 1 "
            + "WHERE attrByType.catalogElementTypeId = :elementTypeId "
            + "AND attrByType.forCatalogue = 1 and attrByType.deleted IS NULL AND attr.deleted IS NULL"
    )
    Integer getNumberOfAttrsMandatoryOfThisTypeOfElement(Integer elementTypeId);

    @Query("SELECT COUNT(*) "
            + "FROM ValoresEjesDeElemenCatalogoUsuario vda "
            + "JOIN AtributoEje attr ON attr.id = vda.axisAttributeId AND attr.mandatory = 1 "
            + "JOIN AtributoEjePorTipoElemento attrByType ON vda.axisAttributeId = attrByType.axisAttributeId "
            + "AND attrByType.catalogElementTypeId = :elementTypeId "
            + "WHERE vda.catalogElementId= :elementId AND vda.deleted IS NULL and attr.deleted IS NULL")
    Integer getMandatoryAttrsIds(Integer elementId, Integer elementTypeId);

}

