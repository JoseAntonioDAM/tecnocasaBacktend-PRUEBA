package com.example.tecnocasa.repository;

import com.example.tecnocasa.entity.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
}
