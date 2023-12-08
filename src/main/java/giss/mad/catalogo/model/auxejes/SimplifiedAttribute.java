package giss.mad.catalogo.model.auxejes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimplifiedAttribute {

    private String cappCode;
    private String attrName;
    private String userValue;
    public SimplifiedAttribute() {

    }

    public SimplifiedAttribute(final String cappCode, final String attrName, final String userValue) {
        this.cappCode = cappCode;
        this.attrName = attrName;
        this.userValue = userValue;
    }
}
