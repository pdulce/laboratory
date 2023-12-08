package giss.mad.catalogo.service;

import giss.mad.catalogo.model.AtributoEje;
import giss.mad.catalogo.model.ElementOrEntregaInterface;

public interface ElementOrReleaseServiceInterface {


    String getValueOfAttr(AtributoEje atributoEje,
                                 ElementOrEntregaInterface item,
                                 ValorDominioService valorDominioService);

}
