package com.farmacia.farma.repository;

import com.farmacia.farma.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    public Set<Categoria> findAllByNomeContainingIgnoreCase(String nome);
}
