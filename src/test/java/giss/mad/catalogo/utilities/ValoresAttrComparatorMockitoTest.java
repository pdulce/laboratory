package giss.mad.catalogo.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import giss.mad.catalogo.model.ValoresEjesDeElemenCatalogoUsuario;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ValoresAttrComparatorMockitoTest {
    /**
     * Method under test:
     * {@link ValoresAttrComparator#compare(ValoresEjesDeElemenCatalogoUsuario, ValoresEjesDeElemenCatalogoUsuario)}
     */
    @Test
    void testCompare() {
        ValoresAttrComparator valoresAttrComparator = new ValoresAttrComparator();

        ValoresEjesDeElemenCatalogoUsuario o1 = new ValoresEjesDeElemenCatalogoUsuario();
        o1.setAxisAttributeId(1);
        o1.setCatalogElementId(1);
        o1.setCreationDate(mock(Timestamp.class));
        o1.setDeleted(1);
        o1.setDomainValues(new ArrayList<>());
        o1.setId(1);
        o1.setUpdateDate(mock(Timestamp.class));
        o1.setUserValue("42");

        ValoresEjesDeElemenCatalogoUsuario o2 = new ValoresEjesDeElemenCatalogoUsuario();
        o2.setAxisAttributeId(1);
        o2.setCatalogElementId(1);
        o2.setCreationDate(mock(Timestamp.class));
        o2.setDeleted(1);
        o2.setDomainValues(new ArrayList<>());
        o2.setId(1);
        o2.setUpdateDate(mock(Timestamp.class));
        o2.setUserValue("42");
        assertEquals(0, valoresAttrComparator.compare(o1, o2));
    }
}
