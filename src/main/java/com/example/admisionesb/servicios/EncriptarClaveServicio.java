package com.example.admisionesb.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncriptarClaveServicio {

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public EncriptarClaveServicio(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encriptarClave(String clave) {
        return passwordEncoder.encode(clave);
    }

    public boolean compararClave(String clave, String claveEncriptada) {
        return passwordEncoder.matches(clave, claveEncriptada);
    }
}
