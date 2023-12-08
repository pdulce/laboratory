package giss.mad.itinerario.dto;

import giss.mad.itinerario.model.itinerario.UmbralActividad;
import giss.mad.itinerario.model.itinerario.UmbralPactado;
import giss.mad.itinerario.service.Constantes;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class ActividadItinerarioDto {

    private Integer id;

    private Integer activityId;

    private Integer qualityItineraryId;

    private String inferredThreshold;

    private String observations;

    private String help;

    private Integer activitSumOfAxes;

    private Integer includedInItinerary = Constantes.NUMBER_1;

    private Double avance = 0.0;

    private Double agreedThreshold;

    private Integer deleted;

    private Timestamp creationDate;

    private Timestamp updateDate;

    private List<UmbralPactado> umbralesPactados;

    private Integer testingStageId;

    private String name;

    private String shortName;

    private UmbralActividad umbralSuperior;

    private UmbralActividad umbralInferior;

    public ActividadItinerarioDto() {

    }
}
