package com.lggames.LG_Games.repository;

import com.lggames.LG_Games.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    public Set<Categoria> findAllByNomeContainingIgnoreCase(String nome);

}
