package org.generation.BlogPessoal.controller;

import java.util.List;

import org.generation.BlogPessoal.model.Tema;
import org.generation.BlogPessoal.repository.TemaRepository;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tema")
public class TemaController 
{
	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> getAll()
	{
		return ResponseEntity.status(200).body(repository.findAll());
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable int id)
	{
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElse(ResponseEntity.status(400).build());
	}
	
	@GetMapping("/tema/{tema}")
	public ResponseEntity<List<Tema>> getByName(@PathVariable String nome)
	{
		return ResponseEntity.status(200).body(repository.findAllByDescricaoContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Tema> post (@RequestBody Tema tema)
	{
		return ResponseEntity.status(201).body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> put (@RequestBody Tema tema)
	{
		return ResponseEntity.status(200).body(repository.save(tema));
	}
	
	@DeleteMapping("/tema/{id}")
	public void delete (@PathVariable int id)
	{
		repository.deleteById(id);
	}
}

