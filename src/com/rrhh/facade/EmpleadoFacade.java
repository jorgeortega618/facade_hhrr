package com.rrhh.facade;

import com.rrhh.model.Empleado;
import com.rrhh.services.*;

/**
 * Facade que simplifica el proceso de registro de un nuevo empleado.
 * Coordina múltiples servicios de RRHH en una única interfaz simple.
 */
public class EmpleadoFacade {
    private UsuarioService usuarioService;
    private CorreoService correoService;
    private NominaService nominaService;
    private PermisosService permisosService;
    private BeneficiosService beneficiosService;
    private AlmacenamientoService almacenamientoService;

    public EmpleadoFacade() {
        this.usuarioService = new UsuarioService();
        this.correoService = new CorreoService();
        this.nominaService = new NominaService();
        this.permisosService = new PermisosService();
        this.beneficiosService = new BeneficiosService();
        this.almacenamientoService = new AlmacenamientoService();
    }

    /**
     * Registra un nuevo empleado con sus datos completos
     * @param empleado Objeto con los datos del empleado
     * @return String con todos los mensajes del proceso de registro
     */
    public String registrarNuevoEmpleado(Empleado empleado) {
        StringBuilder resultado = new StringBuilder();
        resultado.append("=== REGISTRO DE NUEVO EMPLEADO ===\n\n");
        resultado.append(usuarioService.crearUsuario(empleado)).append("\n");
        resultado.append(correoService.asignarCorreo(empleado)).append("\n");
        resultado.append(nominaService.registrarEnNomina(empleado)).append("\n");
        resultado.append(permisosService.asignarPermisos(empleado)).append("\n");
        resultado.append(beneficiosService.activarBeneficios(empleado)).append("\n");
        resultado.append(almacenamientoService.guardarEmpleado(empleado)).append("\n");
        resultado.append("\n=== REGISTRO COMPLETADO CON ÉXITO ===");
        return resultado.toString();
    }
    
    /**
     * Verifica si una cédula ya está registrada
     */
    public boolean existeCedula(String cedula) {
        return almacenamientoService.existeCedula(cedula);
    }
    
    /**
     * Obtiene el total de empleados registrados
     */
    public int getTotalEmpleados() {
        return almacenamientoService.contarEmpleados();
    }
}
