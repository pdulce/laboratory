package giss.mad.catalogo.model;

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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "TIPOUNIDADORG", schema = Constantes.SCHEMA_NAME)
public final class TipoUnidadOrganizativa {

    public static final int UNIDAD = 1;
    public static final int AREA = 2;
    public static final int CENTRO = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPOUNIDADORG_SEQ")
    @SequenceGenerator(sequenceName = "TIPOUNIDADORG_SEQ", allocationSize = 1, name = "TIPOUNIDADORG_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;
    @Column(name = "name", unique = true, nullable = false, length = 50)
    @NotBlank
    @Size(max = 50, message = "El tamaño mínimo es 1 y máximo es 50 para el campo Nombre")
    private String name;

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

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Grupo.class)
    @JoinColumn(name = "tipo_id")
    private List<Grupo> unidadesOrganizativas;


}
