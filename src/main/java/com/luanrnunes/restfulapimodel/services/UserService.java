package com.luanrnunes.restfulapimodel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanrnunes.restfulapimodel.domain.User;
import com.luanrnunes.restfulapimodel.dto.UserDTO;
import com.luanrnunes.restfulapimodel.repository.UserRepository;
import com.luanrnunes.restfulapimodel.services.exception.ObjectNotFoundException;

@Service /*Anotation que indica uma classe de servico que pode ser injetavel em outras classes*/
public class UserService {

	@Autowired /*Usando o Autowired, o proprio Spring vai procurar a definicao deste
	objeto, que neste caso e o repositorio e vai instanciar o objeto, como se fosse
	UserRepository rep = new UserRepository() */
	
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();			/*findAll vai trazer todos os objetos do tipo User*/
	}
	
	public User findById (String id) {
		Optional<User> obj = repo.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	
	public User insert (User obj) {
		return repo.insert(obj);
	}
	
	public void delete (String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO (UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}

