package com.example.tecnocasa.controller;

import com.example.tecnocasa.dto.UsuarioCreateRequest;
import com.example.tecnocasa.entity.Rol;
import com.example.tecnocasa.entity.Usuario;
import com.example.tecnocasa.repository.RolRepository;
import com.example.tecnocasa.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

  private final UsuarioRepository usuarioRepository;
  private final RolRepository rolRepository;

  public UsuarioController(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
    this.usuarioRepository = usuarioRepository;
    this.rolRepository = rolRepository;
  }

  @GetMapping
  public List<Usuario> list() {
    return usuarioRepository.findAll();
  }

  @GetMapping("/{id}")
  public Usuario get(@PathVariable Long id) {
    return usuarioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Usuario create(@Valid @RequestBody UsuarioCreateRequest req) {
    if (usuarioRepository.findByCorreo(req.getCorreo()).isPresent()) {
      throw new IllegalArgumentException("Ya existe un usuario con ese correo");
    }
    if (usuarioRepository.findByDniNie(req.getDniNie()).isPresent()) {
      throw new IllegalArgumentException("Ya existe un usuario con ese DNI/NIE");
    }

    Rol rol = rolRepository.findByNombre(req.getRol())
        .orElseThrow(() -> new IllegalArgumentException("Rol no válido"));

    Usuario u = Usuario.builder()
        .nombre(req.getNombre())
        .apellidos(req.getApellidos())
        .dniNie(req.getDniNie())
        .direccion(req.getDireccion())
        .codigoPostal(req.getCodigoPostal())
        .telefono(req.getTelefono())
        .correo(req.getCorreo())
        .contrasena(req.getContrasena())
        .rol(rol)
        .build();

    return usuarioRepository.save(u);
  }
}
