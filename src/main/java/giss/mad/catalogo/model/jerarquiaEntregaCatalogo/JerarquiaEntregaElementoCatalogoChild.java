package giss.mad.catalogo.model.jerarquiaEntregaCatalogo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class JerarquiaEntregaElementoCatalogoChild {

    private String name;

    private String version;

    private List<JerarquiaEntregaElementoCatalogoChild> children = new ArrayList<>();
}
