package com.example.admisionesb.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class cargarArchivoExcepcion {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<String> manejoTamanioMaxExcepcion(MaxUploadSizeExceededException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Verifica el tamaño del archivo");
    }
}
