package giss.mad.itinerario.repository.itinerario;

import giss.mad.itinerario.model.itinerario.UmbralActividad;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UmbralActividadRepository extends JpaRepository<UmbralActividad, Integer> {

    List<UmbralActividad> findAllByDeletedIsNull();

    @Query("SELECT new giss.mad.itinerario.model.itinerario.UmbralActividad (id, elementTypeId, activityId, "
            + "forDelivery, lowerLimit, upperLimit, threshold) FROM UmbralActividad WHERE deleted IS NULL")
    List<UmbralActividad> findAllUmbralesAgrupados();

    @Query("SELECT new giss.mad.itinerario.model.itinerario.UmbralActividad (id, elementTypeId, activityId, "
            + "forDelivery, lowerLimit, upperLimit, threshold) FROM UmbralActividad "
            + "WHERE deleted IS NULL AND activityId = :activityId")
    List<UmbralActividad> findFilteredByActivity(Integer activityId);

    List<UmbralActividad> findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndForDelivery(Integer elementTypeId,
        Integer activityId, Integer forDelivery, Sort sort);

    List<UmbralActividad> findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Integer elementTypeId,
        Integer forDelivery);

    UmbralActividad findByIdAndDeletedIsNull(Integer id);

}

