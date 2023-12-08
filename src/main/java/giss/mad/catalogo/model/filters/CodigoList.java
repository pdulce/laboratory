package giss.mad.catalogo.model.filters;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodigoList {

    private Integer nivelOfCatalogue;

    private String[] codigos;

    private byte[] excelExtended;

}
