package com.luanrnunes.restfulapimodel.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luanrnunes.restfulapimodel.domain.User;

@RestController  /*Notation que indica um controlador Rest*/
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET) /*Notation que indica o metodo request HTTP*/
	/*ResponseEntity e um metodo spring que ja trata diversoss erros web, basta utiliza
	 * jungo a um objeto, neste caso, a lista de usuarios*/
	public ResponseEntity<List<User>> findAll() {
		User maria = new User ("1", "Maria Brown", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);	/*Retorna com o status ok e traz a lista no corpo do retorno*/
	}

}
