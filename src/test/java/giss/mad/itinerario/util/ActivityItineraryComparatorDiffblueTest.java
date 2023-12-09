package giss.mad.itinerario.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import giss.mad.itinerario.model.itinerario.ActividadItinerario;
import giss.mad.itinerario.model.itinerario.UmbralActividad;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ActivityItineraryComparatorDiffblueTest {
    /**
     * Method under test:
     * {@link ActivityItineraryComparator#compare(ActividadItinerario, ActividadItinerario)}
     */
    @Test
    void testCompare() {
        ActivityItineraryComparator activityItineraryComparator = new ActivityItineraryComparator();

        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(1);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(1);
        umbralInferior.setForDelivery(1);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(1);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(1);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(1);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(1);
        umbralSuperior.setForDelivery(1);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(1);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(1);

        ActividadItinerario o1 = new ActividadItinerario();
        o1.setActivitSumOfAxes(1);
        o1.setActivityId(1);
        o1.setAvance(10.0d);
        o1.setCreationDate(mock(Timestamp.class));
        o1.setDeleted(1);
        o1.setHelp("Help");
        o1.setId(1);
        o1.setIncludedInItinerary(1);
        o1.setInferredThreshold("Inferred Threshold");
        o1.setName("Name");
        o1.setObservations("Observations");
        o1.setQualityItineraryId(1);
        o1.setShortName("Short Name");
        o1.setTestingStageId(1);
        o1.setUmbralInferior(umbralInferior);
        o1.setUmbralSuperior(umbralSuperior);
        o1.setUmbralesPactados(new ArrayList<>());
        o1.setUpdateDate(mock(Timestamp.class));

        UmbralActividad umbralInferior2 = new UmbralActividad();
        umbralInferior2.setActivityId(1);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(1);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("Help");
        umbralInferior2.setId(1);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("Threshold");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(1);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(1);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("Help");
        umbralSuperior2.setId(1);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("Threshold");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario o2 = new ActividadItinerario();
        o2.setActivitSumOfAxes(1);
        o2.setActivityId(1);
        o2.setAvance(10.0d);
        o2.setCreationDate(mock(Timestamp.class));
        o2.setDeleted(1);
        o2.setHelp("Help");
        o2.setId(1);
        o2.setIncludedInItinerary(1);
        o2.setInferredThreshold("Inferred Threshold");
        o2.setName("Name");
        o2.setObservations("Observations");
        o2.setQualityItineraryId(1);
        o2.setShortName("Short Name");
        o2.setTestingStageId(1);
        o2.setUmbralInferior(umbralInferior2);
        o2.setUmbralSuperior(umbralSuperior2);
        o2.setUmbralesPactados(new ArrayList<>());
        o2.setUpdateDate(mock(Timestamp.class));
        assertEquals(0, activityItineraryComparator.compare(o1, o2));
    }
}
