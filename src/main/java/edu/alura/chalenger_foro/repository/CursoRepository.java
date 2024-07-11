package edu.alura.chalenger_foro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.alura.chalenger_foro.models.curso.Curso;

public interface CursoRepository extends JpaRepository<Curso,Long>{

}
