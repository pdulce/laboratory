package giss.mad.itinerario.repository.itinerario;

import giss.mad.itinerario.model.itinerario.ActividadQA;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadQARepository extends JpaRepository<ActividadQA, Integer> {

    @Query("SELECT new giss.mad.itinerario.model.itinerario.ActividadQA(a.id, a.testingStageId, e.name, "
            + "a.name || '|' || a.shortName || '|' || a.description, a.help || '|' || a.idealThreshold, "
            + "a.creationDate) FROM ActividadQA a "
            + "LEFT JOIN EtapaPruebas e ON a.testingStageId = e.id "
            + "WHERE a.deleted IS NULL"
    )
    List<ActividadQA> findInOrderActivitiesWithoutChildren(Sort sort);

    @Query("SELECT new giss.mad.itinerario.model.itinerario.ActividadQA(a.id, a.testingStageId, e.name, "
            + "a.name || '|' || a.shortName || '|' || a.description, a.help || '|' || a.idealThreshold, "
            + "a.creationDate) FROM ActividadQA a "
            + "LEFT JOIN EtapaPruebas e ON a.testingStageId = e.id "
            + "WHERE a.deleted IS NULL AND a.testingStageId= :stageId"
    )
    List<ActividadQA> getAllFilteredByStageId(Integer stageId);

    @Query("SELECT new giss.mad.itinerario.model.itinerario.ActividadQA(a.id, e.id, e.name, "
            + "a.name || '|' || a.shortName || '|' || a.description, a.help || '|' || a.idealThreshold, "
            + "a.creationDate) FROM ActividadQA a "
            + "LEFT JOIN EtapaPruebas e ON a.testingStageId = e.id "
            + "WHERE a.deleted IS NULL AND a.id= :id"
    )
    ActividadQA findByIdWithoutChildren(Integer id);


    ActividadQA findByIdAndDeletedIsNull(Integer id);

    List<ActividadQA> findAllByTestingStageIdAndDeletedIsNull(Integer idetapa);

}

