package com.orders.application.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object> handleOrderNotFoundException(OrderNotFoundException ex, WebRequest request) {
        // TODO(reto): Implementar manejo de excepciones para OrderNotFoundException
        // Debe retornar un ResponseEntity con un cuerpo que incluya:
        // - timestamp: LocalDateTime.now()
        // - status: HttpStatus.NOT_FOUND.value()
        // - error: "Not Found"
        // - message: ex.getMessage()
        // - path: request.getDescription(false).replace("uri=", "")
        // - context: ex.getContext()
        Map<String, Object> body = new LinkedHashMap<>();
        return ResponseEntity.ok(body);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        // TODO(reto): Implementar manejo de excepciones para IllegalArgumentException
        // Debe retornar un ResponseEntity con un cuerpo similar al anterior pero con status 400
        Map<String, Object> body = new LinkedHashMap<>();
        return ResponseEntity.ok(body);
    }
}