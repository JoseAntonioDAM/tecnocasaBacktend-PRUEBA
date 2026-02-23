package com.example.tecnocasa.dto;

import com.example.tecnocasa.entity.RolNombre;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class UsuarioCreateRequest {

  @NotBlank
  private String nombre;

  @NotBlank
  private String apellidos;

  @NotBlank
  private String dniNie;

  private String direccion;

  private Integer codigoPostal;

  private Integer telefono;

  @Email @NotBlank
  private String correo;

  @NotBlank
  private String contrasena;

  @NotNull
  private RolNombre rol;
}
