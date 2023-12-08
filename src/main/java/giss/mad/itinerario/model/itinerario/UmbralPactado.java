package giss.mad.itinerario.model.itinerario;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "UMBRALPACTADO", schema = "MACA_ITINERARIO")
public final class UmbralPactado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UMBRALPAC_SEQ")
    @SequenceGenerator(sequenceName = "UMBRALPAC_SEQ", allocationSize = 1, name = "UMBRALPAC_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(9999999)
    private Integer id;

    @Column(name = "activity_itinerary_id", nullable = false)
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer activityItineraryId;

    @Column(name = "value", nullable = false)
    @NotNull
    @Min(0)
    @Max(100)
    private Double value;

    @Column(name = "discharge_date")
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo fecha de liberación")
    private Timestamp dischargeDate;

    @Column(name = "creation_date", nullable = false)
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo fecha de alta")
    private Timestamp creationDate;

    @Column(name = "update_date")
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo fecha de actualización")
    private Timestamp updateDate;

    @Column(name = "is_deleted")
    @Min(0)
    @Max(1)
    private Integer deleted;

    public UmbralPactado() {

    }

    public UmbralPactado(final Integer id, final Integer activityItineraryId, final Double value,
                         final Timestamp dischargeDate, final Timestamp creationDate, final Timestamp updateDate,
                         final Integer deleted) {
        this.id = id;
        this.activityItineraryId = activityItineraryId;
        this.value = value;
        this.dischargeDate = dischargeDate;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.deleted = deleted;
    }

}
