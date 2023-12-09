package giss.mad.itinerario.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import giss.mad.itinerario.model.itinerario.Peso;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class PesoComparatorMockitoTest {
    /**
     * Method under test: {@link PesoComparator#compare(Peso, Peso)}
     */
    @Test
    void testCompare() {
        PesoComparator pesoComparator = new PesoComparator();

        Peso o1 = new Peso();
        o1.setActivityId(1);
        o1.setAxisAttributeId(1);
        o1.setCreationDate(mock(Timestamp.class));
        o1.setDeleted(1);
        o1.setDomainValueId(1);
        o1.setElementTypeId(1);
        o1.setForDelivery(1);
        o1.setId(1);
        o1.setUpdateDate(mock(Timestamp.class));
        o1.setWeightValue(3);

        Peso o2 = new Peso();
        o2.setActivityId(1);
        o2.setAxisAttributeId(1);
        o2.setCreationDate(mock(Timestamp.class));
        o2.setDeleted(1);
        o2.setDomainValueId(1);
        o2.setElementTypeId(1);
        o2.setForDelivery(1);
        o2.setId(1);
        o2.setUpdateDate(mock(Timestamp.class));
        o2.setWeightValue(3);
        assertEquals(0, pesoComparator.compare(o1, o2));
    }

    /**
     * Method under test: {@link PesoComparator#compare(Peso, Peso)}
     */
    @Test
    void testCompare2() {
        PesoComparator pesoComparator = new PesoComparator();

        Peso o1 = new Peso();
        o1.setActivityId(1);
        o1.setAxisAttributeId(2);
        o1.setCreationDate(mock(Timestamp.class));
        o1.setDeleted(1);
        o1.setDomainValueId(1);
        o1.setElementTypeId(1);
        o1.setForDelivery(1);
        o1.setId(1);
        o1.setUpdateDate(mock(Timestamp.class));
        o1.setWeightValue(3);

        Peso o2 = new Peso();
        o2.setActivityId(1);
        o2.setAxisAttributeId(1);
        o2.setCreationDate(mock(Timestamp.class));
        o2.setDeleted(1);
        o2.setDomainValueId(1);
        o2.setElementTypeId(1);
        o2.setForDelivery(1);
        o2.setId(1);
        o2.setUpdateDate(mock(Timestamp.class));
        o2.setWeightValue(3);
        assertEquals(1, pesoComparator.compare(o1, o2));
    }

    /**
     * Method under test: {@link PesoComparator#compare(Peso, Peso)}
     */
    @Test
    void testCompare3() {
        PesoComparator pesoComparator = new PesoComparator();

        Peso o1 = new Peso();
        o1.setActivityId(1);
        o1.setAxisAttributeId(1);
        o1.setCreationDate(mock(Timestamp.class));
        o1.setDeleted(1);
        o1.setDomainValueId(1);
        o1.setElementTypeId(2);
        o1.setForDelivery(1);
        o1.setId(1);
        o1.setUpdateDate(mock(Timestamp.class));
        o1.setWeightValue(3);

        Peso o2 = new Peso();
        o2.setActivityId(1);
        o2.setAxisAttributeId(1);
        o2.setCreationDate(mock(Timestamp.class));
        o2.setDeleted(1);
        o2.setDomainValueId(1);
        o2.setElementTypeId(1);
        o2.setForDelivery(1);
        o2.setId(1);
        o2.setUpdateDate(mock(Timestamp.class));
        o2.setWeightValue(3);
        assertEquals(1, pesoComparator.compare(o1, o2));
    }
}
