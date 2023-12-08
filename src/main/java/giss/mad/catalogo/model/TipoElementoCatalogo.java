package giss.mad.catalogo.model;

import java.sql.Timestamp;
import java.util.List;

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
@Table(name = "TIPOELEMENTOCATALOGO", schema = Constantes.SCHEMA_NAME)
public final class TipoElementoCatalogo {

    public static final int ELEMENTO_PROMOCIONABLE = 1;
    public static final int APLICACION = 4;
    public static final int AGRUPACION_FUNCIONAL = 2;
    public static final int PROYECTO = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPOELEMCATALOGO_SEQ")
    @SequenceGenerator(sequenceName = "TIPOELEMENTOCATALOGO_SEQ", allocationSize = 1, name = "TIPOELEMCATALOGO_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false, length = 25)
    @NotBlank
    @Size(max = 50, message = "El tamaño máximo del campo Nombre es de 50 caracteres")
    private String name;

    @Column(name = "hierarchy_level")
    @NotNull
    @Min(1)
    @Max(4)
    private Integer hierarchyLevel;

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

    @OneToMany(cascade = CascadeType.ALL, targetEntity = AtributoEjePorTipoElemento.class)
    @JoinColumn(name = "catalog_element_type_id")
    private List<AtributoEjePorTipoElemento> atributosAsociados;

    public TipoElementoCatalogo() {
    }

    public TipoElementoCatalogo(final int id) {
        this.id = id;
    }

    public TipoElementoCatalogo(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

}
