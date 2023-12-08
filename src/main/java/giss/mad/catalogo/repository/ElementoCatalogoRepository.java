package giss.mad.catalogo.repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import giss.mad.catalogo.model.auxejes.SimplifiedAttribute;
import giss.mad.catalogo.model.filters.ElementoCatalogoFilter;
import giss.mad.catalogo.model.filters.SimplifiedElement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import giss.mad.catalogo.model.ElementoCatalogo;
import giss.mad.catalogo.model.filters.ElementoCatalogoMinimal;

@Repository
public interface ElementoCatalogoRepository extends JpaRepository<ElementoCatalogo, Integer> {

    /** Nuevas querys HQL optimizadas para versión a PRO***/
    @Query(value = "SELECT new giss.mad.catalogo.model.filters.ElementoCatalogoMinimal(e.id, e.name, e.cappCode) "
            + "FROM ElementoCatalogo e "
            + "WHERE e.catalogElementCollateralId = :idParent"
    )
    List<ElementoCatalogoMinimal> getChildrenOfIdParent(Integer idParent);

    @Query("SELECT new giss.mad.catalogo.model.filters.SimplifiedElement(ele.id, ele.cappCode, ele.name, "
            + "ele.catalogElementTypeId, ele.groupId) FROM ElementoCatalogo ele "
            + "WHERE (:groupId IS NULL OR ele.groupId = :groupId) "
            + "AND (:typeId IS NULL OR ele.catalogElementTypeId = :typeId) "
            + "AND (:code IS NULL OR ele.cappCode LIKE %:code%) "
            + "AND ele.deleted IS NULL")
    List<SimplifiedElement> findFilteredSimplifiedElements(@Param("groupId") Integer groupId,
                                                           @Param("typeId") Integer typeId,
                                                           @Param("code") String code);


    @Query("SELECT new giss.mad.catalogo.model.filters.SimplifiedElement(ele.id, ele.cappCode, ele.name, "
            + "ele.catalogElementTypeId, ele.groupId) FROM ElementoCatalogo ele "
            + "INNER JOIN ValoresEjesDeElemenCatalogoUsuario atrVal ON atrVal.catalogElementId = ele.id "
            + "INNER JOIN ValorDominioDeAttrElemCat domVal ON domVal.valorEjeElemCatId = atrVal.id "
            + "WHERE (atrVal.axisAttributeId = 40 AND atrVal.deleted IS NULL AND "
            + "domVal.domainValueId = :computerProcessingId) "
            + "AND (:groupId IS NULL OR ele.groupId = :groupId) "
            + "AND (:typeId IS NULL OR ele.catalogElementTypeId = :typeId) "
            + "AND (:code IS NULL OR ele.cappCode LIKE %:code%) AND ele.deleted IS NULL")
    List<SimplifiedElement> findFilteredSimplifiedElementsCompProcessing(@Param("code") String code,
                                                                         @Param("groupId") Integer groupId,
                                                                         @Param("typeId") Integer typeId,
                                                                         @Param("computerProcessingId")
                                                                         Integer computerProcessingId);

    @Query("SELECT new giss.mad.catalogo.model.filters.SimplifiedElement(ele.id, ele.cappCode, ele.name, "
            + "ele.catalogElementTypeId, ele.groupId) FROM ElementoCatalogo ele WHERE ele.deleted IS NULL")
    List<SimplifiedElement> findSimplifiedElements();


    @Query(value = "SELECT NEW giss.mad.catalogo.model.auxejes.SimplifiedAttribute(e.cappCode, attr.name, val.name) "
            + "FROM ElementoCatalogo e "
            + "LEFT JOIN "
          + "ValoresEjesDeElemenCatalogoUsuario vda ON e.id = vda.catalogElementId AND vda.axisAttributeId = :attrId "
            + "LEFT JOIN "
            + "ValorDominioDeAttrElemCat vdaDom ON vdaDom.valorEjeElemCatId = vda.id "
            + "LEFT JOIN "
            + "AtributoEje attr ON attr.id = vda.axisAttributeId "
            + "LEFT JOIN "
            + "ValorDominio val ON val.id = vdaDom.domainValueId AND val.axisAttributeId = :attrId "
            + "WHERE e.cappCode = :cappCode"
    )
    SimplifiedAttribute getValDominioOfAttr(String cappCode, Integer attrId);


