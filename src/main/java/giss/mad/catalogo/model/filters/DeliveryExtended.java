package giss.mad.catalogo.model.filters;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import giss.mad.catalogo.model.ValoresEjesDeEntregaUsuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class DeliveryExtended {

    private Integer id;

    private String role;

    private Integer catalogElementTypeId;

    private Integer groupId;

    private String name;

    private String group;
    private String cappCode;
    private Integer catalogElementId;
    @JsonIgnore
    private Integer deleted;

    private Timestamp creationDate;

    private Timestamp startDate;

    private Timestamp endDate;

    private Integer userId;

    private Integer readOnly = 0;

    @JsonIgnore
    private Timestamp updateDate;

    private List<ValoresEjesDeEntregaUsuario> attributeValuesCollection;

    private Timestamp deliveryDate;

    private String version;

    private String extendedName;

    public DeliveryExtended() {
    }

}
