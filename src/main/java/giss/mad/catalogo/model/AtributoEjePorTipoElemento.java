package giss.mad.catalogo.model;

import java.sql.Timestamp;

import giss.mad.catalogo.utilities.Constantes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ATRIBUTOEJEPORTIPOELEMENTO", schema = Constantes.SCHEMA_NAME)
public final class AtributoEjePorTipoElemento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATRIBUTOEJEPOTIPOELEM_SEQ")
    @SequenceGenerator(sequenceName = "ATRIBUTOEJEPORTIPOELEM_SEQ", allocationSize = 1,
        name = "ATRIBUTOEJEPOTIPOELEM_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;

    @Column(name = "axis_attribute_id")
    @Min(1)
    @Max(999999)
    private Integer axisAttributeId;

    @Column(name = "catalog_element_type_id")
    @Min(1)
    @Max(999999)
    private Integer catalogElementTypeId;

    @Column(name = "for_catalogue")
    @Min(0)
    @Max(1)
    private Integer forCatalogue = Constantes.NUMBER_0;

    @Column(name = "for_delivery")
    @Min(0)
    @Max(1)
    private Integer forDelivery = Constantes.NUMBER_0;

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


}
