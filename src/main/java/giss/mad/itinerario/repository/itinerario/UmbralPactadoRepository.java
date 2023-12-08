package giss.mad.itinerario.repository.itinerario;

import giss.mad.itinerario.model.itinerario.UmbralPactado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UmbralPactadoRepository extends JpaRepository<UmbralPactado, Integer> {

    UmbralPactado findByIdAndDeletedIsNull(Integer id);

    Optional<UmbralPactado> findByIdAndDischargeDateIsNullAndDeletedIsNull(Integer id);

    Optional<UmbralPactado> findByActivityItineraryIdAndDischargeDateIsNullAndDeletedIsNull(
            Integer activityItineraryId);

    List<UmbralPactado> findByActivityItineraryIdAndDeletedIsNull(
            Integer activityItineraryId);

}
