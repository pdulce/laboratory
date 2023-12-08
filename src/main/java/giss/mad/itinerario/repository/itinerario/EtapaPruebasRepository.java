package giss.mad.itinerario.repository.itinerario;

import giss.mad.itinerario.model.itinerario.EtapaPruebas;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtapaPruebasRepository extends JpaRepository<EtapaPruebas, Integer> {


    @Query("SELECT new giss.mad.itinerario.model.itinerario.EtapaPruebas(e.id, e.name, e.description, e.deleted, "
        + "e.creationDate, e.updateDate) FROM EtapaPruebas e "
            + "WHERE e.deleted IS NULL"
    )
    List<EtapaPruebas> findAllByDeletedIsNull(Sort sort);

    @Query("SELECT new giss.mad.itinerario.model.itinerario.EtapaPruebas(e.id, e.name, e.description, e.deleted, "
            + "e.creationDate, e.updateDate) FROM EtapaPruebas e "
            + "WHERE e.deleted IS NULL AND e.id = :id"
    )
    EtapaPruebas findByIdAndDeletedIsNull(Integer id);


}

