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
import jakarta.persistence.Transient;
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
@Table(name = "ACTIVIDADQA", schema = "MACA_ITINERARIO")
public final class ActividadQA {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTIVIDAD_SEQ")
    @SequenceGenerator(sequenceName = "ACTIVIDADQA_SEQ", allocationSize = 1, name = "ACTIVIDAD_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;
    @Column(name = "name", unique = true, length = 100, nullable = false)
    @NotBlank
    @Size(max = 100, message = "El tamaño máximo del campo Nombre es de 100 caracteres")
    private String name;
    @Column(name = "short_name", unique = true, length = 50, nullable = false)
    @NotBlank
    @Size(max = 50, message = "El tamaño máximo del campo Nombre abreviado es de 50 caracteres")
    private String shortName;
    @Column(name = "testing_stage_id")
    @Min(1)
    @Max(999999)
    private Integer testingStageId;
    @Column(name = "description")
    @Size(max = 150, message = "El tamaño máximo del campo Descripción es de 150 caracteres")
    private String description;

    @Column(name = "help")
    @Size(max = 150, message = "El tamaño máximo del campo Ayuda es de 150 caracteres")
    private String help;

    @Column(name = "ideal_threshold")
    @Size(max = 150, message = "El tamaño máximo del campo Umbral ideal es de 150 caracteres")
    private String idealThreshold;

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
    private String stageQAName;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Peso.class)
    @JoinColumn(name = "activity_id")
    private List<Peso> pesos;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = UmbralActividad.class)
    @JoinColumn(name = "activity_id")
    private List<UmbralActividad> umbrales;

    public ActividadQA() {

    }

    public ActividadQA(final Integer id, final Integer testingStageId, final String stageQAName,
                       final String nameAndShortAndDesc, final String helpAndUmbral, final Timestamp creationDate) {
        this.id = id;
        this.testingStageId = testingStageId;
        this.stageQAName = stageQAName;

        String[] names = nameAndShortAndDesc == null ? new String[]{"unknown", "unknown"}
                : nameAndShortAndDesc.split("\\|");

        this.name = names.length > 0 ? names[0] : "";
        this.shortName = names.length > 1 ? names[1] : "";
        this.description = names.length > 2 ? names[2] : "";

        String[] helpAndThresh = helpAndUmbral == null ? new String[]{""} : helpAndUmbral.split("\\|");
        this.help = helpAndThresh.length > 0 ? helpAndThresh[0] : "";
        this.idealThreshold = helpAndThresh.length > 1 ? helpAndThresh[1] : "";

        this.creationDate = creationDate;

    }


}
