package giss.mad.catalogo.model;

import java.sql.Timestamp;

import giss.mad.catalogo.utilities.Constantes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "VALORDOMINIOCONDICIONADOPOR", schema = Constantes.SCHEMA_NAME)
public final class ValorDominioCondicionadoPor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VALORDOMINIOCONDIT_SEQ")
    @SequenceGenerator(sequenceName = "VALORDOMINIOCONDITIONEDBY_SEQ", allocationSize = 1,
        name = "VALORDOMINIOCONDIT_SEQ")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;

    @Column(name = "domain_value_id")
    @Min(1)
    @Max(999999)
    private Integer domainValueId;

    @Column(name = "domain_value_collateral_id")
    @Min(1)
    @Max(999999)
    private Integer domainValueCollateralId;

    @Column(name = "is_deleted")
    @Min(0)
    @Max(1)
    private Integer deleted;

    @Column(name = "creation_date", nullable = false)
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo creationDate")
    private Timestamp creationDate;

    @Column(name = "update_date")
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo updateDate")
    private Timestamp updateDate;

    @Transient
    private String name;

    @Transient
    private String attributeName;

}
