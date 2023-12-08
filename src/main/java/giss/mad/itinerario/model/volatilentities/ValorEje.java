package giss.mad.itinerario.model.volatilentities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public final class ValorEje {

    @Id
    @JsonIgnore
    private Long id;

    private Integer axisAttributeId;
    private List<DomainValue> domainValues;

}
