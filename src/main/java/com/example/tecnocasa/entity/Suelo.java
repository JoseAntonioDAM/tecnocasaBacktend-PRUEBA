package com.example.tecnocasa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "suelo")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Suelo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_suelo")
  private Long idSuelo;

  @Column(name = "tipo_suelo", nullable = false, length = 50)
  private String tipoSuelo;
}
