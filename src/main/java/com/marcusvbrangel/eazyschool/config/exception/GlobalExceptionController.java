package com.marcusvbrangel.eazyschool.config.exception;

import com.marcusvbrangel.eazyschool.exception.ResourceAlreadyExistsException;
import com.marcusvbrangel.eazyschool.exception.ResourceInUseException;
import com.marcusvbrangel.eazyschool.exception.ResourceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse = new ErrorResponse(
            httpStatus,
            "Ocorreu um erro interno no servidor",
            ex.getMessage()
        );
        log.error("Erro interno no servidor, código do log: {}", errorResponse.getCodigoLog(), ex);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorResponse errorResponse = new ErrorResponse(
            httpStatus,
            "O recurso solicitado não foi encontrado",
            ex.getMessage()
        );
        log.error("Recurso não encontrado, código do log: {}", errorResponse.getCodigoLog(), ex);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(ResourceInUseException.class)
    public ResponseEntity<ErrorResponse> handleResourceInUse(ResourceInUseException ex) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ErrorResponse errorResponse = new ErrorResponse(
            httpStatus,
            "O recurso está em uso e não pode ser modificado",
            ex.getMessage()
        );
        log.error("Recurso em uso, código do log: {}", errorResponse.getCodigoLog(), ex);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExists(ResourceAlreadyExistsException ex) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ErrorResponse errorResponse = new ErrorResponse(
            httpStatus,
            "Não pode realizar esta operação porque o recurso já existe",
            ex.getMessage()
        );
        log.error("Recurso já existe, código do log: {}", errorResponse.getCodigoLog(), ex);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        log.error("Erro de validação, código do log: {}", UUID.randomUUID().toString(), ex);
        return new ResponseEntity<>(errors, httpStatus);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationExceptions(ConstraintViolationException ex) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        Map<String, String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation -> {
            String fieldName = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        });
        log.error("Violação de restrição, código do log: {}", UUID.randomUUID().toString(), ex);
        return new ResponseEntity<>(errors, httpStatus);
    }

}
