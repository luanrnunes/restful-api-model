package com.luanrnunes.restfulapimodel.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luanrnunes.restfulapimodel.services.exception.ObjectNotFoundException;

@ControllerAdvice /*Indica que esta classe ira tratar erros nas requisicoes*/
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class) /*Padrao do framework para ele saber que nesta exception, deve executar o codigo abaixo*/
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not found", e .getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
