package giss.mad.catalogo.exception;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorHandler {

    public static final String NOT_FOUND_MESSAGE = "Recurso solicitado inexistente";

    public static final String NOT_AVALAIBLE_MESSAGE = "Recurso no disponible";

    public static final String NOT_MODIFIED_MESSAGE =
            "Recurso no pudo ser creado/actualizado por dependencias de otros objetos";

    public static final String FORBIDDEN_MESSAGE = "Recurso solicitado no autorizado";
    private String message;
    private Integer httpCode;
    private String code;

    private ErrorHandler() {

    }
    public ErrorHandler(final HttpStatus httpCodeError, final String message) {
        this.httpCode = httpCodeError.value();
        this.code = httpCodeError.toString();
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }



}
