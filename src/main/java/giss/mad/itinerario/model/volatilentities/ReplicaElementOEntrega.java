package giss.mad.itinerario.model.volatilentities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public final class ReplicaElementOEntrega {

    @Id
    private Integer id;
    private Integer catalogElementTypeId;
    private Integer delivery;
    private String cappCode;
    private String attrValOnDemand;
    private String version;
    private List<ValorEje> attributeValuesCollection;
    private List<ValorEje> attributeValuesCollectionParent;
    @JsonProperty("children")
    private List<ReplicaElementOEntrega> hijos;
}
