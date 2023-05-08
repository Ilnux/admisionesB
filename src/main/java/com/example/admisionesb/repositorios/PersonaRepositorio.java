package com.example.admisionesb.repositorios;

import com.example.admisionesb.modelos.PersonaModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends JpaRepository<PersonaModelo, String> {
}
