package com.example.admisionesb.controladores;

import com.example.admisionesb.modelos.PersonaModelo;
import com.example.admisionesb.servicios.EncriptarClaveServicio;
import com.example.admisionesb.servicios.PersonaServicio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
@AllArgsConstructor
public class PersonaControlador {
    private final EncriptarClaveServicio encriptarClave;
    private final PersonaServicio personaServicio;

    @PostMapping("/iniciar_sesion")
    public boolean iniciarSesion(@RequestBody PersonaModelo personaModelo) {

        return personaServicio.servicioAutenticacion(personaModelo);
    }

    @PostMapping("/crear_usuario")
    public PersonaModelo crearUsuario(@RequestBody PersonaModelo personaModelo) {

        personaModelo.setClave(encriptarClave.encriptarClave(personaModelo.getClave()));

        return personaServicio.servicioGuardarPersona(personaModelo);
    }
}
