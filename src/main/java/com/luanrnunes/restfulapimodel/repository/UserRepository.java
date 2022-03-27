package com.luanrnunes.restfulapimodel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luanrnunes.restfulapimodel.domain.User;

@Repository /*Anotation Spring que indica um repositorio*/
public interface UserRepository extends MongoRepository<User, String>{

	

}
