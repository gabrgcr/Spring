package com.lggames.LG_Games.controller;

import com.lggames.LG_Games.model.Categoria;
import com.lggames.LG_Games.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/cat/")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository catrepository;

    @GetMapping("all/")
    public ResponseEntity<List<Categoria>> GetAll()
    {
        return ResponseEntity.ok(catrepository.findAll());
    }

    @GetMapping("{id}/")
    public ResponseEntity<Categoria> GetByID(@PathVariable long id)
    {
        return catrepository.findById(id).map(resp -> ResponseEntity.status(200).body(resp)).orElse(ResponseEntity.status(204).build());
    }

    @GetMapping("{nome}/")
    public ResponseEntity<Set<Categoria>> GetByNome(@PathVariable String nome)
    {
        return ResponseEntity.status(200).body(catrepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping("new")
    public ResponseEntity<Categoria> categoria (@RequestBody Categoria categoria)
    {
        return ResponseEntity.status(201).body(catrepository.save(categoria));
    }

    @PutMapping("edit")
    public ResponseEntity<Categoria> edit (@RequestBody Categoria categoria)
    {
        return ResponseEntity.status(200).body(catrepository.save(categoria));
    }

    @DeleteMapping("delete/{id}")
    public void deletar (@PathVariable long id)
    {
        catrepository.deleteById(id);
    }

}
