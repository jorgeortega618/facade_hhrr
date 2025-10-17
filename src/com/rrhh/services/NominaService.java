package com.rrhh.services;

import com.rrhh.model.Empleado;

public class NominaService {
    public String registrarEnNomina(Empleado empleado) {
        return "Empleado registrado en nómina con salario: $" + String.format("%.2f", empleado.getSalario());
    }
}
