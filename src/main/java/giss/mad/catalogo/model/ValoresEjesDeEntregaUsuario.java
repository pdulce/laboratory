package giss.mad.catalogo.model;

import java.sql.Timestamp;
import java.util.List;

import giss.mad.catalogo.utilities.Constantes;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "VALORESEJESDEENTREGAUSUARIO", schema = Constantes.SCHEMA_NAME)
public final class ValoresEjesDeEntregaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VALOREJEDEENTREGA_SEQ")
    @SequenceGenerator(sequenceName = "VALORESEJESENTREGAUSER_SEQ", allocationSize = 1, name = "VALOREJEDEENTREGA_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;

    @Column(name = "axis_attribute_id")
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer axisAttributeId;

    @Column(name = "delivery_catalog_element_id", nullable = false)
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer deliveryCatalogElementId;

    @Column(name = "user_value", length = 100)
    @Size(max = 100, message = "El tamaño máximo del campo Valor de usuario es de 100 caracteres")
    private String userValue;

    @Column(name = "is_deleted")
    @JsonIgnore
    @Min(0)
    @Max(1)
    private Integer deleted;

    @Column(name = "creation_date", nullable = false)
    @JsonIgnore
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo creationDate")
    private Timestamp creationDate;

    @Column(name = "update_date")
    @JsonIgnore
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo updateDate")
    private Timestamp updateDate;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ValorDominioDeAttrEntrega.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "valor_eje_entrega_id")
    private List<ValorDominioDeAttrEntrega> domainValues;

}
