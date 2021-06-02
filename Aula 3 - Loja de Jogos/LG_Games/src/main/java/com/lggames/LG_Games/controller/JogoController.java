package com.lggames.LG_Games.controller;

import com.lggames.LG_Games.model.Jogo;
import com.lggames.LG_Games.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jogos")
@CrossOrigin("*")
public class JogoController {

    @Autowired
    private JogoRepository jrepository;

    @GetMapping("all/")
    public ResponseEntity<List<Jogo>> GetAll()
    {
        return ResponseEntity.status(200).body(jrepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> GetById(@PathVariable long id)
    {
        return jrepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{nome}}")
    public ResponseEntity<List<Jogo>> GetByTitulo (@PathVariable String nome)
    {
        return ResponseEntity.ok(jrepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping("new")
    public ResponseEntity<Jogo> postar (@RequestBody Jogo joguinho)
    {
        return ResponseEntity.status(201).body(jrepository.save(joguinho));
    }

    @PutMapping("edit")
    public ResponseEntity<Jogo> editar (@RequestBody Jogo joguinho)
    {
        return ResponseEntity.status(200).body(jrepository.save(joguinho));
    }

    @DeleteMapping("/{id}/deletar/")
    public void deletar (@PathVariable long id)
    {
        jrepository.deleteById(id);
    }
}
