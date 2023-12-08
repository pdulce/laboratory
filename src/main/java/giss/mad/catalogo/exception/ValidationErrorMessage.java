package giss.mad.catalogo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationErrorMessage {

    private String message;

    public ValidationErrorMessage(final String msg) {
        this.message = msg;
    }
}
