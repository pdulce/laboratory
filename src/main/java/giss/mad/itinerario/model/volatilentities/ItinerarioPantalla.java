package giss.mad.itinerario.model.volatilentities;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public final class ItinerarioPantalla {

    @Id
    private Long id;

    private Integer elementId;

    private Integer situacionId;

    private String observacionesAprobacion;

    private Integer delivery;

    private Integer current;

    private Double avance;

    private Timestamp creationDate;

    private Integer readOnly = 0;

}
