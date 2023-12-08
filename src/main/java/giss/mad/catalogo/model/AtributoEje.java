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

import giss.mad.catalogo.model.auxejes.TipoElementoReduced;

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
@Table(name = "ATRIBUTOEJE", schema = Constantes.SCHEMA_NAME)
public final class AtributoEje {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ATRIBUTOEJE_SEQ")
    @SequenceGenerator(sequenceName = "ATRIBUTOEJE_SEQ", allocationSize = 1, name = "ATRIBUTOEJE_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;
    @Column(name = "name", unique = true, length = 50, nullable = false)
    @NotBlank
    @Size(max = 100, message = "El tamaño mínimo es 2 y máximo es 100 para el campo Nombre.")
    private String name;

    @Column(name = "code", length = 20, nullable = false)
    @NotBlank
    @Size(max = 20, message = "El tamaño mínimo es 2 y máximo es 20 para el campo Código.")
    private String code;

    @Column(name = "is_axis", nullable = false)
    @NotNull
    @Min(0)
    @Max(1)
    private Integer axis = Constantes.NUMBER_0;

    @Column(name = "is_mandatory", nullable = false)
    @NotNull
    @Min(0)
    @Max(1)
    private Integer mandatory = Constantes.NUMBER_0;

    @Column(name = "defaultvalue")
    @Size(max = 50, message = "El tamaño máximo del campo Es Obligatorio es de 50 caracteres")
    private String defaultValue;

    @Column(name = "is_from_capp", nullable = false)
    @NotNull
    @Min(0)
    @Max(1)
    private Integer fromCapp;

    @Column(name = "multiple", nullable = false)
    @NotNull
    @Min(0)
    @Max(1)
    private Integer multiple = Constantes.NUMBER_0;

    @Column(name = "long_description")
    @JsonIgnore
    @Min(0)
    @Max(1)
    private Integer longDescription = Constantes.NUMBER_0;

    @Column(name = "help", length = 1000)
    @Size(max = 1000, message = "El tamaño máximo del campo Ayuda es de 1000 caracteres")
    private String help;

    @Column(name = "axis_attribute_collateral_id")
    @Min(1)
    @Max(999999)
    private Integer axisAttributeCollateralId;

    @Column(name = "values_in_domain", nullable = false)
    @NotNull
    @Min(0)
    @Max(1)
    private Integer valuesInDomain = (this.getDomainValues() != null && !this.getDomainValues().isEmpty()) ? 1 : 0;

    @Column(name = "regex")
    //@Size(max = 250, message = "El tamaño máximo del campo Expresión regular es de 250 caracteres")
    private String regex;

    @Column(name = "observations")
    @Size(max = 250, message = "El tamaño máximo del campo Observaciones es de 250 caracteres")
    private String observations;

    @Column(name = "is_deleted")
    @Min(0)
    @Max(1)
    private Integer deleted;

    @Column(name = "read_only")
    @Min(0)
    @Max(1)
    private Integer readOnly;

    @Column(name = "hidden")
    @Min(0)
    @Max(1)
    private Integer hidden;

    @Column(name = "creation_date", nullable = false)
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo creationDate")
    private Timestamp creationDate;

    @Column(name = "update_date")
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo updateDate")
    private Timestamp updateDate;

    @Transient
    private List<TipoElementoReduced> elementypes;

    @Transient
    private Integer aplicaAReleases;

    @Transient
    private Integer aplicaACatalogo;

    @OneToMany(cascade = CascadeType.REMOVE, targetEntity = ValorDominio.class)
    @JoinColumn(name = "axis_attribute_id")
    private List<ValorDominio> domainValues;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = AtributoEjePorTipoElemento.class)
    @JoinColumn(name = "axis_attribute_id")
    @JsonIgnore
    private List<AtributoEjePorTipoElemento> atributosAsociados;

    public AtributoEje() {

    }

    public AtributoEje(final String idAndRegex, final String name, final String code, final Integer axis,
                       final Integer mandatory, final Integer deleted, final Timestamp creationDate) {
        if (idAndRegex != null) {
            String[] splitter = idAndRegex.split("\\|");
            this.id = Integer.valueOf(splitter[0]);
            if (splitter.length > 1) {
                this.multiple = Integer.valueOf(splitter[Constantes.NUMBER_1]);
            }
            if (splitter.length > 2) {
                this.regex = splitter[Constantes.NUMBER_2];
            }
        }
        this.name = name;
        this.code = code;
        this.axis = axis;
        this.mandatory = mandatory;
        this.deleted = deleted;
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(final Object o) {
        boolean retorno;
        if (this == o) {
            retorno = true;
        } else if (o == null || getClass() != o.getClass()) {
            retorno = false;
        } else {
            AtributoEje that = (AtributoEje) o;
            retorno = Objects.equals(id, that.id);
        }
        return retorno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }
}
