package giss.mad.catalogo.model.filters;

import giss.mad.catalogo.model.ValoresEjesDeElemenCatalogoUsuario;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class ElementoCatalogoMinimal {
    private Integer id;

    private String name;

    private String cappCode;

    //@JsonProperty("attributeValuesCollection")
    private List<ValoresEjesDeElemenCatalogoUsuario> attributeValuesCollection;

    public ElementoCatalogoMinimal() {

    }

    public ElementoCatalogoMinimal(final Integer idOf, final String nameOf, final String cappCodeOf) {
        this.id = idOf;
        this.name = nameOf;
        this.cappCode = cappCodeOf;
    }



}
