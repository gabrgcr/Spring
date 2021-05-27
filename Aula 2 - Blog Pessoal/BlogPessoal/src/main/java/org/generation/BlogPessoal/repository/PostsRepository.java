package org.generation.BlogPessoal.repository;

import java.util.List;
import org.generation.BlogPessoal.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Integer> {
	public List<Posts> findAllByTituloContainingIgnoreCase(String titulo);

}
