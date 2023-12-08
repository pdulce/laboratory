package giss.mad.catalogo.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import giss.mad.catalogo.utilities.Constantes;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "ELEMENTOCATALOGO", schema = Constantes.SCHEMA_NAME)
public final class ElementoCatalogo implements ElementOrEntregaInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ELEMENTOCATALOGO_SEQ")
    @SequenceGenerator(sequenceName = "ELEMENTOCATALOGO_SEQ", allocationSize = 1, name = "ELEMENTOCATALOGO_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;
    @Column(name = "name", unique = true, length = 50, nullable = false)
    @NotBlank
    @Size(max = 50, message = "El tamaño mínimo es 2 y máximo es 50 para el campo Nombre")
    private String name;

    @Column(name = "capp_code", length = 50)
    @NotBlank
    @Pattern(regexp = "^[A-Z0-9]*",
            message = "Solo se admiten dígitos o letras en mayúscula para el campo Código")
    @Size(min = 4, max = 8, message = "El tamaño mínimo es 4 y el máximo 8 para el campo Código")
    private String cappCode;

    @Column(name = "catalog_element_type_id", nullable = false)
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer catalogElementTypeId;

    @Column(name = "catalog_element_collateral_id")
    @Min(1)
    @Max(999999)
    private Integer catalogElementCollateralId;

    @Column(name = "group_id")
    @Min(1)
    @Max(999999)
    private Integer groupId;

    @Column(name = "resp_management_id")
    @Min(1)
    @Max(999999)
    private Integer respManagementId;

    @Column(name = "resp_development_id")
    @Min(1)
    @Max(999999)
    private Integer respDevelopmentId;

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

    @Transient
    private ElementoCatalogo parentElement;

    @Transient
    private String responsableTto;

    @Transient
    private Integer incomplete;

    @Transient
    private Integer readOnly = 0;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ValoresEjesDeElemenCatalogoUsuario.class,
        fetch = FetchType.EAGER)
    @JoinColumn(name = "catalog_element_id")
    @Fetch(FetchMode.JOIN) // necesario en H2 para carga en memoria de esta lista
    private List<ValoresEjesDeElemenCatalogoUsuario> attributeValuesCollection;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = EntregaElementoCatalogo.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "catalog_element_id")
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    private List<EntregaElementoCatalogo> deliveryCollection;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ElementoCatalogo.class,
        fetch = FetchType.EAGER)
    @JoinColumn(name = "catalog_element_collateral_id")
    @Fetch(FetchMode.JOIN) // necesario en H2 para carga en memoria de esta lista
    private List<ElementoCatalogo> subElements;

    public ElementoCatalogo() {

    }

    public ElementoCatalogo(final Integer id, final String name, final String cappCode,
        final Integer catalogElementCollateralId, final Integer groupId,
        final Timestamp creationDate, final Timestamp updateDate) {
        this.id = id;
        this.name = name;
        this.cappCode = cappCode;
        this.catalogElementCollateralId = catalogElementCollateralId;
        this.groupId = groupId;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public ElementoCatalogo(final Integer id, final String name, final String cappCode,
                            final Integer catalogElementCollateralId, final Integer groupId,
                            final Integer catalogElementTypeId, final Timestamp creationDate) {
        this.id = id;
        this.name = name;
        this.cappCode = cappCode;
        this.catalogElementCollateralId = catalogElementCollateralId;
        this.groupId = groupId;
        this.catalogElementTypeId = catalogElementTypeId;
        this.creationDate = creationDate;
    }
    public ElementoCatalogo(final Integer id, final String cappCode, final String name,
                            final Set attributeValuesCollection) {
        this.id = id;
        this.name = name;
        this.cappCode = cappCode;
        this.attributeValuesCollection = new ArrayList<>(attributeValuesCollection);
    }

    public ElementoCatalogo(final Integer id, final String cappCode, final String name) {
        this.id = id;
        this.cappCode = cappCode;
        this.name = name;
    }

    public ElementoCatalogo(final Integer id, final String cappCode) {
        this.id = id;
        this.cappCode = cappCode;
    }


    public ElementoCatalogo(final String cappAndnameAndType, final Integer catalogElementCollateralId,
                            final Integer groupId, final Integer respManagementId, final Integer respDevelopmentId,
                            final Timestamp creationDate, final Timestamp updateDate) {

        String[] splitter = cappAndnameAndType.split("\\|");
        this.id = Integer.valueOf(splitter[0]);
        this.cappCode = splitter[Constantes.NUMBER_1];
        this.name = splitter[Constantes.NUMBER_2];
        this.catalogElementTypeId = Integer.valueOf(splitter[Constantes.NUMBER_3]);
        this.catalogElementCollateralId = catalogElementCollateralId;
        this.groupId = groupId;
        this.respManagementId = respManagementId;
        this.respDevelopmentId = respDevelopmentId;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }


    @Override
    public boolean equals(final Object o) {
        boolean retorno;
        if (this == o) {
            retorno = true;
        } else if (o == null || getClass() != o.getClass()) {
            retorno = false;
        } else {
            ElementoCatalogo that = (ElementoCatalogo) o;
            retorno = Objects.equals(id, that.id);
        }
        return retorno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public List<ValoresEjesDeEntregaUsuario> getReleaseAttributeValuesCollection() {
        return null;
    }

    @Override
    public List<ValoresEjesDeElemenCatalogoUsuario> getCatalogueAttributeValuesCollection() {
        return this.attributeValuesCollection;
    }

}
