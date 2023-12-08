package giss.mad.catalogo.model.jerarquiaEntregaCatalogo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class JerarquiaEntregaElementoCatalogoNode {

    @JsonIgnore
    private Integer id;

    private String name;

    private String version;

    private String level;

    private String cappCode;

    private String group;

    private Timestamp creationDate;

    private Timestamp deliveryDate;

    private List<JerarquiaEntregaElementoCatalogoNode> children = new ArrayList<>();

}
