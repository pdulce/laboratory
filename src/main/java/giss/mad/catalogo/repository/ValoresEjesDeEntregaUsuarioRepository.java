package giss.mad.catalogo.repository;

import java.util.List;

import giss.mad.catalogo.model.auxejes.AttributeValDomain;
import giss.mad.catalogo.model.auxejes.AxisValDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import giss.mad.catalogo.model.ValoresEjesDeEntregaUsuario;

@Repository
public interface ValoresEjesDeEntregaUsuarioRepository extends
    JpaRepository<ValoresEjesDeEntregaUsuario, Integer> {

    @Query(value = "SELECT NEW giss.mad.catalogo.model.auxejes.AxisValDomain(vda.id, vda.axisAttributeId, "
            + "vdaDom.domainValueId) "
            + "FROM ValoresEjesDeEntregaUsuario vda "
            + "JOIN "
            + "ValorDominioDeAttrEntrega vdaDom ON vda.id = vdaDom.valorEjeEntregaId "
            + "JOIN "
            + "AtributoEje attr ON attr.id = vda.axisAttributeId AND attr.axis = 1 "
            + "WHERE vda.deliveryCatalogElementId= :id AND vdaDom.domainValueId IS NOT NULL AND vda.deleted IS NULL"
    )
    List<AxisValDomain> getAxisListByIdOfRelease(Integer id);

    @Query(value = "SELECT NEW giss.mad.catalogo.model.auxejes.AttributeValDomain(vda.id || '|' || "
            + "vda.axisAttributeId || '|' || vda.creationDate || '|' || vda.userValue || '|' || "
            + "vdaDom.id || '|' || vdaDom.domainValueId || '|' || vdaDom.creationDate || '|' || "
            + "attr.readOnly || '|' || attr.hidden) "
            + "FROM ValoresEjesDeEntregaUsuario vda "
            + "JOIN "
            + "ValorDominioDeAttrEntrega vdaDom ON vda.id = vdaDom.valorEjeEntregaId "
            + "JOIN "
            + "AtributoEje attr ON attr.id = vda.axisAttributeId "
            + "WHERE vda.deliveryCatalogElementId= :id AND attr.deleted IS NULL AND "
            + "vda.deleted IS NULL ORDER BY vda.axisAttributeId ASC"
    )
    List<AttributeValDomain> getAttributesListByIdOfRelease(Integer id);




    /****** SUSTITUIR POR NUEVOS METODOS OPTIMIZADOS *****/

    List<ValoresEjesDeEntregaUsuario> findAllByDeletedIsNull();

    ValoresEjesDeEntregaUsuario findByIdAndDeletedIsNull(Integer id);

}

