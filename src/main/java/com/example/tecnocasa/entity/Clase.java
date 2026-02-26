package com.example.tecnocasa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "clase")
@Data @AllArgsConstructor @Builder
public class Clase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_clase")
  private Long idClase;

  @Column(name = "fecha", nullable = false)
  private LocalDate fecha;

  @ManyToOne
  @JoinColumn(name = "id_cliente")
  private Usuario cliente;

  @ManyToOne
  @JoinColumn(name = "id_agente")
  private Agente agente;

  @ManyToOne
  @JoinColumn(name = "id_inmueble")
  private Inmueble inmueble;
}
