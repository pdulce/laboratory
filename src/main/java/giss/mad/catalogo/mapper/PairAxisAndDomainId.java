package giss.mad.catalogo.mapper;


import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PairAxisAndDomainId {

    private Integer axisId;
    private Integer domainId;

    public PairAxisAndDomainId() {

    }

    public PairAxisAndDomainId(final Integer axisId, final Integer domainId) {
        this.axisId = axisId;
        this.domainId = domainId;
    }

}
