package com.mylabs.pds.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private Integer situacion;

    @ManyToOne
    @JoinColumn(name = "elemento_catalogo_id")
    private ElementoCatalogo elementoCatalogo;

}
