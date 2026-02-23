package com.example.tecnocasa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "factura")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Factura {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_factura")
  private Long idFactura;

  @Column(name = "numero", nullable = false, length = 200, unique = true)
  private String numero;

  @Column(name = "fecha", nullable = false)
  private LocalDate fecha;

  @Column(name = "total", nullable = false, precision = 10, scale = 2)
  private BigDecimal total;

  @ManyToOne(optional = false)
  @JoinColumn(name = "id_inmueble", nullable = false)
  private Inmueble inmueble;

  @ManyToOne
  @JoinColumn(name = "id_cliente")
  private Usuario cliente;
}
