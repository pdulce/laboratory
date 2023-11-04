package com.mylabs.pds.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String codigo;

    @Column
    private Integer situacion;

    @ManyToOne
    @JoinColumn(name = "elemento_catalogo_id")
    private ElementoCatalogo elementoCatalogo;

}
