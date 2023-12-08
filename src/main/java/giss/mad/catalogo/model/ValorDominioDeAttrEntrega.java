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

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "VALORDOMINIODEATTRENTREGA", schema = Constantes.SCHEMA_NAME)
public final class ValorDominioDeAttrEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "valordominiodeattrentrega_seq")
    @SequenceGenerator(sequenceName = "valordominiodeattrentrega_seq", allocationSize = 1,
        name = "valordominiodeattrentrega_seq")
    @Column(name = "id", nullable = false)
    @Min(1)
    @Max(999999)
    private Integer id;

    @Column(name = "domain_value_id")
    @Min(1)
    @Max(999999)
    private Integer domainValueId;
    @Column(name = "valor_eje_entrega_id")
    @Min(1)
    @Max(999999)
    private Integer valorEjeEntregaId;

    @Column(name = "is_deleted")
    @JsonIgnore
    @Min(0)
    @Max(1)
    private Integer deleted;

    @Column(name = "creation_date", nullable = false)
    @JsonIgnore
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo creationDate")
    private Timestamp creationDate;

    @Column(name = "update_date")
    @JsonIgnore
    @PastOrPresent(message = "Debe cumplir formato de fecha el campo updateDate")
    private Timestamp updateDate;


}
