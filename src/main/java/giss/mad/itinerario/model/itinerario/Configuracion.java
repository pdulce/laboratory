package giss.mad.itinerario.model.itinerario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

@Getter
@Setter
@Entity
@Table(name = "CONFIGURACION", schema = "MACA_ITINERARIO")
public class Configuracion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONFIGURACION_SEQ")
    @SequenceGenerator(sequenceName = "CONFIGURACION_SEQ", allocationSize = 1, name = "CONFIGURACION_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(9999)
    private Integer id;

    @Column(name = "key", unique = true, length = 50, nullable = false)
    @NotBlank
    @Size(min = 1, max = 50, message = "El tamaño máximo del campo Clave es de 50 caracteres")
    private String key;

    @Column(name = "value", unique = true, length = 50, nullable = false)
    @NotBlank
    @Size(min = 1, max = 150, message = "El tamaño máximo del campo Valor es de 150 caracteres")
    private String value;

    @Column(name = "description")
    @NotBlank
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


}
