package giss.mad.catalogo.model.filters;

import giss.mad.catalogo.utilities.Constantes;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
public final class ElementoCatalogoFilter {


    public ElementoCatalogoFilter() {

    }

    public ElementoCatalogoFilter(final Integer idTypeOfElem, final String composedGroupAndOthers,
                                  final String composedDomainValues, final Integer deleted,
                                  final Timestamp fecAlta, final Timestamp fecUpdate) {
        this.idOfCatalogueElementType = idTypeOfElem;
        if (composedGroupAndOthers != null) {
            String[] splitterGroupAndOthers = composedGroupAndOthers.split("\\|");
            this.group = splitterGroupAndOthers[Constantes.NUMBER_0];
            this.catalogueElementTypeName = splitterGroupAndOthers[Constantes.NUMBER_1];
            this.code = splitterGroupAndOthers[Constantes.NUMBER_2];
            this.name = splitterGroupAndOthers.length == Constantes.NUMBER_4
                    ? splitterGroupAndOthers[Constantes.NUMBER_3] : "";
            this.responsible = splitterGroupAndOthers.length == Constantes.NUMBER_5
                    ? splitterGroupAndOthers[Constantes.NUMBER_4] : "";
            this.contratoResponDesa = splitterGroupAndOthers.length == Constantes.NUMBER_6
                    ? splitterGroupAndOthers[Constantes.NUMBER_5] : "";
        }
        if (composedDomainValues != null) {
            String[] splitterIdsDomain = composedDomainValues.split("\\|");
            this.functionalAreaName = splitterIdsDomain.length < 1
                    || splitterIdsDomain[Constantes.NUMBER_0].contentEquals("") ? null
                    : splitterIdsDomain[Constantes.NUMBER_0];
            this.computerProcessing = splitterIdsDomain.length < 2
                    || splitterIdsDomain[Constantes.NUMBER_1].contentEquals("") ? null
                    : splitterIdsDomain[Constantes.NUMBER_1];
            this.situation = splitterIdsDomain.length < Constantes.NUMBER_3
                    || splitterIdsDomain[Constantes.NUMBER_2].contentEquals("") ? null
                    : splitterIdsDomain[Constantes.NUMBER_2];
        }
        if (deleted != null) {
            if (fecUpdate != null) {
                this.setEndDate(new Date(fecUpdate.getTime()));
            } else {
                this.setEndDate(new Date(fecAlta.getTime()));
            }
        }
    }

    private Integer idOfCatalogueElementType;
    private String catalogueElementTypeName;
    private String code;
    private String responsible;
    private String contratoResponDesa;
    private String functionalAreaName;
    private Integer functionalAreaId;
    private String computerProcessing;
    private Integer computerProcessingId;
    private String group;
    private String name;
    private String description;
    private String situation;
    private Integer situationId;
    private Date startDate;
    private Date endDate;
    private Integer groupId;
    private Integer axisAttribute;
    private Integer domainValue;
}
