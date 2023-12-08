package giss.mad.itinerario.repository.itinerario;

import giss.mad.itinerario.model.itinerario.Peso;
import giss.mad.itinerario.model.volatilentities.PesoGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PesoRepository extends JpaRepository<Peso, Integer> {

    List<Peso> findAllByDeletedIsNull();

    List<Peso> findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(
        Integer elementTypeId, Integer activityId, Integer axisAttributeId, Integer forDelivery);

    Peso findByIdAndDeletedIsNull(Integer id);

    @Query("SELECT new giss.mad.itinerario.model.volatilentities.PesoGraph(pe.id, ac.name, pe.activityId,"
            + " pe.axisAttributeId, pe.weightValue) FROM ActividadQA ac LEFT JOIN ac.pesos pe WHERE pe.deleted IS NULL"
            + " AND pe.elementTypeId = :elementTypeId"
            + " AND pe.forDelivery = :forDelivery ORDER BY pe.axisAttributeId desc")
    List<PesoGraph> filtrarPorTipoCatalogoYEntrega(@Param("elementTypeId") Integer elementTypeId,
                                                     @Param("forDelivery") Integer forDelivery);







}

