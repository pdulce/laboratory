package giss.mad.itinerario.repository.hara;

import giss.mad.itinerario.model.hara.DatosGenericos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatosGenericosRepository extends JpaRepository<DatosGenericos, Integer> {
    Optional<DatosGenericos> findById(Integer dgId);
}
