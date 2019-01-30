package com.daniel.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daniel.cursomc.domain.Categoria;
import com.daniel.cursomc.domain.Produto;

/*
 * so colocar a @Repository e extends JpaRepository<Categoria, Integer> onde integer é o id classe
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Produto obj "
			+ "INNER JOIN obj.categorias cat "
			+ "WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	/*
	 * este metodo findDistinctByNomeContainingAndCategoriasIn executa o mesmo select de cima.
	 * Mas como esta com o @Query ele sobreponhe o metodo.
	 * Se tiver o @Query ele sera o usado.  
	 * Metodo criado apenas usando o spring data que monta a consulta apenas com as algumas palavras especificas
	 */

	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(@Param("nome") String nome,
			@Param("categorias") List<Categoria> categorias, Pageable pageRequest);
}
