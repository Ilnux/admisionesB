package com.example.admisionesb.servicios;

import com.example.admisionesb.modelos.PersonaModelo;
import com.example.admisionesb.repositorios.PersonaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonaServicioImpl implements PersonaServicio {

    private final BcryptServicioImpl encriptarClave;

    PersonaRepositorio personaRepositorio;

    BcryptServicioImpl bcryptServicioImpl;

    @Override
    public boolean autenticacion(PersonaModelo persona) {
        PersonaModelo datos;
        Optional<PersonaModelo> resultado = personaRepositorio.findById(persona.getNumero_documento());

        if (resultado.isPresent()) {
            datos = resultado.get();
        } else {
            return false;
        }
        return bcryptServicioImpl.coincidencia(persona.getClave(), datos.getClave());
    }

    @Override
    public PersonaModelo guardarPersona(PersonaModelo persona) {

        persona.setNombre_completo(persona.getNombre_completo().toUpperCase());
        persona.setClave(encriptarClave.encriptarClave(persona.getClave()));

        return personaRepositorio.save(persona);
    }
}