    @Query(value = "SELECT NEW giss.mad.catalogo.model.auxejes.SimplifiedAttribute(e.cappCode, attr.name, "
            + "vda.userValue) "
            + "FROM ElementoCatalogo e "
            + "LEFT JOIN "
         + "ValoresEjesDeElemenCatalogoUsuario vda ON e.id = vda.catalogElementId AND vda.axisAttributeId = :attrId "
            + "LEFT JOIN "
            + "AtributoEje attr ON attr.id = vda.axisAttributeId "
            + "WHERE e.cappCode = :cappCode AND e.deleted IS NULL"
    )
    SimplifiedAttribute getUserValueOfAttr(String cappCode, Integer attrId);

    @Query(value = "SELECT NEW giss.mad.catalogo.model.filters.SimplifiedElement(e.id, e.cappCode, e.name, e.groupId, "
            + "e.respManagementId, e.respDevelopmentId) "
            + "FROM ElementoCatalogo e "
            + "WHERE e.id= :id"
    )
    SimplifiedElement getSimplifiedElement(Integer id);


    @Query("SELECT new giss.mad.catalogo.model.filters.ElementoCatalogoMinimal(ele.id, ele.name, ele.cappCode) FROM "
            + "ElementoCatalogo ele WHERE ele.deleted IS NULL AND ele.catalogElementTypeId IN :tiposElement "
            + "AND ele.groupId IN :groupsId ORDER BY ele.cappCode ASC"
    )
    List<ElementoCatalogoMinimal> getElementNameAndCappByGroup(@Param("tiposElement") List<Integer> tiposElement,
                                                               @Param("groupsId") List<Integer> groupsId);

    @Query("SELECT new giss.mad.catalogo.model.filters.ElementoCatalogoMinimal(ele.id, ele.name, ele.cappCode) FROM "
            + "ElementoCatalogo ele WHERE ele.deleted IS NULL AND ele.catalogElementTypeId IN :tiposElement"
            + " ORDER BY ele.cappCode ASC")
    List<ElementoCatalogoMinimal> getElementNameAndCapp(@Param("tiposElement") List<Integer> tiposElement);

    @Query("SELECT new giss.mad.catalogo.model.filters.ElementoCatalogoMinimal(ele.id, ele.name, ele.cappCode) FROM "
            + "ElementoCatalogo ele WHERE ele.deleted IS NULL AND ele.catalogElementCollateralId IS NULL"
            + " AND ele.catalogElementTypeId IN :tiposElement AND ele.groupId IN :groupsId ORDER BY ele.cappCode ASC"
    )
    List<ElementoCatalogoMinimal> getFreeElementNameAndCappByGroup(@Param("tiposElement") List<Integer> tiposElement,
                                                                   @Param("groupsId") List<Integer> groupsId);

    @Query("SELECT new giss.mad.catalogo.model.filters.ElementoCatalogoMinimal(ele.id, ele.name, ele.cappCode) FROM "
            + "ElementoCatalogo ele WHERE ele.deleted IS NULL AND ele.catalogElementCollateralId IS NULL"
            + " AND ele.catalogElementTypeId IN :tiposElement ORDER BY ele.cappCode ASC")
    List<ElementoCatalogoMinimal> getFreeElementNameAndCapp(@Param("tiposElement") List<Integer> tiposElement);

