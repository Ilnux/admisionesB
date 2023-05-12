package com.example.admisionesb.controladores;

import com.example.admisionesb.modelos.PersonaModelo;
import com.example.admisionesb.servicios.PersonaServicioImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("usuario")
@AllArgsConstructor
public class PersonaControlador {
    private final PersonaServicioImpl personaServicioImpl;

    @PostMapping("/iniciar_sesion")
    public boolean iniciarSesion(@RequestBody PersonaModelo personaModelo) throws IOException {


        return personaServicioImpl.autenticacion(personaModelo);
    }

    @PostMapping("/crear_usuario")
    public PersonaModelo crearUsuario(@RequestBody PersonaModelo personaModelo) {

        return personaServicioImpl.guardarPersona(personaModelo);
    }
}
