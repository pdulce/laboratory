package giss.mad.catalogo.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import giss.mad.catalogo.model.ValoresEjesDeEntregaUsuario;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ValoresAttrReleaseComparatorDiffblueTest {
    /**
     * Method under test:
     * {@link ValoresAttrReleaseComparator#compare(ValoresEjesDeEntregaUsuario, ValoresEjesDeEntregaUsuario)}
     */
    @Test
    void testCompare() {
        ValoresAttrReleaseComparator valoresAttrReleaseComparator = new ValoresAttrReleaseComparator();

        ValoresEjesDeEntregaUsuario o1 = new ValoresEjesDeEntregaUsuario();
        o1.setAxisAttributeId(1);
        o1.setCreationDate(mock(Timestamp.class));
        o1.setDeleted(1);
        o1.setDeliveryCatalogElementId(1);
        o1.setDomainValues(new ArrayList<>());
        o1.setId(1);
        o1.setUpdateDate(mock(Timestamp.class));
        o1.setUserValue("42");

        ValoresEjesDeEntregaUsuario o2 = new ValoresEjesDeEntregaUsuario();
        o2.setAxisAttributeId(1);
        o2.setCreationDate(mock(Timestamp.class));
        o2.setDeleted(1);
        o2.setDeliveryCatalogElementId(1);
        o2.setDomainValues(new ArrayList<>());
        o2.setId(1);
        o2.setUpdateDate(mock(Timestamp.class));
        o2.setUserValue("42");
        assertEquals(0, valoresAttrReleaseComparator.compare(o1, o2));
    }
}