    @Query("SELECT new giss.mad.catalogo.model.ElementoCatalogo(ele.id, ele.name, ele.cappCode, "
        + "ele.catalogElementCollateralId, ele.groupId, ele.creationDate, ele.updateDate) FROM ElementoCatalogo ele "
        + "LEFT JOIN Grupo grupo ON ele.groupId = grupo.id "
        + "LEFT JOIN ValoresEjesDeElemenCatalogoUsuario vecu ON ele.id = vecu.catalogElementId AND "
        + "vecu.axisAttributeId = :#{#concatenated['axisAttribute']} "
        + "LEFT JOIN ValorDominioDeAttrElemCat vac ON vecu.id = vac.valorEjeElemCatId AND "
        + "vac.domainValueId = :#{#concatenated['domainValue']} "
        + "INNER JOIN ValoresEjesDeElemenCatalogoUsuario valoresEjes ON valoresEjes.catalogElementId = ele.id "
        + "INNER JOIN AtributoEje atributoEje ON atributoEje.id = valoresEjes.axisAttributeId "
        + "WHERE "
        + "(:#{#concatenated['group']} IS NULL OR (ele.groupId IS NOT NULL AND UPPER(grupo.name) "
        + "LIKE %:#{#concatenated['group']}%)) AND ele.catalogElementTypeId = :#{#concatenated['typeId']} AND "
        + "(:#{#concatenated['cappCode']} LIKE '%null' OR "
        + " ele.cappCode LIKE CONCAT('%', :#{#concatenated['cappCode']}, '%')) AND "
        + "(:#{#concatenated['name']} IS NULL OR (ele.name IS NOT NULL AND UPPER(ele.name) "
            + "LIKE %:#{#concatenated['name']}%)) AND (:#{#concatenated['domainValue']} IS NULL "
            + "OR (vecu.axisAttributeId = :#{#concatenated['axisAttribute']} "
            + "AND vac.domainValueId = :#{#concatenated['domainValue']})) AND ele.deleted IS NULL AND "
            + "(:startDate IS NULL OR (ele.creationDate BETWEEN :startDate AND :endDate)) AND "
            + "(:#{#concatenated['description']} IS NULL OR (valoresEjes.axisAttributeId = 26 "
            + "AND valoresEjes.userValue IS NOT NULL AND "
            + "UPPER(valoresEjes.userValue) LIKE %:#{#concatenated['description']}%)) "
            + "GROUP BY ele.id, ele.name, ele.cappCode, ele.catalogElementCollateralId, "
            + "ele.groupId, ele.creationDate, ele.updateDate"
    )
    Page<ElementoCatalogo> getMinimalInfoForListingWithCappOrName(Map<String, Object> concatenated, Date startDate,
                                                                  Date endDate, Pageable pageable);

    @Query(value = "SELECT NEW giss.mad.catalogo.model.filters.ElementoCatalogoFilter(e.catalogElementTypeId,"
       + "CONCAT(g.name, '|', t.name, '|', e.cappCode, '|', e.name, '|', vda28.userValue, '|', vda32.userValue), "
       + " CONCAT(val34.name, '|', val40.name, '|', val55.name), e.deleted, e.creationDate, e.updateDate) FROM "
       + " ElementoCatalogo e "
       + " JOIN Grupo g ON g.id = e.groupId"
       + " JOIN TipoElementoCatalogo t ON t.ID = e.catalogElementTypeId "
       + " LEFT JOIN "
       + "ValoresEjesDeElemenCatalogoUsuario vda28 ON e.id = vda28.catalogElementId AND vda28.axisAttributeId =28"
       + " LEFT JOIN "
       + " ValoresEjesDeElemenCatalogoUsuario vda32 ON e.id = vda32.catalogElementId AND vda32.axisAttributeId =32"
       + " LEFT JOIN "
       + " ValoresEjesDeElemenCatalogoUsuario vda34 ON e.id = vda34.catalogElementId AND vda34.axisAttributeId =34"
       + " LEFT JOIN "
       + "ValoresEjesDeElemenCatalogoUsuario vda40 ON e.id = vda40.catalogElementId AND vda40.axisAttributeId =40"
       + " LEFT JOIN "
       + "ValoresEjesDeElemenCatalogoUsuario vda55 ON e.id = vda55.catalogElementId AND vda55.axisAttributeId =55"
       + " LEFT JOIN "
       + "ValorDominioDeAttrElemCat vda34Dom ON vda34Dom.valorEjeElemCatId = vda34.id"
       + " LEFT JOIN "
            + "ValorDominioDeAttrElemCat vda40Dom ON vda40Dom.valorEjeElemCatId = vda40.id"
            + " LEFT JOIN "
            + "ValorDominioDeAttrElemCat vda55Dom ON vda55Dom.valorEjeElemCatId = vda55.id"
            + " LEFT JOIN "
            + "ValorDominio val34 ON val34.id = vda34Dom.domainValueId AND val34.axisAttributeId =34"
            + " LEFT JOIN "
            + "ValorDominio val40 ON val40.id = vda40Dom.domainValueId AND val40.axisAttributeId =40"
            + " LEFT JOIN "
            + "ValorDominio val55 ON val55.id = vda55Dom.domainValueId AND val55.axisAttributeId =55"
            + " WHERE "
            + "( TO_NUMBER(SUBSTR(:groupIdAndType, 1, INSTR(:groupIdAndType, '-') - 1))  = 0"
            + " OR e.groupId = TO_NUMBER(SUBSTR(:groupIdAndType, 1, INSTR(:groupIdAndType, '-') - 1)) ) "
            + "AND ( TO_NUMBER(SUBSTR(:groupIdAndType, INSTR(:groupIdAndType, '-') + 1))  = 0"
            + " OR e.catalogElementTypeId = TO_NUMBER(SUBSTR(:groupIdAndType, INSTR(:groupIdAndType, '-') + 1)) )"
       + " AND (TO_NUMBER(SUBSTR(:funcAreaIdAndComputerProcIds, 1, INSTR(:funcAreaIdAndComputerProcIds, '-') - 1)) = 0"
          + " OR vda34Dom.domainValueId = "
           + " TO_NUMBER(SUBSTR(:funcAreaIdAndComputerProcIds, 1, INSTR(:funcAreaIdAndComputerProcIds, '-') - 1)) )"
         + "AND ( TO_NUMBER(SUBSTR(:funcAreaIdAndComputerProcIds, INSTR(:funcAreaIdAndComputerProcIds, '-') + 1)) = 0"
            + " OR vda40Dom.domainValueId = "
            + "TO_NUMBER(SUBSTR(:funcAreaIdAndComputerProcIds, INSTR(:funcAreaIdAndComputerProcIds, '-') + 1)) )"
            + " AND (:situationId IS NULL OR vda55Dom.domainValueId = :situationId)"
            + " AND (:cappCode IS NULL OR e.cappCode LIKE %:cappCode%)"
            + " AND (:nameOfElement IS NULL OR e.name LIKE %:nameOfElement%)"
            + " AND (:responsible IS NULL OR vda28.userValue LIKE %:responsible%)"
    )
    Page<ElementoCatalogoFilter> getMinimalInfoByFilter(String groupIdAndType, String funcAreaIdAndComputerProcIds,
                                                        Integer situationId, String cappCode, String nameOfElement,
                                                        String responsible, Pageable pageable);


