package giss.mad.catalogo.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public final class Usuario {

    private Integer id;

    private Integer roleId;

    private String name;

    private String email;
    private String silconCode;

    private String codDepartamento;

    private String group;

    private String roleName;

    private Grupo dptoFisico;

    private Grupo unidadFuncional;

}

