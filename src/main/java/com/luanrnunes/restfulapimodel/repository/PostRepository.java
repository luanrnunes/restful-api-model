package com.luanrnunes.restfulapimodel.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.luanrnunes.restfulapimodel.domain.Post;

@Repository /*Anotation Spring que indica um repositorio*/
public interface PostRepository extends MongoRepository<Post, String>{

	

}
