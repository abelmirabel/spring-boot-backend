package com.daniel.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.cursomc.domain.Estado;

/*
 * so colocar a @Repository e extends JpaRepository<Categoria, Integer> onde integer é o id classe
 */

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
