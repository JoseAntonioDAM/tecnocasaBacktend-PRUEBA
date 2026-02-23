package com.example.tecnocasa.repository;

import com.example.tecnocasa.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  Optional<Usuario> findByCorreo(String correo);
  Optional<Usuario> findByDniNie(String dniNie);
}
