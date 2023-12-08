package giss.mad.catalogo.mapper;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KafkaExchange {

    private Integer id;

    private List<PairAxisAndDomainId> domainvaluesList;

}
