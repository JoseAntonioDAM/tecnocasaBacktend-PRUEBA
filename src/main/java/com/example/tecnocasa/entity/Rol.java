package com.example.tecnocasa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rol")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Rol {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_rol")
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "nombre", nullable = false, length = 30, unique = true)
  private RolNombre nombre;
}
