package giss.mad.catalogo.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import giss.mad.catalogo.utilities.Constantes;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
@Table(name = "ENTREGAELEMENTOCATALOGO", schema = Constantes.SCHEMA_NAME)
public final class EntregaElementoCatalogo implements ElementOrEntregaInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTREGAELEMCATALOGUE_SEQ")
    @SequenceGenerator(sequenceName = "ENTREGAELEMENTOCATALOGO_SEQ", allocationSize = 1,
        name = "ENTREGAELEMCATALOGUE_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;
    @Column(name = "name", unique = true, length = 50, nullable = false)
    @NotBlank
    @Size(max = 50, message = "El tamaño máximo del campo Nombre es de 50 caracteres")
    private String name;

    @Column(name = "catalog_element_id", nullable = false)
    @NotNull
    @Min(1)
    @Max(999999)
    private Integer catalogElementId;

    @Column(name = "group_id")
    @Min(1)
    @Max(999999)
    private Integer groupId;

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


    @Column(name = "delivery_catalog_element_collateral_id")
    @Min(1)
    @Max(999999)
    private Integer deliveryCatalogElementCollateralId;

    @Column(name = "production_delivery_date")
    private Timestamp productionDeliveryDate;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ValoresEjesDeEntregaUsuario.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_catalog_element_id")
    @Fetch(FetchMode.JOIN) // necesario en H2 para carga en memoria de esta lista
    private List<ValoresEjesDeEntregaUsuario> attributeValuesCollection;

    @Transient
    private String cappCode;

    @Transient
    private String group;

    @Transient
    private Integer catalogElementTypeId;

    @Transient
    private Integer readOnly = 0;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = EntregaElementoCatalogo.class,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_catalog_element_collateral_id")
    @Fetch(FetchMode.JOIN) // necesario en H2 para carga en memoria de esta lista
    private List<EntregaElementoCatalogo> subElements;

    public EntregaElementoCatalogo() {
    }

    public EntregaElementoCatalogo(final String idAndName, final String cappCodeAndCatalogElementId,
                                   final String catalogElementTypeIdAndGroupId,
                                   final Timestamp creationDate,
                                   final Timestamp updateDate, final Integer deliveryCatalogElementCollateralId,
                                   final Timestamp productionDeliveryDate) {
        String[] splitterIdAndName = idAndName.split("\\|");
        this.id = Integer.valueOf(splitterIdAndName[0]);
        this.name = splitterIdAndName[1];

        String[] splitterCappCodeAndCatalogElementId = cappCodeAndCatalogElementId.split("\\|");
        this.cappCode = splitterCappCodeAndCatalogElementId[0];
        this.catalogElementId = Integer.valueOf(splitterCappCodeAndCatalogElementId[1]);

        String[] splitterCCatalogElementTypeIdAndGroupId = catalogElementTypeIdAndGroupId.split("\\|");
        this.catalogElementTypeId = Integer.valueOf(splitterCCatalogElementTypeIdAndGroupId[0]);
        this.groupId = Integer.valueOf(splitterCCatalogElementTypeIdAndGroupId[1]);
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.deliveryCatalogElementCollateralId = deliveryCatalogElementCollateralId;
        this.productionDeliveryDate = productionDeliveryDate;
    }

    public EntregaElementoCatalogo(final String idAndName, final String cappCode,
                                   final Integer catalogElementId, final Integer catalogElementTypeId,
                                   final Integer groupId, final Timestamp creationDate,
                                   final Timestamp updateDate) {
        String[] splitter = idAndName.split("\\|");
        this.id = Integer.valueOf(splitter[0]);
        this.name = splitter[1];
        this.cappCode = cappCode;
        this.catalogElementId = catalogElementId;
        this.catalogElementTypeId = catalogElementTypeId;
        this.groupId = groupId;
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
            EntregaElementoCatalogo that = (EntregaElementoCatalogo) o;
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
        return this.attributeValuesCollection;
    }

    @Override
    public List<ValoresEjesDeElemenCatalogoUsuario> getCatalogueAttributeValuesCollection() {
        return null;
    }

}
