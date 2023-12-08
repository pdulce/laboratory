package giss.mad.itinerario.model.volatilentities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Tarea {

    public static final String TIPO_RAIZ = "desglose";
    public static final String TIPO_FOLDER = "carpeta";
    public static final String TIPO_PACKAGE = "package";
    public static final String TIPO_TESTCLASS = "clase de test";
    public static final String TIPO_TESTMETHOD = "método de test";

    private String test;

    private String name;

    private String methodName;

    private String arguments;

    private String returnType;

    private String className;

    private String packageName;

    private String sourceScanned;

    private String level;

    private List<String> imports;

    private List<Map<String, String>> memberDeclarations;

    private Integer numLines;

    private String contents;

    private byte[] byteArrayCompressed;

    private List<Tarea> children;

    @JsonIgnore
    private Integer numDependencies;

    @JsonIgnore
    private Boolean coverage;


    @JsonIgnore
    private String folderName;





}
