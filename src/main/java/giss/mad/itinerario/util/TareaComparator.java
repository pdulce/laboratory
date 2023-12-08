package giss.mad.itinerario.util;

import giss.mad.itinerario.model.volatilentities.Tarea;

import java.util.Comparator;

public class TareaComparator implements Comparator<Tarea> {

    @Override
    public int compare(final Tarea o1, final Tarea o2) {
        int result = o1.getPackageName().compareTo(o2.getPackageName());
        if (result == 0) {
            result = o1.getClassName().compareTo(o2.getClassName());
        }
        return result;
    }

}
