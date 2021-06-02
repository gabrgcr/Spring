package com.lggames.LG_Games.repository;

import com.lggames.LG_Games.model.Categoria;
import com.lggames.LG_Games.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    public List<Jogo> findAllByNomeContainingIgnoreCase(String nome);
}
