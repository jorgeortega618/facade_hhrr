package com.rrhh;

import com.rrhh.facade.EmpleadoFacade;
import com.rrhh.gui.EmpleadoGUI;

import javax.swing.*;

/**
 * Clase principal que demuestra el uso del patrón Facade
 * para la gestión de empleados en RRHH.
 * 
 * Uso:
 * - Sin argumentos: Lanza la interfaz gráfica (GUI)
 * - Con argumento "console": Ejecuta en modo consola
 */
public class Main {
    public static void main(String[] args) {
        // Si se pasa el argumento "console", ejecutar en modo consola
        if (args.length > 0 && args[0].equalsIgnoreCase("console")) {
            ejecutarModoConsola();
        } else {
            // Por defecto, lanzar la GUI
            ejecutarModoGUI();
        }
    }

    /**
     * Ejecuta la aplicación en modo consola
     */
    private static void ejecutarModoConsola() {
        System.out.println("=== Modo Consola ===\n");
        EmpleadoFacade empleadoFacade = new EmpleadoFacade();
        empleadoFacade.registrarNuevoEmpleadoConsola();
    }

    /**
     * Ejecuta la aplicación con interfaz gráfica
     */
    private static void ejecutarModoGUI() {
        // Usar el Look and Feel del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("No se pudo establecer el Look and Feel del sistema");
        }

        // Crear y mostrar la GUI en el Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                EmpleadoGUI gui = new EmpleadoGUI();
                gui.setVisible(true);
            }
        });
    }
}
