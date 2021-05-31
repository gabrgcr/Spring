package org.generation.BlogPessoal.controller;

import java.util.List;

import org.generation.BlogPessoal.model.Posts;
import org.generation.BlogPessoal.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public ResponseEntity<Posts> postar (@RequestBody Posts postagem)
	{
		return ResponseEntity.status(201).body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Posts> editar (@RequestBody Posts postagem)
	{
		return ResponseEntity.status(200).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}/deletar/")
	public void deletar (@PathVariable int id)
	{
		repository.deleteById(id);
	}
}
