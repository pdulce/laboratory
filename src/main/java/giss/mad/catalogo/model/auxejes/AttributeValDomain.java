package giss.mad.catalogo.model.auxejes;

import giss.mad.catalogo.utilities.Constantes;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@Getter
@Setter
public class AttributeValDomain {

    private Integer idAttr;
    private Integer axisAttributeId;
    private Timestamp creationDateAttr;
    private String userValue;
    private Integer idValDomainAttr;
    private Integer domainValueId;
    private Timestamp creationDateValDomainAttr;
    private Integer readOnly;
    private Integer hidden;

    public AttributeValDomain() {

    }

    public AttributeValDomain(final Integer idAttr, final Integer axisAttributeId, final Timestamp creationDateAttr,
                              final String userValue, final Integer idValDomainAttr,
                              final Integer domainValueId, final Timestamp creationDateValDomainAttr) {
        this.idAttr = idAttr;
        this.axisAttributeId = axisAttributeId;
        this.creationDateAttr = creationDateAttr;
        this.userValue = userValue;
        this.idValDomainAttr = idValDomainAttr;
        this.domainValueId = domainValueId;
        this.creationDateValDomainAttr = creationDateValDomainAttr;
    }

    public AttributeValDomain(final String campos) throws ParseException {
        String[] parts = Pattern.compile("\\|").split(campos, -1);
        this.idAttr = parts[Constantes.NUMBER_0].isEmpty() ? null : Integer.parseInt(parts[Constantes.NUMBER_0]);
        this.axisAttributeId = parts[Constantes.NUMBER_1].isEmpty() ? null
               : Integer.parseInt(parts[Constantes.NUMBER_1]);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss,SSSSSS");
        Date parsedCreationDateAttr = parts[Constantes.NUMBER_2].isEmpty() ? null
               : dateFormat.parse(parts[Constantes.NUMBER_2]);
        this.creationDateAttr = parsedCreationDateAttr == null ? null
               : new Timestamp(parsedCreationDateAttr.getTime());
        this.userValue = parts[Constantes.NUMBER_3];
        this.idValDomainAttr = parts[Constantes.NUMBER_4].isEmpty() ? null
              : Integer.parseInt(parts[Constantes.NUMBER_4]);
        this.domainValueId = parts[Constantes.NUMBER_5].isEmpty() ? null
               : Integer.parseInt(parts[Constantes.NUMBER_5]);
        Date parsedCreationDateValDomainAttr = parts[Constantes.NUMBER_6].isEmpty() ? null
               : dateFormat.parse(parts[Constantes.NUMBER_6]);
        this.creationDateValDomainAttr = parsedCreationDateValDomainAttr == null ? null
              : new Timestamp(parsedCreationDateValDomainAttr.getTime());
        this.readOnly = parts[Constantes.NUMBER_7].isEmpty() ? null
               : Integer.parseInt(parts[Constantes.NUMBER_7]);
        this.hidden = parts[Constantes.NUMBER_8].isEmpty() ? null
               : Integer.parseInt(parts[Constantes.NUMBER_8]);
    }
}
