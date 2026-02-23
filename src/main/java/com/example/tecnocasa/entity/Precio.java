package com.example.tecnocasa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "precio")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Precio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_precio")
  private Long idPrecio;

  @Column(name = "moneda", nullable = false, length = 10)
  private String moneda;

  @Column(name = "monto", nullable = false, precision = 10, scale = 2)
  private BigDecimal monto;
}
