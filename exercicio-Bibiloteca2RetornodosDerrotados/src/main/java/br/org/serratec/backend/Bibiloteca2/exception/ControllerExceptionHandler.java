package br.org.serratec.backend.Bibiloteca2.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Object> trataDataNotFound(DataNotFoundException ex){
		return ResponseEntity.notFound().build();
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			List<String> retornoErros = new ArrayList<>();
			List<FieldError> lista = ex.getBindingResult().getFieldErrors();
			for (FieldError fe : lista) {
				retornoErros.add(fe.getField() + ":" + fe.getDefaultMessage());
			}
		return super.handleExceptionInternal(ex,retornoErros, headers, status, request);
	}
}
