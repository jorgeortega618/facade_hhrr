package com.rrhh.services;

import com.rrhh.model.Empleado;

public class PermisosService {
    public String asignarPermisos(Empleado empleado) {
        return "Permisos de acceso asignados para cargo: " + empleado.getCargo();
    }
}
