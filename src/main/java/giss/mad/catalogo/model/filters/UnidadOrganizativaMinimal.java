package giss.mad.catalogo.model.filters;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public final class UnidadOrganizativaMinimal {
    private Integer id;

    private String name;

    private String code;

    private String centro;


    public UnidadOrganizativaMinimal() {

    }

    public UnidadOrganizativaMinimal(final Integer idOf, final String code, final String nameOf, final String centro) {
        this.id = idOf;
        this.name = nameOf;
        this.code = code;
        this.centro = centro;
    }

}
