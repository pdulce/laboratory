package giss.mad.catalogo.utilities;

import giss.mad.catalogo.model.filters.UnidadOrganizativaMinimal;

import java.util.Comparator;

public class UnOrganizativaComparator implements Comparator<UnidadOrganizativaMinimal> {

    @Override
    public int compare(final UnidadOrganizativaMinimal o1, final UnidadOrganizativaMinimal o2) {
        return o1.getCode().compareTo(o2.getCode());
    }
}
