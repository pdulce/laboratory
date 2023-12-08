package giss.mad.itinerario.util;



import giss.mad.itinerario.model.volatilentities.ValorEje;

import java.util.Comparator;

public class ValorEjeComparator implements Comparator<ValorEje> {

    @Override
    public int compare(final ValorEje o1, final ValorEje o2) {
        return o1.getAxisAttributeId().compareTo(o2.getAxisAttributeId());
    }

}
