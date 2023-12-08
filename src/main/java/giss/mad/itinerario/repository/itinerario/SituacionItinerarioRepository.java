package giss.mad.itinerario.repository.itinerario;

import giss.mad.itinerario.model.itinerario.SituacionItinerario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SituacionItinerarioRepository extends JpaRepository<SituacionItinerario, Integer> {

    SituacionItinerario findByIdAndDeletedIsNull(Integer id);

    SituacionItinerario findByNameAndDeletedIsNull(String name);

    List<SituacionItinerario> findAllByDeletedIsNull();

}

