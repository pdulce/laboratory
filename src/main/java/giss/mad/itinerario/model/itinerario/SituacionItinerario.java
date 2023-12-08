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
@Table(name = "SITUACIONITINERARIO", schema = "MACA_ITINERARIO")
public class SituacionItinerario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SITUACIONES_ITINERARIO_SEQ")
    @SequenceGenerator(sequenceName = "SITUACIONES_ITINERARIO_SEQ", allocationSize = 1,
            name = "SITUACIONES_ITINERARIO_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999)
    private Integer id;

    @Column(name = "name", unique = true, length = 50, nullable = false)
    @NotBlank
    @Size(max = 50, message = "El tamaño máximo del campo Nombre es de 50 caracteres")
    private String name;

    @Column(name = "description")
    @Size(max = 250, message = "El tamaño máximo del campo Descripción es de 250 caracteres")
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

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ItinerarioCalidad.class)
    @JoinColumn(name = "situacion_id")
    private List<ItinerarioCalidad> itinerarios;


}
