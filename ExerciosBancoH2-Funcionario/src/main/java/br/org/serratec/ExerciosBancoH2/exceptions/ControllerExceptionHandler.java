package br.org.serratec.ExerciosBancoH2.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErroResposta erroResposta = new ErroResposta(status.value(), "Existem campos invalidos", LocalDateTime.now());
		List<String> erros = new ArrayList<>();
		for (FieldError fe : ex.getFieldErrors()) {
			erros.add(fe.getField() + ": " + fe.getDefaultMessage());
		}
		erroResposta.setErros(erros);
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}

}
