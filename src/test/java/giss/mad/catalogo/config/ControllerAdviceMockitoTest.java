package giss.mad.catalogo.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import giss.mad.catalogo.exception.ErrorHandler;
import jakarta.validation.ConstraintViolationException;

import java.lang.reflect.Executable;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;

class ControllerAdviceMockitoTest {
    /**
     * Method under test:
     * {@link ControllerAdvice#handleValidationException(ConstraintViolationException)}
     */
    @Test
    void testHandleValidationException() {
        ControllerAdvice controllerAdvice = new ControllerAdvice();
        List<ErrorHandler> errors = controllerAdvice
                .handleValidationException(new ConstraintViolationException(new HashSet<>()))
                .getErrors();
        assertEquals(1, errors.size());
        ErrorHandler getResult = errors.get(0);
        assertEquals("400 BAD_REQUEST", getResult.getCode());
        assertEquals("Errores de entrada de datos: ", getResult.getMessage());
        assertEquals(400, getResult.getHttpCode().intValue());
    }

    /**
     * Method under test:
     * {@link ControllerAdvice#handleValidationException(Exception)}
     */
    @Test
    void testHandleValidationException2() {
        ControllerAdvice controllerAdvice = new ControllerAdvice();
        assertTrue(controllerAdvice.handleValidationException(new Exception("foo")).getErrors().isEmpty());
    }

    /**
     * Method under test:
     * {@link ControllerAdvice#handleValidationException(MethodArgumentNotValidException)}
     */
    @Test
    void testHandleValidationException3() {
        ControllerAdvice controllerAdvice = new ControllerAdvice();
        List<ErrorHandler> errors = controllerAdvice
                .handleValidationException(
                        new MethodArgumentNotValidException((Executable) null, new BindException("Target", "Object Name")))
                .getErrors();
        assertEquals(1, errors.size());
        ErrorHandler getResult = errors.get(0);
        assertEquals("400 BAD_REQUEST", getResult.getCode());
        assertEquals("Errores de entrada de datos: ", getResult.getMessage());
        assertEquals(400, getResult.getHttpCode().intValue());
    }
}
