package dev.rodrigo.desafiovotacao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(RegraNegocioException.class)
  public ResponseEntity<ErrorResponse> handleRegraNegocio(RegraNegocioException ex) {

    ErrorResponse error = new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());

    return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
  }
}
