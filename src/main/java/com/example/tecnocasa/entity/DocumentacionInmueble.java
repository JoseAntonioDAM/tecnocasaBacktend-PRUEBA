package com.example.tecnocasa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "documentacion_inmueble")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DocumentacionInmueble {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_doc")
  private Long idDoc;

  @Column(name = "tipo", nullable = false, length = 100)
  private String tipo;

  @Column(name = "archivo", nullable = false, length = 255)
  private String archivo;

  @Column(name = "fecha", nullable = false)
  private LocalDate fecha;

  @ManyToOne(optional = false)
  @JoinColumn(name = "id_inmueble", nullable = false)
  private Inmueble inmueble;
}
