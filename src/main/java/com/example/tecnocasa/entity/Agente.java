package com.example.tecnocasa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "agente")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Agente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_agente")
  private Long idAgente;

  @Column(name = "nombre", nullable = false, length = 50)
  private String nombre;

  @Column(name = "telefono")
  private Integer telefono;

  @Column(name = "email", length = 50)
  private String email;

  @OneToOne(optional = false)
  @JoinColumn(name = "id_usuario", nullable = false, unique = true)
  private Usuario usuario;
}
