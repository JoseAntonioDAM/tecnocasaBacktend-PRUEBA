package com.example.tecnocasa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "registro")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Registro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_registro")
  private Long idRegistro;

  @Column(name = "nombre", nullable = false, length = 100)
  private String nombre;

  /** Campo/propiedad registrada */
  @Column(name = "campo", nullable = false, length = 100)
  private String campo;

  /** Tipo del campo (en el diagrama aparece "Tipo") */
  @Column(name = "tipo", length = 60)
  private String tipo;

  @Column(name = "fecha")
  private LocalDate fecha;
}
