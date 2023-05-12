package com.example.admisionesb.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BcryptServicioImpl implements BcryptServicio {

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public BcryptServicioImpl(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encriptarClave(String clave) {
        return passwordEncoder.encode(clave);
    }

    @Override
    public boolean coincidencia(String textoPlano, String textoEncriptado) {
        return passwordEncoder.matches(textoPlano, textoEncriptado);
    }
}
