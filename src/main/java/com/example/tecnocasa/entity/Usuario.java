package com.example.tecnocasa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_usuario")
  private Long id;

  @Column(name = "nombre", nullable = false, length = 100)
  private String nombre;

  @Column(name = "apellidos", nullable = false, length = 150)
  private String apellidos;

  @Column(name = "dni_nie", nullable = false, length = 20, unique = true)
  private String dniNie;

  @Column(name = "direccion", length = 255)
  private String direccion;

  @Column(name = "codigo_postal")
  private Integer codigoPostal;

  @Column(name = "telefono")
  private Integer telefono;

  @Column(name = "correo", nullable = false, length = 150, unique = true)
  private String correo;

  @Column(name = "contrasena", nullable = false, length = 255)
  private String contrasena;

  @ManyToOne(optional = false)
  @JoinColumn(name = "id_rol", nullable = false)
  private Rol rol;

  /**
   * Si el usuario es un agente, tendrá perfil de agente asociado.
   */
  @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
  private Agente agente;
}
