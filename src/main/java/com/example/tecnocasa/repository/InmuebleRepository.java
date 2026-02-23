package com.example.tecnocasa.repository;

import com.example.tecnocasa.entity.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {
}
