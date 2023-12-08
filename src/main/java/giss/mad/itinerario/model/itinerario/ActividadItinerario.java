package giss.mad.itinerario.model.itinerario;

import giss.mad.itinerario.service.Constantes;
import giss.mad.itinerario.util.MyIntegerComparator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ACTIVIDADITINERARIO", schema = "MACA_ITINERARIO")
public final class ActividadItinerario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTIVIDADITI_SEQ")
    @SequenceGenerator(sequenceName = "ACTIVIDADITINERARIO_SEQ", allocationSize = 1, name = "ACTIVIDADITI_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;

    @Column(name = "activity_id")
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer activityId;

    @Column(name = "quality_itinerary_id")
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer qualityItineraryId;

    @Column(name = "inferred_threshold")
    @Size(max = 150, message = "El tamaño máximo del campo Umbral inferido es de 150 caracteres")
    private String inferredThreshold;

    @Column(name = "observations")
    @Size(max = 150, message = "El tamaño máximo del campo Observaciones es de 150 caracteres")
    private String observations;

    @Column(name = "help")
    @Size(max = 150, message = "El tamaño máximo del campo Ayuda es de 150 caracteres")
    private String help;

    @Column(name = "activity_sum_of_axes")
    @Max(9999)
    private Integer activitSumOfAxes;

    @Column(name = "included_in_itinerary")
    @Min(0)
    @Max(1)
    private Integer includedInItinerary = Constantes.NUMBER_1;
    @Column(name = "avance")
    @Min(0)
    @Max(9999)
    private Double avance = 0.0;

    @Column(name = "is_deleted")
    @Min(0)
    @Max(1)
    private Integer deleted;

    @Column(name = "creation_date", nullable = false)
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo creationDate")
    private Timestamp creationDate;

    @Column(name = "update_date")
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo updateDate")
    private Timestamp updateDate;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = UmbralPactado.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "activity_itinerary_id")
    @Fetch(FetchMode.JOIN)
    private List<UmbralPactado> umbralesPactados;

    @Transient
    private Integer testingStageId;

    @Transient
    private String name;

    @Transient
    private String shortName;

    @Transient
    private UmbralActividad umbralSuperior;

    @Transient
    private UmbralActividad umbralInferior;

    public ActividadItinerario() {

    }

    public ActividadItinerario(final Integer activityId, final String thresholds, final Integer upperLimitInfIn,
                               final Integer upperLimitSupIn, final Integer lowerLimitInfIn,
                               final Integer lowerLimitSupIn, final Integer sumOfWeights) {
        this.activityId = activityId;
        this.umbralInferior = new UmbralActividad();
        this.umbralSuperior = new UmbralActividad();

        if (upperLimitInfIn == null && upperLimitSupIn == null && lowerLimitInfIn == null && lowerLimitSupIn == null) {
            // no tiene umbrales definidos
            this.umbralInferior.setLowerLimit(Constantes.NUMBER_0);
            this.umbralInferior.setUpperLimit(Constantes.NUMBER_9999);
            this.umbralSuperior.setLowerLimit(Constantes.NUMBER_0);
            this.umbralSuperior.setUpperLimit(Constantes.NUMBER_9999);
        } else {
            List<Integer> umbrales = new ArrayList<>();
            umbrales.add(upperLimitInfIn);
            umbrales.add(upperLimitSupIn);
            umbrales.add(lowerLimitInfIn);
            umbrales.add(lowerLimitSupIn);
            Collections.sort(umbrales, new MyIntegerComparator());
            Integer lowerLimitInf = umbrales.get(Constantes.NUMBER_0);
            Integer upperLimitInf = umbrales.get(Constantes.NUMBER_1);
            Integer lowerLimitSup = umbrales.get(Constantes.NUMBER_2);
            Integer upperLimitSup = umbrales.get(Constantes.NUMBER_3);
            if (lowerLimitInf.intValue() == upperLimitInf.intValue()
                    && lowerLimitSup.intValue() == upperLimitSup.intValue()) {
                this.umbralInferior.setLowerLimit(lowerLimitInf);
                this.umbralInferior.setUpperLimit(upperLimitSup);
                this.umbralSuperior.setLowerLimit(lowerLimitInf);
                this.umbralSuperior.setUpperLimit(upperLimitSup);
            } else {
                this.umbralInferior.setLowerLimit(lowerLimitInf);
                this.umbralInferior.setUpperLimit(upperLimitInf);
                this.umbralSuperior.setLowerLimit(lowerLimitSup);
                this.umbralSuperior.setUpperLimit(upperLimitSup);
            }
        }

        String[] thresholdsSplitter = thresholds == null ? new String[]{""} : thresholds.split("\\|");
        if (thresholdsSplitter.length == Constantes.NUMBER_1) {
            this.umbralInferior.setThreshold(thresholdsSplitter[Constantes.NUMBER_0]);
        } else if (thresholdsSplitter.length == Constantes.NUMBER_2) {
            this.umbralInferior.setThreshold(thresholdsSplitter[Constantes.NUMBER_0].contentEquals("")
                    ? thresholdsSplitter[Constantes.NUMBER_1] : thresholdsSplitter[Constantes.NUMBER_0]);
            this.umbralSuperior.setThreshold(thresholdsSplitter[Constantes.NUMBER_1]);
        }

        this.activitSumOfAxes = sumOfWeights;
    }


}
