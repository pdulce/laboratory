package giss.mad.itinerario.util;

import giss.mad.itinerario.model.itinerario.ActividadItinerario;

import java.util.Comparator;

public class ActivityItineraryComparator implements Comparator<ActividadItinerario> {

    @Override
    public int compare(final ActividadItinerario o1, final ActividadItinerario o2) {
        return o1.getTestingStageId().compareTo(o2.getTestingStageId());
    }
}
