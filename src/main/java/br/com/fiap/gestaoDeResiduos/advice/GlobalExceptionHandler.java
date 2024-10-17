package br.com.fiap.gestaoDeResiduos.advice;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException error) {

        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> campos = error.getBindingResult().getFieldErrors();

        for (FieldError campo : campos) {
            errorMap.put(campo.getField(), campo.getDefaultMessage());
        }

        return errorMap;

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    public Map<String, String> handleRuntimeException(RuntimeException error) {

        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Erro", error.getMessage());

        return errorMap;

    }

}