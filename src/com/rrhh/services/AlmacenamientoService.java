package com.rrhh.services;

import com.rrhh.model.Empleado;

import java.io.*;
import java.nio.file.*;

/**
 * Servicio para guardar y recuperar empleados en archivo
 */
public class AlmacenamientoService {
    private static final String ARCHIVO_EMPLEADOS = "empleados.txt";
    private static final String CARPETA_DATOS = "datos";

    public AlmacenamientoService() {
        inicializarArchivo();
    }

    /**
     * Crea la carpeta y archivo si no existen
     */
    private void inicializarArchivo() {
        try {
            Path carpeta = Paths.get(CARPETA_DATOS);
            if (!Files.exists(carpeta)) {
                Files.createDirectory(carpeta);
            }

            Path archivo = Paths.get(CARPETA_DATOS, ARCHIVO_EMPLEADOS);
            if (!Files.exists(archivo)) {
                Files.createFile(archivo);
                // Escribir encabezado
                escribirEncabezado();
            }
        } catch (IOException e) {
            System.err.println("Error al inicializar archivo: " + e.getMessage());
        }
    }

    /**
     * Escribe el encabezado del archivo CSV
     */
    private void escribirEncabezado() {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(CARPETA_DATOS + File.separator + ARCHIVO_EMPLEADOS))) {
            writer.write("CEDULA,NOMBRE,APELLIDO,CARGO,SALARIO,CORREO,FECHA_REGISTRO");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir encabezado: " + e.getMessage());
        }
    }

    /**
     * Guarda un empleado en el archivo
     */
    public String guardarEmpleado(Empleado empleado) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(CARPETA_DATOS + File.separator + ARCHIVO_EMPLEADOS, true))) {
            writer.write(empleado.toCSV());
            writer.newLine();
            return "Empleado guardado en base de datos.";
        } catch (IOException e) {
            return "Error al guardar empleado: " + e.getMessage();
        }
    }

    /**
     * Verifica si una cédula ya existe
     */
    public boolean existeCedula(String cedula) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(CARPETA_DATOS + File.separator + ARCHIVO_EMPLEADOS))) {
            String linea;
            reader.readLine(); // Saltar encabezado
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length > 0 && datos[0].equals(cedula)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al verificar cédula: " + e.getMessage());
        }
        return false;
    }

    /**
     * Obtiene el número total de empleados registrados
     */
    public int contarEmpleados() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(
                new FileReader(CARPETA_DATOS + File.separator + ARCHIVO_EMPLEADOS))) {
            reader.readLine(); // Saltar encabezado
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.err.println("Error al contar empleados: " + e.getMessage());
        }
        return count;
    }
}
