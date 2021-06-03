package com.farmacia.farma.controller;

import com.farmacia.farma.model.Produto;
import com.farmacia.farma.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository prepository;

    @GetMapping("all/")
    public ResponseEntity<List<Produto>> GetAll()
    {
        return ResponseEntity.status(200).body(prepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> GetById(@PathVariable long id)
    {
        return prepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{nome}}")
    public ResponseEntity<List<Produto>> GetByTitulo (@PathVariable String nome)
    {
        return ResponseEntity.ok(prepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping("new")
    public ResponseEntity<Produto> postar (@RequestBody Produto prod)
    {
        return ResponseEntity.status(201).body(prepository.save(prod));
    }

    @PutMapping("edit")
    public ResponseEntity<Produto> editar (@RequestBody Produto prod)
    {
        return ResponseEntity.status(200).body(prepository.save(prod));
    }

    @DeleteMapping("/{id}/deletar/")
    public void deletar (@PathVariable long id)
    {
        prepository.deleteById(id);
    }
}
