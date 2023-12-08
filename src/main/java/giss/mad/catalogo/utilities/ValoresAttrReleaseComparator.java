package giss.mad.catalogo.utilities;
import giss.mad.catalogo.model.ValoresEjesDeEntregaUsuario;

import java.util.Comparator;

public class ValoresAttrReleaseComparator implements Comparator<ValoresEjesDeEntregaUsuario> {

    @Override
    public int compare(final ValoresEjesDeEntregaUsuario o1, final ValoresEjesDeEntregaUsuario o2) {
        return o1.getAxisAttributeId().compareTo(o2.getAxisAttributeId());
    }
}
