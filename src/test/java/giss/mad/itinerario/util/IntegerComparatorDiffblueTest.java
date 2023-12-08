package giss.mad.itinerario.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IntegerComparatorDiffblueTest {
    /**
     * Method under test: {@link giss.mad.itinerario.util.MyIntegerComparator#compare(Integer, Integer)}
     */
    @Test
    void testCompare() {
        assertEquals(0, (new giss.mad.itinerario.util.MyIntegerComparator()).compare(3, 3));
        assertEquals(-1, (new giss.mad.itinerario.util.MyIntegerComparator()).compare(1, 3));
        assertEquals(-1, (new giss.mad.itinerario.util.MyIntegerComparator()).compare(0, 3));
        assertEquals(-1, (new giss.mad.itinerario.util.MyIntegerComparator()).compare(-1, 3));
        assertEquals(1, (new giss.mad.itinerario.util.MyIntegerComparator()).compare(3, 1));
    }
}
