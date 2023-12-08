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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "PESO", schema = "MACA_ITINERARIO")
public final class Peso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESO_SEQ")
    @SequenceGenerator(sequenceName = "PESO_SEQ", allocationSize = 1, name = "PESO_SEQ")
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

    @Column(name = "axis_attribute_id", nullable = false)
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer axisAttributeId;

    @Column(name = "domain_value_id", nullable = false)
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer domainValueId;

    @Column(name = "is_for_delivery", nullable = false)
    @NotNull
    @Min(0)
    @Max(1)
    private Integer forDelivery;

    @Column(name = "weight_value", nullable = false)
    @NotNull
    @Min(Constantes.NUMBER_MINUS_THREE)
    @Max(9999)
    private Integer weightValue;

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

    public Peso() {

    }

    public Peso(final Integer id, final Integer elementTypeId, final Integer activityId, final Integer axisAttributeId,
                final Integer domainValueId, final Integer forDelivery, final Integer weightValue) {
        this.id = id;
        this.elementTypeId = elementTypeId;
        this.activityId = activityId;
        this.axisAttributeId = axisAttributeId;
        this.domainValueId = domainValueId;
        this.forDelivery = forDelivery;
        this.weightValue = weightValue;
    }

}
