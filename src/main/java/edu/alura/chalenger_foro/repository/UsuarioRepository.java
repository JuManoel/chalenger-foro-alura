package edu.alura.chalenger_foro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.alura.chalenger_foro.models.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

    Optional<Usuario> findByEmail(String email);

}
