package com.rrhh.facade;

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

    public EmpleadoFacade() {
        this.usuarioService = new UsuarioService();
        this.correoService = new CorreoService();
        this.nominaService = new NominaService();
        this.permisosService = new PermisosService();
        this.beneficiosService = new BeneficiosService();
    }

    /**
     * Registra un nuevo empleado ejecutando todos los pasos necesarios
     * en el orden correcto.
     * @return String con todos los mensajes del proceso de registro
     */
    public String registrarNuevoEmpleado() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("--- Registro de nuevo empleado ---\n");
        resultado.append(usuarioService.crearUsuario()).append("\n");
        resultado.append(correoService.asignarCorreo()).append("\n");
        resultado.append(nominaService.registrarEnNomina()).append("\n");
        resultado.append(permisosService.asignarPermisos()).append("\n");
        resultado.append(beneficiosService.activarBeneficios()).append("\n");
        resultado.append("--- Registro completado con éxito ---");
        return resultado.toString();
    }
    
    /**
     * Versión del método que imprime en consola (para compatibilidad con versión CLI)
     */
    public void registrarNuevoEmpleadoConsola() {
        System.out.println(registrarNuevoEmpleado());
    }
}
