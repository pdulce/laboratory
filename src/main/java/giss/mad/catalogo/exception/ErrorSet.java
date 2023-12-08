package giss.mad.catalogo.exception;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorSet {
    private List<ErrorHandler> errors;
}
