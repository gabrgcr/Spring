package org.generation.BlogPessoal.controller;

import java.util.List;

import org.generation.BlogPessoal.model.Posts;
import org.generation.BlogPessoal.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Posts")
@CrossOrigin("*")
public class PostsController {
	
	@Autowired
	private PostsRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Posts>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Posts> GetById(@PathVariable int id)
	{
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Posts>> GetByTitulo (@PathVariable String titulo)
	{
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
}
