package com.example.tecnocasa.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class InmuebleCreateRequest {

  @NotBlank
  private String tipo;

  @NotNull
  private BigDecimal area;

  private String estado;

  @NotBlank
  private String direccion;

  @NotBlank
  private String ciudad;

  @NotBlank
  private String pais;

 
  private String tipoSuelo;

  @NotBlank
  private String moneda;

  @NotNull
  private BigDecimal monto;
}
