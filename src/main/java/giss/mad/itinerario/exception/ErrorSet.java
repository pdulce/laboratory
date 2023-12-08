package giss.mad.itinerario.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ErrorSet {
    private List<ErrorHandler> errors;
}
