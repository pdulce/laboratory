package giss.mad.catalogo.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IntegerComparatorDiffblueTest {
    /**
     * Method under test: {@link IntegerComparator#compare(Integer, Integer)}
     */
    @Test
    void testCompare() {
        assertEquals(0, (new IntegerComparator()).compare(3, 3));
        assertEquals(-1, (new IntegerComparator()).compare(1, 3));
        assertEquals(-1, (new IntegerComparator()).compare(0, 3));
        assertEquals(-1, (new IntegerComparator()).compare(-1, 3));
        assertEquals(1, (new IntegerComparator()).compare(3, 1));
    }
}
