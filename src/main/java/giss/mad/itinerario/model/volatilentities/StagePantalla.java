package giss.mad.itinerario.model.volatilentities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public final class StagePantalla {
    @JsonIgnore
    private Integer idStage;
    private String stage;
    private List<ActividadQAPantalla> activities;

}
