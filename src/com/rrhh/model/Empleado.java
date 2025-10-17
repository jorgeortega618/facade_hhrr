package com.rrhh.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un empleado en el sistema de RRHH
 */
public class Empleado {
    private String nombre;
    private String apellido;
    private String cedula;
    private String cargo;
    private double salario;
    private String correo;
    private String fechaRegistro;

    public Empleado(String nombre, String apellido, String cedula, String cargo, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.cargo = cargo;
        this.salario = salario;
        this.correo = generarCorreo();
        this.fechaRegistro = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private String generarCorreo() {
        return nombre.toLowerCase() + "." + apellido.toLowerCase() + "@empresa.com";
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return String.format("Empleado{nombre='%s', apellido='%s', cedula='%s', cargo='%s', salario=%.2f, correo='%s', fechaRegistro='%s'}",
                nombre, apellido, cedula, cargo, salario, correo, fechaRegistro);
    }

    /**
     * Formato para guardar en archivo CSV
     */
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%.2f,%s,%s",
                cedula, nombre, apellido, cargo, salario, correo, fechaRegistro);
    }
}
