package com.example.admisionesb.servicios;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface SubirArchivoServicio {
    void guardarArchivo(MultipartFile file) throws Exception;

}
