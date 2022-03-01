package com.luanrnunes.restfulapimodel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanrnunes.restfulapimodel.domain.User;
import com.luanrnunes.restfulapimodel.repository.UserRepository;

@Service /*Anotation que indica uma classe de servico que pode ser injetavel em outras classes*/
public class UserService {

	@Autowired /*Usando o Autowired, o proprio Spring vai procurar a definicao deste
	objeto, que neste caso e o repositorio e vai instanciar o objeto, como se fosse
	UserRepository rep = new UserRepository() */
	
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();			/*findAll vai trazer todos os objetos do tipo User*/
	}
	
}
