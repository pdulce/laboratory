package giss.mad.itinerario.model.volatilentities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class ActividadQAPantalla {

    private Integer id;
    private String activity;

    private String activityShort;

    private String realization;

    private String help;

    private Double avance = 0.0;

    private Double agreedThreshold;
    private Integer sumOfWeights = 0;

    private Double ponderado = 0.0;

    //private Integer value;

}
