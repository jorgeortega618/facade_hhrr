package com.rrhh.services;

import com.rrhh.model.Empleado;

public class UsuarioService {
    public String crearUsuario(Empleado empleado) {
        return "Usuario creado: " + empleado.getNombreCompleto() + " (Cédula: " + empleado.getCedula() + ")";
    }
}
