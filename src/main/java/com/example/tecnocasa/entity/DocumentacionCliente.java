package com.example.tecnocasa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "documentacion_cliente")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DocumentacionCliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_doc")
  private Long idDoc;

  @Column(name = "tipo", nullable = false, length = 50)
  private String tipo;

  @Column(name = "archivo", nullable = false, length = 255)
  private String archivo;

  @Column(name = "fecha", nullable = false)
  private LocalDate fecha;

  @ManyToOne(optional = false)
  @JoinColumn(name = "id_usuario", nullable = false)
  private Usuario usuario;
}
