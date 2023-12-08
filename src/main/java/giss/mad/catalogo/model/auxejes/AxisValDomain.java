package giss.mad.catalogo.model.auxejes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AxisValDomain {

    private Integer id;
    private Integer axisAttributeId;
    private Integer domainValueId;

    public AxisValDomain() {

    }


    public AxisValDomain(final Integer id, final Integer axisAttributeId, final Integer domainValueId) {
        this.id = id;
        this.axisAttributeId = axisAttributeId;
        this.domainValueId = domainValueId;
    }

}
