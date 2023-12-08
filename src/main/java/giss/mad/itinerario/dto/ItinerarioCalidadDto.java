package giss.mad.itinerario.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class ItinerarioCalidadDto {

    private Integer id;

    private Integer catalogueId;

    private Integer situacionId;

    private Integer current = 1;

    private String observacionesAprobacion;

    private Integer delivery;

    private Double avance = 0.0;

    private Integer deleted;

    private Timestamp creationDate;

    private Timestamp updateDate;

    private List<ActividadItinerarioDto> actividadesDeItinerario;

    private String situacion;

    private Integer readOnly = 0;

    public ItinerarioCalidadDto() {

    }
}
