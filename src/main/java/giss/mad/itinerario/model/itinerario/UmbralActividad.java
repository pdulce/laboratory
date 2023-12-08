package giss.mad.itinerario.model.itinerario;

import giss.mad.itinerario.service.Constantes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "UMBRALACTIVIDAD", schema = "MACA_ITINERARIO")
public final class UmbralActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UMBRAL_SEQ")
    @SequenceGenerator(sequenceName = "UMBRALACTIVIDAD_SEQ", allocationSize = 1, name = "UMBRAL_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;

    @Column(name = "element_type_id", nullable = false)
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer elementTypeId;
    @Column(name = "activity_id", nullable = false)
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer activityId;

    @Column(name = "is_for_delivery")
    @Min(0)
    @Max(1)
    private Integer forDelivery = Constantes.NUMBER_0;

    @Column(name = "lower_limit", nullable = false)
    @NotNull
    @Min(0)
    @Max(9999)
    private Integer lowerLimit;

    @Column(name = "upper_limit", nullable = false)
    @NotNull
    @Min(0)
    @Max(9999)
    private Integer upperLimit;

    @Column(name = "threshold", nullable = false)
    @NotBlank
    @Size(max = 150, message = "El tamaño máximo del campo Umbral es de 150 caracteres")
    private String threshold;

    @Column(name = "help", nullable = false)
    @NotBlank
    @Size(max = 150, message = "El tamaño máximo del campo Ayuda es de 150 caracteres")
    private String help;

    @Column(name = "exclude_unreached_threshold")
    @Min(0)
    @Max(1)
    private Integer excludeUnreachedThreshold = Constantes.NUMBER_0;

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

    public UmbralActividad() {

    }

    public UmbralActividad(final Integer id, final Integer elementTypeId, final Integer activityId,
                           final Integer forDelivery, final Integer lowerLimit, final Integer upperLimit,
                           final String threshold) {
        this.id = id;
        this.elementTypeId = elementTypeId;
        this.activityId = activityId;
        this.forDelivery = forDelivery;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.threshold = threshold;
    }
    @Override
    public String toString() {
        return "[" + this.lowerLimit + " - " + this.upperLimit + "]";
    }

}
