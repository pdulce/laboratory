package giss.mad.catalogo.config;

import giss.mad.catalogo.exception.ErrorHandler;
import giss.mad.catalogo.exception.ErrorSet;
import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public final ErrorSet handleValidationException(final MethodArgumentNotValidException exc) {
        ErrorSet errorSet = new ErrorSet();
        StringBuilder strBuilder = new StringBuilder();
        List<ErrorHandler> errorsList = new ArrayList<>();
        exc.getBindingResult().getAllErrors().forEach((error) -> {
            if (!strBuilder.toString().isEmpty()) {
                strBuilder.append(", ");
            }
            strBuilder.append("[campo: ");
            strBuilder.append(((FieldError) error).getField());
            strBuilder.append("], causa:");
            strBuilder.append(error.getDefaultMessage());
        });
        ErrorHandler newError = new ErrorHandler(HttpStatus.BAD_REQUEST, "Errores de entrada de datos: "
                + strBuilder.toString());
        errorsList.add(newError);
        errorSet.setErrors(errorsList);
        return errorSet;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    public final ErrorSet handleValidationException(final ConstraintViolationException exc) {
        ErrorSet errorSet = new ErrorSet();
        StringBuilder strBuilder = new StringBuilder();
        List<ErrorHandler> errorsList = new ArrayList<>();
        exc.getConstraintViolations().forEach((error) -> {
            if (!strBuilder.toString().isEmpty()) {
                strBuilder.append(", ");
            }
            strBuilder.append(error.getMessage());
        });
        ErrorHandler newError = new ErrorHandler(HttpStatus.BAD_REQUEST, "Errores de entrada de datos: "
                + strBuilder.toString());
        errorsList.add(newError);
        errorSet.setErrors(errorsList);
        return errorSet;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public final ErrorSet handleValidationException(final Exception exc) {
        ErrorSet errorSet = new ErrorSet();
        List<ErrorHandler> errorsList = new ArrayList<>();
        errorSet.setErrors(errorsList);
        return errorSet;
    }


}
