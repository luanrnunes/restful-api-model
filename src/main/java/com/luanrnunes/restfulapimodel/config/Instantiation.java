package com.luanrnunes.restfulapimodel.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luanrnunes.restfulapimodel.domain.Post;
import com.luanrnunes.restfulapimodel.domain.User;
import com.luanrnunes.restfulapimodel.repository.PostRepository;
import com.luanrnunes.restfulapimodel.repository.UserRepository;

@Configuration /*Notation para o spring saber que se trata de configuracao. EX: Inicializar os dados na base.*/
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User eduarda = new User(null, "Eduarda Souza", "eduarda@eduarda.com");
		User marcos = new User(null, "Marcos Silva", "marcos@marcos.com");
		User fulano = new User(null, "Fulano Almeida", "fulano@fulano.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2021"), "Belo dia!", "Hoje é um dia muito belo!", eduarda);
		Post post2 = new Post(null, sdf.parse("21/03/2021"), "Notícia ruim", "Tenho uma notícia um pouco desagradável", marcos);
		
		userRepository.saveAll(Arrays.asList(eduarda,marcos,fulano));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
