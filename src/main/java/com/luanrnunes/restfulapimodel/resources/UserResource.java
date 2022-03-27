package com.luanrnunes.restfulapimodel.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	/*Este mapeamento indica que na URL ira buscar /users/valor de um id*/
	@RequestMapping(value="/{id}", method=RequestMethod.GET) /*Notation que indica o metodo request HTTP*/
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {		/*PathVariable indica que o ID recebido deve casar com a URL*/
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));	/*Retorna com o status ok e traz a lista no corpo do retorno*/
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {		
		User obj = service.fromDTO(objDto); /*Converte DTO para user*/
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build(); /*Retorna um codigo 201 e o cabeçalho contendo a localizacao do ultimo recurso criado*/
		
}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete (@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	
}
