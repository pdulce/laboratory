package giss.mad.catalogo.model.auxejes;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatalogueNode {

    private List<CatalogueNode> children = new ArrayList<>();
    private String name;

    private String descripcion;
    @JsonIgnore
    private Integer id;
    private String level;

    private String cappCode;

    private String group;

    private Timestamp creationDate;

}