    @Query("SELECT new giss.mad.catalogo.model.ElementoCatalogo(ele.id, ele.name, ele.cappCode, "
            + "ele.catalogElementCollateralId, ele.groupId, ele.creationDate, ele.updateDate) "
            + "FROM ElementoCatalogo ele "
            + "LEFT JOIN ValoresEjesDeElemenCatalogoUsuario vecu ON ele.id = vecu.catalogElementId "
            + " AND vecu.axisAttributeId = :#{#concatenated['axisAttribute']} "
            + "LEFT JOIN ValorDominioDeAttrElemCat vac ON vecu.id = vac.valorEjeElemCatId "
            + "AND vac.domainValueId = :#{#concatenated['domainValue']} "
            + "WHERE ele.catalogElementTypeId = :#{#concatenated['typeId']} AND ele.deleted IS NULL AND "
           + "(:#{#concatenated['domainValue']} IS NULL OR (vecu.axisAttributeId = :#{#concatenated['axisAttribute']} "
           + "AND vac.domainValueId = :#{#concatenated['domainValue']})) AND "
           + "(:startDate IS NULL OR (ele.creationDate BETWEEN :startDate AND :endDate))"
    )
    Page<ElementoCatalogo> getMinimalInfoForListing(Map<String, Object> concatenated, Date startDate,
                                                    Date endDate, Pageable pageable);


    @Query("SELECT new giss.mad.catalogo.model.ElementoCatalogo(ele.id, ele.name, ele.cappCode, "
        + "ele.catalogElementCollateralId, ele.groupId, ele.creationDate, ele.updateDate) FROM ElementoCatalogo ele "
          + "LEFT JOIN ValoresEjesDeElemenCatalogoUsuario vecu ON ele.id = vecu.catalogElementId "
            + "AND vecu.axisAttributeId = :#{#concatenated['axisAttribute']} "
            + "LEFT JOIN ValorDominioDeAttrElemCat vac ON vecu.id = vac.valorEjeElemCatId "
            + "AND vac.domainValueId = :#{#concatenated['domainValue']} "
            + "WHERE ele.groupId IN :#{#concatenated['groupsId']} AND "
       + "(:#{#concatenated['domainValue']} IS NULL OR (vecu.axisAttributeId = :#{#concatenated['axisAttribute']} AND "
            + "vac.domainValueId = :#{#concatenated['domainValue']})) AND "
            + "ele.catalogElementTypeId = :#{#concatenated['typeId']} AND "
            + "(:startDate IS NULL OR (ele.creationDate BETWEEN :startDate AND :endDate)) AND "
         + "(:#{#concatenated['cappCode']} IS NULL OR (UPPER(ele.cappCode) LIKE %:#{#concatenated['cappCode']}%)) AND "
          + "(:#{#concatenated['name']} IS NULL OR (UPPER(ele.name) LIKE %:#{#concatenated['name']}%)) AND "
            + "ele.deleted IS NULL "
            + "GROUP BY ele.id, ele.name, ele.cappCode, ele.catalogElementCollateralId, "
            + "ele.groupId, ele.creationDate, ele.updateDate "
    )
    Page<ElementoCatalogo> getMinimalInfoForListingForGroupsWithCappOrName(Map<String, Object> concatenated,
                                                                Date startDate, Date endDate, Pageable pageable);

