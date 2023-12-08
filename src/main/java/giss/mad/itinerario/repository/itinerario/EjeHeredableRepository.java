package giss.mad.itinerario.repository.itinerario;

import giss.mad.itinerario.model.itinerario.EjeHeredable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EjeHeredableRepository extends JpaRepository<EjeHeredable, Integer> {

    EjeHeredable findByIdAndDeletedIsNull(Integer id);

    EjeHeredable findByElementTypeIdAndAxisIdAndForDeliveryAndDeletedIsNull(Integer elementTypeId, Integer axisId,
        Integer forDelivery);

    List<EjeHeredable> findAllByDeletedIsNull();


    @Query("SELECT new giss.mad.itinerario.model.itinerario.EjeHeredable(elementTypeId, axisId, forDelivery, writable) "
           + "FROM EjeHeredable WHERE deleted IS NULL")
    List<EjeHeredable> findAllAgrupados();

}

