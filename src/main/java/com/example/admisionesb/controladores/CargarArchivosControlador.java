package com.example.admisionesb.controladores;

import com.example.admisionesb.servicios.CargarMasivaBdImpl;
import com.example.admisionesb.servicios.SubirSubirArchivoServicioImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("cargar_archivos")
@AllArgsConstructor
public class CargarArchivosControlador {

    SubirSubirArchivoServicioImpl archivoServicio;
    CargarMasivaBdImpl cargarMasivaBd;

    @PostMapping("/cargar_asp_inc_adm")
    public String cargarAspInsAdm(@RequestParam("file") MultipartFile archivo) throws Exception {

        archivoServicio.guardarArchivo(archivo);
        cargarMasivaBd.extraerDatosBasicos();

        return "Archivo Cargado";
    }

    @PostMapping("/actualizar_carga_db")
    public String cargarAspInsAdm() throws Exception {

        cargarMasivaBd.extraerDatosBasicos();

        return "bd actualizada";
    }
}
