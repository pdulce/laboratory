package giss.mad.itinerario.model.filters;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class ItinerarioFilter {
    private Date startDate;
    private Date endDate;
    private Integer current;
    private List<Integer> elementsIds;
    private Integer isDelivery;
    private Integer situationId;

    public ItinerarioFilter() {

    }

    public ItinerarioFilter(final Date startDate, final Date endDate, final Integer current,
                            final List<Integer> elementsIds, final Integer isDelivery,
                            final Integer situationId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.current = current;
        this.elementsIds = elementsIds;
        this.isDelivery = isDelivery;
        this.situationId = situationId;
    }

    public ItinerarioFilter(final Date startDate, final Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ItinerarioFilter(final Date startDate, final Date endDate, final Integer current) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.current = current;
    }

    public ItinerarioFilter(final Date startDate, final Date endDate, final List<Integer> elementsIds) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.elementsIds = elementsIds;
    }

    public ItinerarioFilter(final Integer current) {
        this.current = current;
    }

    public ItinerarioFilter(final Integer current, final List<Integer> elementsIds) {
        this.current = current;
        this.elementsIds = elementsIds;
    }

    public ItinerarioFilter(final List<Integer> elementsIds) {
        this.elementsIds = elementsIds;
    }

    public ItinerarioFilter(final Integer isDelivery, final Integer current) {
        this.isDelivery = isDelivery;
        this.current = current;
    }
}
