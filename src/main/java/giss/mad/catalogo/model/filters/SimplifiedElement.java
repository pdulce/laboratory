package giss.mad.catalogo.model.filters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifiedElement {

    private Integer id;
    private Integer groupId;
    private Integer respDevelopmentId;
    private Integer respManagementId;
    private String cappCode;
    private String name;
    private Integer elementTypeId;
    private String description;
    private String attrValOnDemand;

    private Integer readOnly = 0;
    private String respTtoLiteral;
    private String respDesaLiteral;
    private String respAdmonLiteral;

    public SimplifiedElement() {

    }

    public SimplifiedElement(final Integer id, final Integer groupId, final String cappCode,
                             final String attrValOnDemand) {
        this.id = id;
        this.groupId = groupId;
        this.cappCode = cappCode;
        this.attrValOnDemand = attrValOnDemand;
    }

    public SimplifiedElement(final Integer id, final String cappCode, final String name,
                             final Integer elementTypeId, final Integer groupId) {
        this.id = id;
        this.cappCode = cappCode;
        this.name = name;
        this.elementTypeId = elementTypeId;
        this.groupId = groupId;
    }

    public SimplifiedElement(final Integer id, final String cappCode) {
        this.id = id;
        this.cappCode = cappCode;
    }

    public SimplifiedElement(final Integer id, final String cappCode, final String name, final Integer elementTypeId) {
        this.id = id;
        this.cappCode = cappCode;
        this.name = name;
        this.elementTypeId = elementTypeId;
    }

    public SimplifiedElement(final String cappCode, final String name, final String description) {
        this.cappCode = cappCode;
        this.name = name;
        this.description = description;
    }

    public SimplifiedElement(final Integer id, final String cappCode, final String name, final Integer groupId,
                             final Integer respManagementId, final Integer respDevelopmentId) {
        this.id = id;
        this.name = name;
        this.cappCode = cappCode;
        this.groupId = groupId;
        this.respManagementId = respManagementId;
        this.respDevelopmentId = respDevelopmentId;
    }
}