    @Query("SELECT new giss.mad.catalogo.model.ElementoCatalogo(ele.id, ele.name, ele.cappCode, "
            + "ele.catalogElementCollateralId, ele.groupId, ele.creationDate, ele.updateDate) "
            + " FROM ElementoCatalogo ele "
            + "LEFT JOIN ValoresEjesDeElemenCatalogoUsuario vecu ON ele.id = vecu.catalogElementId "
            + "AND vecu.axisAttributeId = :#{#concatenated['axisAttribute']} "
            + "LEFT JOIN ValorDominioDeAttrElemCat vac ON vecu.id = vac.valorEjeElemCatId "
            + "AND vac.domainValueId = :#{#concatenated['domainValue']} "
            + "WHERE ele.groupId IN :#{#concatenated['groupsId']} AND "
            + "ele.catalogElementTypeId = :#{#concatenated['typeId']} AND ele.deleted IS NULL AND "
       + "(:#{#concatenated['domainValue']} IS NULL OR (vecu.axisAttributeId = :#{#concatenated['axisAttribute']} AND "
       + "vac.domainValueId = :#{#concatenated['domainValue']})) AND "
       + "(:startDate IS NULL OR (ele.creationDate BETWEEN :startDate AND :endDate))"
    )
    Page<ElementoCatalogo> getMinimalInfoForListingForGroups(Map<String, Object> concatenated, Date startDate,
                                                             Date endDate, Pageable pageable);

    @Query("SELECT new giss.mad.catalogo.model.ElementoCatalogo(ele.id, ele.name, ele.cappCode, "
            + "ele.catalogElementCollateralId, ele.groupId, ele.catalogElementTypeId, ele.creationDate) "
            + " FROM ElementoCatalogo ele WHERE ele.id = :id"
    )
    ElementoCatalogo getMinimalInfoOfElement(Integer id);

    @Query("SELECT new giss.mad.catalogo.model.ElementoCatalogo(ele.id, ele.cappCode) "
            + "FROM ElementoCatalogo ele WHERE ele.cappCode = :cappCode"
    )
    List<ElementoCatalogo> getByCappCodeOptimized(String cappCode);

    @Query("SELECT new giss.mad.catalogo.model.ElementoCatalogo(ele.id, ele.cappCode, ele.name) "
            + "FROM ElementoCatalogo ele WHERE ele.name = :name"
    )
    List<ElementoCatalogo> getByNameOptimized(String name);


    @Query("SELECT new giss.mad.catalogo.model.filters.SimplifiedElement(ele.cappCode, ele.name, atrVal.userValue) "
            + "FROM ElementoCatalogo ele "
            + "INNER JOIN Grupo grupo ON ele.groupId = grupo.id "
            + "INNER JOIN ValoresEjesDeElemenCatalogoUsuario atrVal ON atrVal.catalogElementId = ele.id "
            + "INNER JOIN AtributoEje atributoEje ON atributoEje.id = atrVal.axisAttributeId "
            + "WHERE ele.catalogElementTypeId = :typeId AND ele.groupId IN :groupsIds "
            + "AND ele.deleted IS NULL "
            + " AND atrVal.deleted IS NULL AND (atributoEje.id = 26 OR atributoEje.code = 'ATTR4') "
            + "ORDER BY "
            + "CASE WHEN :order = 'id' AND :direction = 'DESC' THEN ele.id END DESC,"
            + "CASE WHEN :order = 'id' AND :direction = 'ASC' THEN ele.id END ASC,"
            + "CASE WHEN :order = 'name' AND :direction = 'DESC' THEN ele.name END DESC,"
            + "CASE WHEN :order = 'name' AND :direction = 'ASC' THEN ele.name END ASC,"
            + "CASE WHEN :order = 'cappCode' AND :direction = 'DESC' THEN ele.cappCode END DESC,"
            + "CASE WHEN :order = 'cappCode' AND :direction = 'ASC' THEN ele.cappCode END ASC,"
            + "CASE WHEN :order = 'creationDate' AND :direction = 'DESC' THEN ele.creationDate END DESC,"
            + "CASE WHEN :order = 'creationDate' AND :direction = 'ASC' THEN ele.creationDate END ASC,"
            + "CASE WHEN :order = 'updateDate' AND :direction = 'DESC' THEN ele.creationDate END DESC,"
            + "CASE WHEN :order = 'updateDate' AND :direction = 'ASC' THEN ele.creationDate END ASC"
    )
    List<SimplifiedElement> findElementsFromGroupInHierarchy(
            @Param("groupsIds") List<Integer> groupsIds,
            @Param("typeId") Integer typeId,
            @Param("order") String order,
            @Param("direction") String direction
    );


