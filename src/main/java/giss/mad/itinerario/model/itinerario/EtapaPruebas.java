package giss.mad.itinerario.model.itinerario;

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
@Table(name = "ETAPAPRUEBAS", schema = "MACA_ITINERARIO")
public final class EtapaPruebas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ETAPA_SEQ")
    @SequenceGenerator(sequenceName = "ETAPAPRUEBAS_SEQ", allocationSize = 1, name = "ETAPA_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;
    @Column(name = "name", unique = true, length = 50, nullable = false)
    @NotBlank
    @Size(min = 1, max = 50, message = "El tamaño máximo del campo Nombre es de 50 caracteres")
    private String name;

    @Column(name = "description")
    @NotBlank
    @Size(max = 150, message = "El tamaño máximo del campo Descripción es de 150 caracteres")
    private String description;

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

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ActividadQA.class)
    @JoinColumn(name = "testing_stage_id")
    private List<ActividadQA> actividadesQA;

    public EtapaPruebas() {

    }

    public EtapaPruebas(final Integer id, final String name, final String description, final Integer deleted,
                        final Timestamp creationDate, final Timestamp updateDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deleted = deleted;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

}
