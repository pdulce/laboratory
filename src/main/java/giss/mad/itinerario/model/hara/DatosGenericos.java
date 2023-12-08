package giss.mad.itinerario.model.hara;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "DATOS_GENERICOS", schema = "HARA")
public final class DatosGenericos {
    @Id
    @Column(name = "DG_ID")
    private Integer id;

    @Column(name = "DG_DESCRIPCION")
    private String descripcion;

    @Column(name = "DG_DATOS")
    private byte[] datos;

    @Column(name = "DG_TEXT")
    private String texto;
}
