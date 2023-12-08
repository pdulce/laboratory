package giss.mad.itinerario.repository.itinerario;

import giss.mad.itinerario.model.itinerario.ItinerarioCalidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ItinerarioCalidadRepository extends JpaRepository<ItinerarioCalidad, Integer> {
    List<ItinerarioCalidad> findAllByCatalogueIdAndDeliveryAndDeletedIsNull(Integer catalogueId, Integer delivery,
                                                                            Sort sort);
    List<ItinerarioCalidad> findAllByCatalogueIdAndDeletedIsNull(Integer catalogueId);

    @Query("SELECT NEW giss.mad.itinerario.model.itinerario.ItinerarioCalidad(ic.id || '|' || ic.current || '|' || "
            + " ic.situacionId, ic.catalogueId, ic.delivery, sit.name, ic.observacionesAprobacion, ic.creationDate, "
            + "ic.updateDate) "
            + "FROM ItinerarioCalidad ic LEFT JOIN SituacionItinerario sit ON ic.situacionId = sit.id "
            + "WHERE ic.deleted IS NULL AND ic.catalogueId = :catalogueId")
    Page<ItinerarioCalidad> getItinerariesPagingByCatId(Pageable pageable, Integer catalogueId);

    @Query("SELECT NEW giss.mad.itinerario.model.itinerario.ItinerarioCalidad(ic.id || '|' || ic.current || '|' || "
            + " ic.situacionId, ic.catalogueId, ic.delivery, sit.name, ic.observacionesAprobacion, ic.creationDate, "
            + "ic.updateDate) "
            + "FROM ItinerarioCalidad ic LEFT JOIN SituacionItinerario sit ON ic.situacionId = sit.id "
            + "WHERE ic.deleted IS NULL AND ic.delivery = :delivery AND ic.catalogueId = :catalogueId")
    Page<ItinerarioCalidad> getItinerariesPagingByCatAndDeliveryId(Pageable pageable, Integer catalogueId,
                                                                   Integer delivery);

    @Query("SELECT NEW giss.mad.itinerario.model.itinerario.ItinerarioCalidad(ic.id || '|' || ic.current || '|' || "
            + " ic.situacionId, ic.catalogueId, ic.delivery, sit.name, ic.observacionesAprobacion, ic.creationDate, "
            + "ic.updateDate) "
            + "FROM ItinerarioCalidad ic LEFT JOIN SituacionItinerario sit ON ic.situacionId = sit.id "
            + "WHERE ic.deleted IS NULL AND ic.id = :identif")
    ItinerarioCalidad getByIdOfItinerary(Integer identif);
    ItinerarioCalidad findByIdAndDeletedIsNull(Integer id);

    @Query("SELECT ic.avance FROM ItinerarioCalidad ic "
        + "WHERE ic.deleted IS NULL AND ic.id = :id")
    Double getAvanceById(@Param("id") Integer id);

    @Query("SELECT NEW giss.mad.itinerario.model.itinerario.ItinerarioCalidad(ic.id, ic.catalogueId, ic.situacionId, "
            + "ic.current, ic.creationDate, ic.updateDate, ic.delivery) "
            + "FROM ItinerarioCalidad ic WHERE ic.deleted IS NULL "
            + "AND (:isDelivery IS NULL OR ic.delivery = :isDelivery) "
            + "AND (:startDate IS NULL OR (ic.creationDate BETWEEN :startDate AND :endDate)) "
            + "AND (:current IS NULL OR ic.current = :current) "
            + "AND (:situationId IS NULL OR ic.situacionId = :situationId) "
            + "AND ic.catalogueId IN :elementsIds")
    List<ItinerarioCalidad> getFilteredItineraries(@Param("startDate") Timestamp startDate,
                                                    @Param("endDate") Timestamp endDate,
                                                    @Param("current") Integer current,
                                                    @Param("elementsIds") List<Integer> elementsIds,
                                                    @Param("isDelivery") Integer isDelivery,
                                                   @Param("situationId") Integer situationId);


}

