package com.example.admisionesb.servicios;

import com.example.admisionesb.modelos.PersonaModelo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
@AllArgsConstructor
public class CargarMasivaBdImpl implements ManejoDatosServicio {

    private final PersonaServicioImpl personaServicioImpl;

    @Override
    public void extraerDatosBasicos() {

        String ruta = "archivos/inscripcion.txt";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<String> listaSinDepurar;
        List<String[]> listaDepurada = new ArrayList<>();
        ArrayList<PersonaModelo> listaPersonas = new ArrayList<>();

        try {
            fileReader = new FileReader(ruta);
            bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder("");
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                stringBuilder.append(linea).append("\n");
            }

            listaSinDepurar = List.of(stringBuilder.toString().split("\n"));

            //se depura el archivo
            for (int i = 4; i < listaSinDepurar.size(); i++) {
                listaDepurada.add(listaSinDepurar.get(i).split("\\|"));
            }

            //pasamos la info plana a modelo
            for (String[] listaActual : listaDepurada) {
                PersonaModelo personaModelo = new PersonaModelo();


                personaModelo.setNumero_documento(listaActual[1]);
                personaModelo.setTipo_documento(listaActual[0]);
                personaModelo.setNombre_completo(listaActual[2] + " " + listaActual[3]);
                personaModelo.setCorreo(listaActual[25]);
                personaModelo.setTelefono_fijo(listaActual[30]);
                personaModelo.setTelefono_movil(listaActual[29]);
                personaModelo.setClave(listaActual[1]);
                personaModelo.setFk_rol("1");

                listaPersonas.add(personaModelo);
            }

            guardarDatosBasicos(listaPersonas);


        } catch (IOException e) {
            System.out.println("Problema al leer el archivo" + e.getMessage());
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("Problema cerrando el archivo" + e.getMessage());
            }
        }

    }

    @Override
    public void guardarDatosBasicos(ArrayList<PersonaModelo> listaPersonas) {

        for (PersonaModelo persona : listaPersonas) {
            System.out.println(persona.getNumero_documento());
            personaServicioImpl.guardarPersona(persona);
        }


    }
}