package com.example.tecnocasa.config;

import com.example.tecnocasa.entity.Rol;
import com.example.tecnocasa.entity.RolNombre;
import com.example.tecnocasa.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

  @Bean
  CommandLineRunner seedRoles(RolRepository rolRepository) {
    return args -> {
      for (RolNombre rn : RolNombre.values()) {
        rolRepository.findByNombre(rn).orElseGet(() -> rolRepository.save(Rol.builder().nombre(rn).build()));
      }
    };
  }
}
