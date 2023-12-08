package giss.mad.catalogo.utilities;

import giss.mad.catalogo.model.ValoresEjesDeElemenCatalogoUsuario;

import java.util.Comparator;

public class ValoresAttrComparator implements Comparator<ValoresEjesDeElemenCatalogoUsuario> {

    @Override
    public int compare(final ValoresEjesDeElemenCatalogoUsuario o1, final ValoresEjesDeElemenCatalogoUsuario o2) {
        return o1.getAxisAttributeId().compareTo(o2.getAxisAttributeId());
    }
}
