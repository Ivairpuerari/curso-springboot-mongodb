package com.ivairpuerari.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivairpuerari.workshopmongo.domain.Post;
import com.ivairpuerari.workshopmongo.repository.PostRepository;
import com.ivairpuerari.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;
	

	public Post findById(String id) {
		Optional<Post> post= repo.findById(id);
		return post.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date MaxDate){
		MaxDate = new Date(MaxDate.getTime() + 24 *60 * 60 *1000);
		return repo.fullSearch(text, minDate, MaxDate);
	}

}
