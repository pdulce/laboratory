package giss.mad.catalogo.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import giss.mad.catalogo.utilities.Constantes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "GRUPO", schema = Constantes.SCHEMA_NAME)
public final class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRUPO_SEQ")
    @SequenceGenerator(sequenceName = "GRUPO_SEQ", allocationSize = 1, name = "GRUPO_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;

    @Column(name = "codigo", unique = true, length = 18, nullable = false)
    @NotBlank
    @Size(max = 18, message = "El tamaño máximo del campo ID unidad responsable tratamiento es de 18 caracteres")
    private String codigo;
    @Column(name = "name", unique = true, length = 100, nullable = false)
    @NotBlank
    @Size(max = 100, message = "El tamaño máximo del campo Nombre es de 100 caracteres")
    private String name;
    @Column(name = "parent_group_id", length = 6)
    @Min(1)
    @Max(999999)
    private Integer parentGroupId;
    @Column(name = "tipo_id", length = 6)
    @Min(1)
    @Max(3)
    private Integer tipoId;
    @Transient
    private String tipo;
    @Column(name = "is_deleted")
    @Min(0)
    @Max(1)
    private Integer deleted;

    @Column(name = "creation_date", nullable = false)
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo creationDate")
    private Timestamp creationDate;

    @Column(name = "update_date")
    @JsonIgnore
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo updateDate")
    private Timestamp updateDate;

    @Transient
    private String parentGroupName;

    @JsonIgnore
    @Transient
    private List<Integer> childrenIds;

    public Grupo() {

    }
    public Grupo(final Integer id, final String codigo, final String name, final Integer parentGroupId,
                 final Integer tipoId, final Timestamp creationDate) {
        this.id = id;
        this.name = name;
        this.codigo = codigo;
        this.parentGroupId = parentGroupId;
        this.tipoId = tipoId;
        this.creationDate = creationDate;
    }

    public Grupo(final Integer id, final String tipo, final String codigo, final String name,
                 final String parentGroupName, final Integer deleted, final Timestamp creationDate) {
        this.id = id;
        this.tipo = tipo;
        this.codigo = codigo;
        this.name = name;
        this.parentGroupName = parentGroupName;
        this.deleted = deleted;
        this.creationDate = creationDate;
    }

    public Grupo(final Integer id, final Integer tipoId, final String codigo, final String name,
                 final Integer parentGroupId, final String parentGroupName) {
        this.id = id;
        this.tipoId = tipoId;
        this.codigo = codigo;
        this.name = name;
        this.parentGroupId = parentGroupId;
        this.parentGroupName = parentGroupName;
    }


    @Override
    public boolean equals(final Object o) {
        boolean retorno;
        if (this == o) {
            retorno = true;
        } else if (o == null || getClass() != o.getClass()) {
            retorno = false;
        } else {
            Grupo grupo = (Grupo) o;
            retorno = Objects.equals(codigo, grupo.codigo);
        }
        return retorno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
