package giss.mad.catalogo.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import giss.mad.catalogo.model.filters.UnidadOrganizativaMinimal;
import org.junit.jupiter.api.Test;

class UnOrganizativaComparatorDiffblueTest {
    /**
     * Method under test:
     * {@link UnOrganizativaComparator#compare(UnidadOrganizativaMinimal, UnidadOrganizativaMinimal)}
     */
    @Test
    void testCompare() {
        UnOrganizativaComparator unOrganizativaComparator = new UnOrganizativaComparator();

        UnidadOrganizativaMinimal o1 = new UnidadOrganizativaMinimal();
        o1.setCode("Code");
        assertEquals(0,
                unOrganizativaComparator.compare(o1, new UnidadOrganizativaMinimal(1, "Code", "Name Of", "Centro")));
    }
}
