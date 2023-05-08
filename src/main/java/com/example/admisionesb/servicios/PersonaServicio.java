package com.example.admisionesb.servicios;

import com.example.admisionesb.modelos.PersonaModelo;
import com.example.admisionesb.repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaServicio {

    @Autowired
    PersonaRepositorio personaRepositorio;

    @Autowired
    EncriptarClaveServicio encriptarClaveServicio;

    public boolean servicioAutenticacion(PersonaModelo personaModelo) {
        PersonaModelo datos;
        Optional<PersonaModelo> resultado = personaRepositorio.findById(personaModelo.getNumero_documento());

        if (resultado.isPresent()) {
            datos = resultado.get();
        } else {
            return false;
        }
        return encriptarClaveServicio.compararClave(personaModelo.getClave(), datos.getClave());
    }

    public PersonaModelo servicioGuardarPersona(PersonaModelo persona) {
        System.out.println(persona);
        return personaRepositorio.save(persona);
    }

}
