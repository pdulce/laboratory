package giss.mad.itinerario.model.itinerario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ITINERARIOCALIDAD", schema = "MACA_ITINERARIO")
public final class ItinerarioCalidad {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITINERARIO_SEQ")
    @SequenceGenerator(sequenceName = "ITINERARIOCALIDAD_SEQ", allocationSize = 1, name = "ITINERARIO_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;

    @Column(name = "delivery_or_element_id", nullable = false)
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer catalogueId;

    @Column(name = "situacion_id", length = 6)
    @Min(1)
    @Max(9)
    private Integer situacionId;

    @Column(name = "is_current")
    @Min(0)
    @Max(1)
    private Integer current = 1;

    @Column(name = "observaciones_aprobacion", length = 150)
    @Size(max = 150, message = "El tamaño mínimo es 1 y máximo es 150 para el campo Observaciones de Aprobación")
    private String observacionesAprobacion;

    @Column(name = "is_delivery")
    @Min(0)
    @Max(1)
    private Integer delivery;

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

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ActividadItinerario.class)
    @JoinColumn(name = "quality_itinerary_id")
    private List<ActividadItinerario> actividadesDeItinerario;

    @Transient
    private String situacion;

    @Transient
    private Integer readOnly = 0;

    public ItinerarioCalidad() {

    }

    public ItinerarioCalidad(final String idAndVigenciaAndSituationId, final Integer catalogueId,
                             final Integer delivery, final String situacion,
                             final String observacionesAprobacion, final Timestamp creationDate,
                             final Timestamp updateDate) {
        String[] splitter = idAndVigenciaAndSituationId.split("\\|");
        this.id = Integer.parseInt(splitter[0]);
        this.current = Integer.parseInt(splitter[1]);
        if (splitter.length > 2) {
            this.situacionId = Integer.parseInt(splitter[2]);
        }
        this.catalogueId = catalogueId;
        this.delivery = delivery;
        this.situacion = situacion;
        this.observacionesAprobacion = observacionesAprobacion;
        this.creationDate = creationDate;
        this.updateDate = updateDate;

    }

    public ItinerarioCalidad(final Integer id, final Integer catalogueId, final Integer situationId,
                             final Integer current, final Timestamp creationDate,
                             final Timestamp updateDate, final Integer isDelivery) {
        this.id = id;
        this.catalogueId = catalogueId;
        this.situacionId = situationId;
        this.current = current;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.delivery = isDelivery;
    }

}
