package com.example.admisionesb.servicios;

import com.example.admisionesb.modelos.PersonaModelo;

public interface PersonaServicio {
    boolean autenticacion(PersonaModelo persona);

    PersonaModelo guardarPersona(PersonaModelo persona);
}
