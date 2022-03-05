package com.luanrnunes.restfulapimodel.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luanrnunes.restfulapimodel.domain.User;
import com.luanrnunes.restfulapimodel.dto.UserDTO;
import com.luanrnunes.restfulapimodel.services.UserService;

@RestController  /*Notation que indica um controlador Rest*/
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET) /*Notation que indica o metodo request HTTP*/
	/*ResponseEntity e um metodo spring que ja trata diversoss erros web, basta utiliza
	 * junto a um objeto, neste caso, a lista de usuarios*/
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);	/*Retorna com o status ok e traz a lista no corpo do retorno*/
	}

}
