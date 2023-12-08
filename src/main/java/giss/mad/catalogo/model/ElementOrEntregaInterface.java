package giss.mad.catalogo.model;

import java.util.List;

public interface ElementOrEntregaInterface {

    String getName();

    String getCappCode();

    Integer getGroupId();

    List<ValoresEjesDeEntregaUsuario> getReleaseAttributeValuesCollection();

    List<ValoresEjesDeElemenCatalogoUsuario> getCatalogueAttributeValuesCollection();

}
