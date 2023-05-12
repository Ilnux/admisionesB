package com.example.admisionesb.servicios;

import com.example.admisionesb.modelos.PersonaModelo;

import java.io.IOException;
import java.util.ArrayList;

public interface ManejoDatosServicio {

    void extraerDatosBasicos() throws IOException;

    void guardarDatosBasicos( ArrayList<PersonaModelo> listaPersonas);
}
