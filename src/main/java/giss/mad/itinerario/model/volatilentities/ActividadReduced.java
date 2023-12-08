package giss.mad.itinerario.model.volatilentities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class ActividadReduced {

    private Integer num;
    private String actividad;

    public ActividadReduced(final Integer id, final String name) {
        this.num = id;
        this.actividad = name;
    }

    public ActividadReduced() {

    }
}
