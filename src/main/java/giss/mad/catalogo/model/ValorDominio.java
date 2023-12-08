package giss.mad.catalogo.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import giss.mad.catalogo.utilities.Constantes;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "VALORDOMINIO", schema = Constantes.SCHEMA_NAME)
public final class ValorDominio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VALORDOMINIO_SEQ")
    @SequenceGenerator(sequenceName = "VALORDOMINIO_SEQ", allocationSize = 1, name = "VALORDOMINIO_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;

    @Column(name = "name", length = 500, nullable = false)
    @NotBlank
    @Size(max = 100, message = "El tamaño mínimo es de 1 carácter y el máximo es de 100 para el campo Nombre")
    private String name;

    @Column(name = "axis_attribute_id", nullable = false)
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer axisAttributeId;

    @Column(name = "for_catalogue")
    @Min(0)
    @Max(1)
    private Integer forCatalogue;

    @Column(name = "for_delivery")
    @Min(0)
    @Max(1)
    private Integer forDelivery;

    @Column(name = "is_deleted")
    @Min(0)
    @Max(1)
    private Integer deleted;

    @Transient
    private String attributeName;

    @Column(name = "creation_date", nullable = false)
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo creationDate")
    private Timestamp creationDate;

    @Column(name = "update_date")
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo updateDate")
    private Timestamp updateDate;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ValorDominioCondicionadoPor.class)
    @JoinColumn(name = "domain_value_id")
    private List<ValorDominioCondicionadoPor> masterDomainValues;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, targetEntity = ValorDominioDeAttrElemCat.class, orphanRemoval = false)
    @JoinColumn(name = "domain_value_id")
    private List<ValorDominioDeAttrElemCat> elementDomainValues;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, targetEntity = ValorDominioDeAttrEntrega.class, orphanRemoval = false)
    @JoinColumn(name = "domain_value_id")
    private List<ValorDominioDeAttrEntrega> deliveryDomainValues;

    public ValorDominio() {

    }

    public ValorDominio(final Integer id, final String name, final String attributeName, final Integer forCatalogue,
                        final Integer forDelivery, final Integer deleted) {
        this.id = id;
        this.name = name;
        this.attributeName = attributeName;
        this.forCatalogue = forCatalogue;
        this.forDelivery = forDelivery;
        this.deleted = deleted;
    }
    @Override
    public boolean equals(final Object o) {
        boolean retorno;
        if (this == o) {
            retorno = true;
        } else if (o == null || getClass() != o.getClass()) {
            retorno = false;
        } else {
            ValorDominio that = (ValorDominio) o;
            retorno = Objects.equals(id, that.id);
        }
        return retorno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
