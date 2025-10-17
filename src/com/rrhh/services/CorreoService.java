package com.rrhh.services;

import com.rrhh.model.Empleado;

public class CorreoService {
    public String asignarCorreo(Empleado empleado) {
        return "Correo corporativo asignado: " + empleado.getCorreo();
    }
}
