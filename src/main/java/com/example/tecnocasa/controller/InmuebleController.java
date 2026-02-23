package com.example.tecnocasa.controller;

import com.example.tecnocasa.dto.InmuebleCreateRequest;
import com.example.tecnocasa.entity.*;
import com.example.tecnocasa.repository.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inmuebles")
public class InmuebleController {

  private final InmuebleRepository inmuebleRepository;
  private final UbicacionRepository ubicacionRepository;
  private final SueloRepository sueloRepository;

  public InmuebleController(InmuebleRepository inmuebleRepository,
                            UbicacionRepository ubicacionRepository,
                            SueloRepository sueloRepository) {
    this.inmuebleRepository = inmuebleRepository;
    this.ubicacionRepository = ubicacionRepository;
    this.sueloRepository = sueloRepository;
  }

  @GetMapping
  public List<Inmueble> list() {
    return inmuebleRepository.findAll();
  }

  @GetMapping("/{id}")
  public Inmueble get(@PathVariable Long id) {
    return inmuebleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Inmueble no encontrado"));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Inmueble create(@Valid @RequestBody InmuebleCreateRequest req) {

    Ubicacion ubicacion = ubicacionRepository.save(
        Ubicacion.builder()
            .direccion(req.getDireccion())
            .ciudad(req.getCiudad())
            .pais(req.getPais())
            .build()
    );

    Suelo suelo = null;
    if (req.getTipoSuelo() != null && !req.getTipoSuelo().isBlank()) {
      suelo = sueloRepository.save(Suelo.builder().tipoSuelo(req.getTipoSuelo()).build());
    }

    Precio precio = Precio.builder()
        .moneda(req.getMoneda())
        .monto(req.getMonto())
        .build();

    Inmueble inmueble = Inmueble.builder()
        .tipo(req.getTipo())
        .area(req.getArea())
        .estado(req.getEstado())
        .ubicacion(ubicacion)
        .suelo(suelo)
        .precio(precio)
        .build();

    return inmuebleRepository.save(inmueble);
  }
}
