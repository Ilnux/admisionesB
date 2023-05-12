package com.example.admisionesb.servicios;

public interface BcryptServicio {

    String encriptarClave(String texto);
    boolean coincidencia(String textoPlano, String textoEncriptado);
}
