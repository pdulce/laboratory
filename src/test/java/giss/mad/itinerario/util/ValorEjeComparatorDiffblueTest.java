package giss.mad.itinerario.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import giss.mad.itinerario.model.volatilentities.ValorEje;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ValorEjeComparatorDiffblueTest {
    /**
     * Method under test: {@link ValorEjeComparator#compare(ValorEje, ValorEje)}
     */
    @Test
    void testCompare() {
        ValorEjeComparator valorEjeComparator = new ValorEjeComparator();

        ValorEje o1 = new ValorEje();
        o1.setAxisAttributeId(1);
        o1.setDomainValues(new ArrayList<>());
        o1.setId(1L);

        ValorEje o2 = new ValorEje();
        o2.setAxisAttributeId(1);
        o2.setDomainValues(new ArrayList<>());
        o2.setId(1L);
        assertEquals(0, valorEjeComparator.compare(o1, o2));
    }
}
