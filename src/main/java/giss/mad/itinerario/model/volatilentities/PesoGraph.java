package giss.mad.itinerario.model.volatilentities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class PesoGraph {

    private Integer id;
    private Integer x;
    private Integer y;
    private Integer z;

    private String label;

    public PesoGraph() {

    }
    public PesoGraph(final Integer id, final String activityName, final Integer activityId,
                     final Integer axisAttributeId, final Integer weightValue) {
        this.id = id;
        this.label = activityName;
        this.x = activityId;
        this.y = axisAttributeId;
        this.z = weightValue;
    }
}
