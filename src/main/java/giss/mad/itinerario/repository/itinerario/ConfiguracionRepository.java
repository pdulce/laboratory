package giss.mad.itinerario.repository.itinerario;


import giss.mad.itinerario.model.itinerario.Configuracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfiguracionRepository extends JpaRepository<Configuracion, Integer> {

    Configuracion findByKeyAndDeletedIsNull(String name);
    Configuracion findByIdAndDeletedIsNull(Integer id);
    List<Configuracion> findAllByDeletedIsNull();



}
