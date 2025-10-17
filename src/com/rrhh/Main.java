package com.rrhh;

import com.rrhh.gui.EmpleadoGUI;

import javax.swing.*;

/**
 * Clase principal que demuestra el uso del patrón Facade
 * para la gestión de empleados en RRHH.
 * 
 * Lanza la interfaz gráfica con formulario de entrada de datos.
 */
public class Main {
    public static void main(String[] args) {
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
