package giss.mad.catalogo.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import giss.mad.catalogo.model.EntregaElementoCatalogo;

@Repository
public interface EntregaElementoCatalogoRepository extends JpaRepository<EntregaElementoCatalogo, Integer> {

    @Query("SELECT new giss.mad.catalogo.model.EntregaElementoCatalogo(ent.id || '|' || ent.name, "
            + "ele.cappCode || '|' || ent.catalogElementId, ele.catalogElementTypeId || '|' || ent.groupId, "
            + "ent.creationDate, ent.updateDate, ent.deliveryCatalogElementCollateralId, ent.productionDeliveryDate) "
            + "FROM ElementoCatalogo ele JOIN ele.deliveryCollection ent "
            + "WHERE ent.deleted IS NULL AND ele.deleted IS NULL AND ent.id = :id"
    )
    EntregaElementoCatalogo getByIdAndNotNull(Integer id);


    @Query("SELECT new giss.mad.catalogo.model.EntregaElementoCatalogo(ent.id || '|' || ent.name, "
            + "ele.cappCode || '|' || ent.catalogElementId, ele.catalogElementTypeId || '|' || ent.groupId, "
            + "ent.creationDate, ent.updateDate, ent.deliveryCatalogElementCollateralId, ent.productionDeliveryDate) "
            + "FROM ElementoCatalogo ele JOIN ele.deliveryCollection ent "
            + "WHERE ent.deleted IS NULL AND ele.deleted IS NULL AND ent.name = :name"
    )
    EntregaElementoCatalogo getByNameEquals(String name);

    @Query("SELECT ent.id "
            + "FROM "
            + "EntregaElementoCatalogo ent WHERE ent.name LIKE %:name% AND ent.deleted IS NULL"
    )
    Integer getByDeletedIsNullAndNameContaining(String name);


    @Query("SELECT new giss.mad.catalogo.model.EntregaElementoCatalogo(ent.id || '|' || ent.name, "
            + "ele.cappCode || '|' || ent.catalogElementId, ele.catalogElementTypeId || '|' || ent.groupId, "
            + "ent.creationDate, ent.updateDate, ent.deliveryCatalogElementCollateralId, ent.productionDeliveryDate) "
            + "FROM ElementoCatalogo ele JOIN ele.deliveryCollection ent "
            + "WHERE ent.catalogElementId = :catalogElementId AND "
            + "ent.deleted IS NULL AND ele.deleted IS NULL"
    )
    List<EntregaElementoCatalogo> getAllWithCatalogElementIdAndDeletedIsNull(Integer catalogElementId, Sort sort);

    @Query("SELECT new giss.mad.catalogo.model.EntregaElementoCatalogo(ent.id || '|' || ent.name, "
            + "ele.cappCode || '|' || ent.catalogElementId, ele.catalogElementTypeId || '|' || ent.groupId, "
            + "ent.creationDate, ent.updateDate, ent.deliveryCatalogElementCollateralId, ent.productionDeliveryDate) "
            + "FROM EntregaElementoCatalogo ent "
            + "INNER JOIN Grupo gr ON gr.id = ent.groupId "
            + "INNER JOIN ElementoCatalogo ele ON ele.id = ent.catalogElementId "
            + "WHERE (:catalogElementType IS NULL OR ele.catalogElementTypeId = :catalogElementType) "
            + "AND (:name IS NULL OR ent.name LIKE %:name%) "
            + "AND (:group IS NULL OR gr.name LIKE %:group%) "
            + "AND (:startDate IS NULL OR (ent.creationDate BETWEEN :startDate AND :endDate)) "
            + "AND ent.deleted IS NULL AND ele.deleted IS NULL"
    )
    Page<EntregaElementoCatalogo> getAllWithCriteriaWithGroup(Pageable pageable, Integer catalogElementType,
                                                     Timestamp startDate, Timestamp endDate,
                                                     String name, String group);


    @Query("SELECT new giss.mad.catalogo.model.EntregaElementoCatalogo(ent.id || '|' || ent.name, "
            + "ele.cappCode || '|' || ent.catalogElementId, ele.catalogElementTypeId || '|' || ent.groupId, "
            + "ent.creationDate, ent.updateDate, ent.deliveryCatalogElementCollateralId, ent.productionDeliveryDate) "
            + "FROM EntregaElementoCatalogo ent "
            + "INNER JOIN Grupo gr ON gr.id = ent.groupId "
            + "INNER JOIN ElementoCatalogo ele ON ele.id = ent.catalogElementId "
            + "WHERE (:catalogElementType IS NULL OR ele.catalogElementTypeId = :catalogElementType) "
            + "AND ent.groupId IN :groupsId "
            + "AND (:name IS NULL OR ent.name LIKE %:name%) "
            + "AND (:startDate IS NULL OR (ent.creationDate BETWEEN :startDate AND :endDate)) "
            + "AND ent.deleted IS NULL AND ele.deleted IS NULL"
    )
    Page<EntregaElementoCatalogo> getAllWithCriteria(Pageable pageable, Integer catalogElementType,
                                                     Timestamp startDate, Timestamp endDate,
                                                     String name, List<Integer> groupsId);

    @Query("SELECT new giss.mad.catalogo.model.EntregaElementoCatalogo(ent.id || '|' || ent.name, "
            + "ele.cappCode || '|' || ent.catalogElementId, ele.catalogElementTypeId || '|' || ent.groupId, "
            + "ent.creationDate, ent.updateDate, ent.deliveryCatalogElementCollateralId, ent.productionDeliveryDate) "
            + "FROM ElementoCatalogo ele JOIN ele.deliveryCollection ent "
            + "WHERE ent.deliveryCatalogElementCollateralId = :deliveryCatalogElementCollateralId "
            + "AND ent.deleted IS NULL AND ele.deleted IS NULL")
    List<EntregaElementoCatalogo> getByDeletedIsNullAndDeliveryCatalogElementCollateralId(
            Integer deliveryCatalogElementCollateralId);

    long countByGroupIdAndDeletedIsNull(Integer groupId);
}

