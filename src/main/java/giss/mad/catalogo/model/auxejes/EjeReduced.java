package giss.mad.catalogo.model.auxejes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class EjeReduced {

    private Integer num;

    private String eje;

    public EjeReduced(final Integer id, final String name) {
        this.num = id;
        this.eje = name;
    }

    private EjeReduced() {

    }

}
