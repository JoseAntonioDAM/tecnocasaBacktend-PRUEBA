package com.example.tecnocasa.repository;

import com.example.tecnocasa.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
