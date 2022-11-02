package br.org.serratec.backend.revisao.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptoinHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmailException.class)
	protected ResponseEntity<Object> handleEmailExceptoin(EmailException ex) {
	return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}
	
	@ExceptionHandler(SenhaException.class)
	protected ResponseEntity<Object> trataSenhaExceptoin(SenhaException ex) {
	return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}
}
