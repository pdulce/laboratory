package giss.mad.itinerario.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import giss.mad.itinerario.model.itinerario.UmbralActividad;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class UmbralComparatorMockitoTest {
    /**
     * Method under test:
     * {@link UmbralComparator#compare(UmbralActividad, UmbralActividad)}
     */
    @Test
    void testCompare() {
        UmbralComparator umbralComparator = new UmbralComparator();

        UmbralActividad o1 = new UmbralActividad();
        o1.setActivityId(1);
        o1.setCreationDate(mock(Timestamp.class));
        o1.setDeleted(1);
        o1.setElementTypeId(1);
        o1.setExcludeUnreachedThreshold(1);
        o1.setForDelivery(1);
        o1.setHelp("Help");
        o1.setId(1);
        o1.setLowerLimit(1);
        o1.setThreshold("Threshold");
        o1.setUpdateDate(mock(Timestamp.class));
        o1.setUpperLimit(1);

        UmbralActividad o2 = new UmbralActividad();
        o2.setActivityId(1);
        o2.setCreationDate(mock(Timestamp.class));
        o2.setDeleted(1);
        o2.setElementTypeId(1);
        o2.setExcludeUnreachedThreshold(1);
        o2.setForDelivery(1);
        o2.setHelp("Help");
        o2.setId(1);
        o2.setLowerLimit(1);
        o2.setThreshold("Threshold");
        o2.setUpdateDate(mock(Timestamp.class));
        o2.setUpperLimit(1);
        assertEquals(0, umbralComparator.compare(o1, o2));
    }

    /**
     * Method under test:
     * {@link UmbralComparator#compare(UmbralActividad, UmbralActividad)}
     */
    @Test
    void testCompare2() {
        UmbralComparator umbralComparator = new UmbralComparator();

        UmbralActividad o1 = new UmbralActividad();
        o1.setActivityId(1);
        o1.setCreationDate(mock(Timestamp.class));
        o1.setDeleted(1);
        o1.setElementTypeId(2);
        o1.setExcludeUnreachedThreshold(1);
        o1.setForDelivery(1);
        o1.setHelp("Help");
        o1.setId(1);
        o1.setLowerLimit(1);
        o1.setThreshold("Threshold");
        o1.setUpdateDate(mock(Timestamp.class));
        o1.setUpperLimit(1);

        UmbralActividad o2 = new UmbralActividad();
        o2.setActivityId(1);
        o2.setCreationDate(mock(Timestamp.class));
        o2.setDeleted(1);
        o2.setElementTypeId(1);
        o2.setExcludeUnreachedThreshold(1);
        o2.setForDelivery(1);
        o2.setHelp("Help");
        o2.setId(1);
        o2.setLowerLimit(1);
        o2.setThreshold("Threshold");
        o2.setUpdateDate(mock(Timestamp.class));
        o2.setUpperLimit(1);
        assertEquals(1, umbralComparator.compare(o1, o2));
    }

    /**
     * Method under test:
     * {@link UmbralComparator#compare(UmbralActividad, UmbralActividad)}
     */
    @Test
    void testCompare3() {
        UmbralComparator umbralComparator = new UmbralComparator();

        UmbralActividad o1 = new UmbralActividad();
        o1.setActivityId(1);
        o1.setCreationDate(mock(Timestamp.class));
        o1.setDeleted(1);
        o1.setElementTypeId(1);
        o1.setExcludeUnreachedThreshold(1);
        o1.setForDelivery(0);
        o1.setHelp("Help");
        o1.setId(1);
        o1.setLowerLimit(1);
        o1.setThreshold("Threshold");
        o1.setUpdateDate(mock(Timestamp.class));
        o1.setUpperLimit(1);

        UmbralActividad o2 = new UmbralActividad();
        o2.setActivityId(1);
        o2.setCreationDate(mock(Timestamp.class));
        o2.setDeleted(1);
        o2.setElementTypeId(1);
        o2.setExcludeUnreachedThreshold(1);
        o2.setForDelivery(1);
        o2.setHelp("Help");
        o2.setId(1);
        o2.setLowerLimit(1);
        o2.setThreshold("Threshold");
        o2.setUpdateDate(mock(Timestamp.class));
        o2.setUpperLimit(1);
        assertEquals(-1, umbralComparator.compare(o1, o2));
    }
}