    /*** metodos a ir sustituyendo ***/

    @Query("SELECT new giss.mad.catalogo.model.ElementoCatalogo"
            + "(ele.id || '|' || ele.cappCode || '|' || ele.name || '|' || ele.catalogElementTypeId, "
            + "ele.catalogElementCollateralId, ele.groupId, ele.respManagementId, ele.respDevelopmentId, "
            + "ele.creationDate, ele.updateDate) "
            + "FROM "
            + "ElementoCatalogo ele WHERE ele.id = :id AND ele.deleted IS NULL"
    )
    ElementoCatalogo getByIdAndNotNull(Integer id);

    @Query("SELECT new giss.mad.catalogo.model.ElementoCatalogo"
            + "(ele.id || '|' || ele.cappCode || '|' || ele.name || '|' || ele.catalogElementTypeId, "
            + "ele.catalogElementCollateralId, ele.groupId, ele.respManagementId, ele.respDevelopmentId, "
            + "ele.creationDate, ele.updateDate) "
            + "FROM "
            + "ElementoCatalogo ele WHERE ele.id = :id"
    )
    ElementoCatalogo getByIdWithHistoric(Integer id);

    @Query("SELECT new giss.mad.catalogo.model.ElementoCatalogo"
            + "(ele.id || '|' || ele.cappCode || '|' || ele.name || '|' || ele.catalogElementTypeId, "
            + "ele.catalogElementCollateralId, ele.groupId, ele.respManagementId, ele.respDevelopmentId, "
            + "ele.creationDate, ele.updateDate) "
            + "FROM "
            + "ElementoCatalogo ele WHERE ele.cappCode = :cappCode AND ele.deleted IS NULL"
    )
    List<ElementoCatalogo> getByCappCodeEquals(String cappCode);

    @Query("SELECT new giss.mad.catalogo.model.ElementoCatalogo"
            + "(ele.id || '|' || ele.cappCode || '|' || ele.name || '|' || ele.catalogElementTypeId, "
            + "ele.catalogElementCollateralId, ele.groupId, ele.respManagementId, ele.respDevelopmentId, "
            + "ele.creationDate, ele.updateDate) "
            + "FROM "
            + "ElementoCatalogo ele WHERE ele.catalogElementCollateralId = :catalogElementCollateralId "
            + "AND ele.deleted IS NULL"
    )
    List<ElementoCatalogo> getByDeletedIsNullAndCatalogElementCollateralId(Integer catalogElementCollateralId);

    @Query("SELECT new giss.mad.catalogo.model.ElementoCatalogo"
            + "(ele.id || '|' || ele.cappCode || '|' || ele.name || '|' || ele.catalogElementTypeId, "
            + "ele.catalogElementCollateralId, ele.groupId, ele.respManagementId, ele.respDevelopmentId, "
            + "ele.creationDate, ele.updateDate) "
            + "FROM "
            + "ElementoCatalogo ele WHERE ele.catalogElementCollateralId = :catalogElementCollateralId "
            + "AND ele.deleted IS NULL"
    )
    Page<ElementoCatalogo> getByDeletedIsNullAndCatalogElementCollateralIdPag(Integer catalogElementCollateralId,
                                                                              Pageable pageable);

    Page<ElementoCatalogo> findByDeletedIsNullAndCatalogElementCollateralIdIsNullAndCatalogElementTypeIdIn(
            List<Integer> catalogElementTypeIds, Pageable pageable);

    Page<ElementoCatalogo> findByDeletedIsNullAndGroupIdInAndCatalogElementTypeIdIn(List<Integer> groupIds,
                                                                                    List<Integer> types,
                                                                                    Pageable pageable);

    long countByGroupIdAndDeletedIsNull(Integer groupId);
}
