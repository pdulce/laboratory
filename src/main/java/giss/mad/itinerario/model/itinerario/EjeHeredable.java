package giss.mad.itinerario.model.itinerario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
@Table(name = "EJEHEREDABLE", schema = "MACA_ITINERARIO")
public final class EjeHeredable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EJEHEREDABLE_SEQ")
    @SequenceGenerator(sequenceName = "EJEHEREDABLE_SEQ", allocationSize = 1, name = "EJEHEREDABLE_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;

    @Column(name = "element_type_id", nullable = false)
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer elementTypeId;

    @Column(name = "axis_attribute_id", nullable = false)
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer axisId;

    @Column(name = "for_delivery", nullable = false)
    @NotNull
    @Min(0)
    @Max(1)
    private Integer forDelivery;

    @Column(name = "writable", nullable = false)
    @NotNull
    @Min(0)
    @Max(1)
    private Integer writable;

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

    public EjeHeredable() {

    }

    public EjeHeredable(final Integer elementTypeId, final Integer axisId, final Integer forDelivery,
                        final Integer writable) {
        this.elementTypeId = elementTypeId;
        this.axisId = axisId;
        this.forDelivery = forDelivery;
        this.writable = writable;
    }

}
