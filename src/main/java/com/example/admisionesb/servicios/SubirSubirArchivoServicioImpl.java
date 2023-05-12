package com.example.admisionesb.servicios;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SubirSubirArchivoServicioImpl implements SubirArchivoServicio {

    //Carpeta raiz donde se guardan los archivos
    private final Path carpetaRaiz = Paths.get("archivos");

    @Override
    public void guardarArchivo(MultipartFile archivo) throws Exception {
        Files.copy(archivo.getInputStream(), this.carpetaRaiz.resolve(archivo.getOriginalFilename()));
    }
}
