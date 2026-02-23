package com.example.tecnocasa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ubicacion")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Ubicacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_ubicacion")
  private Long idUbicacion;

  @Column(name = "direccion", nullable = false, length = 100)
  private String direccion;

  @Column(name = "ciudad", nullable = false, length = 80)
  private String ciudad;

  @Column(name = "pais", nullable = false, length = 80)
  private String pais;
}
