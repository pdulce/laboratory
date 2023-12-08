package giss.mad.catalogo.model.jerarquiaEntregaCatalogo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class JerarquiaEntregaElementoCatalogoParent {

    private String name;

    private String version;

    private Timestamp deliveryDate;

    private List<JerarquiaEntregaElementoCatalogoChild> children = new ArrayList<>();
}
