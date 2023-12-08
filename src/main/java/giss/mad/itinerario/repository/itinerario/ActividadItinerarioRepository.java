package giss.mad.itinerario.repository.itinerario;

import giss.mad.itinerario.model.itinerario.ActividadItinerario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadItinerarioRepository extends JpaRepository<ActividadItinerario, Integer> {

    ActividadItinerario findByIdAndDeletedIsNull(Integer id);

    @Query("SELECT NEW giss.mad.itinerario.model.itinerario.ActividadItinerario(a.id, u1.threshold || '|' || "
            + "u2.threshold, u2.upperLimit, u1.upperLimit, u2.lowerLimit, u1.lowerLimit, "
            + "(CASE "
            + "   WHEN COALESCE(pEje30.weightValue, 0) = -1 THEN -1 "
            + "   WHEN COALESCE(pEje30.weightValue, 0) = -2 THEN -2 "
            + "   WHEN COALESCE(pEje30.weightValue, 0) = -3 THEN -3 "
            + "   ELSE COALESCE(pEje30.weightValue, 0) "
            + "END) ) "
            + " FROM ActividadQA a"
            + " LEFT JOIN UmbralActividad u1 ON a.id=u1.activityId AND u1.elementTypeId = :elementTypeId"
            + " AND u1.forDelivery= :isForDelivery AND u1.upperLimit <= 9999 AND u1.deleted IS NULL "
            + " LEFT JOIN UmbralActividad u2 ON a.id=u2.activityId AND u2.elementTypeId = :elementTypeId"
            + " AND u2.forDelivery= :isForDelivery AND u1.id != u2.id AND u2.upperLimit <= 9999 AND u2.deleted IS NULL"
            + " LEFT JOIN Peso pEje30 ON a.id=pEje30.activityId AND pEje30.elementTypeId= :elementTypeId AND "
            + "pEje30.forDelivery= :isForDelivery AND pEje30.axisAttributeId= :axisAttributeId "
            + " AND pEje30.domainValueId = :domainId AND pEje30.deleted IS NULL"
            + " AND a.deleted IS NULL"
            + " ORDER BY a.id ASC"
    )
    List<ActividadItinerario> calculateSumOfWeightsForEachAxis(Integer elementTypeId, Integer isForDelivery,
                                                               Integer axisAttributeId, Integer domainId);


}

