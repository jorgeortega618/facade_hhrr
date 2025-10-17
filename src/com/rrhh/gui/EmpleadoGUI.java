package com.rrhh.gui;

import com.rrhh.facade.EmpleadoFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interfaz gráfica para el sistema de gestión de empleados.
 * Demuestra el patrón Facade con una GUI simple usando Swing.
 */
public class EmpleadoGUI extends JFrame {
    private EmpleadoFacade empleadoFacade;
    private JTextArea areaTexto;
    private JButton btnRegistrar;
    private JButton btnLimpiar;

    public EmpleadoGUI() {
        empleadoFacade = new EmpleadoFacade();
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Configuración de la ventana principal
        setTitle("Sistema de Gestión de Empleados - Patrón Facade");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel superior con título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(41, 128, 185));
        JLabel lblTitulo = new JLabel("Sistema de Gestión de Empleados (RRHH)");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        // Área de texto para mostrar los mensajes
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Consolas", Font.PLAIN, 14));
        areaTexto.setMargin(new Insets(10, 10, 10, 10));
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        
        // Mensaje inicial
        areaTexto.setText("Bienvenido al Sistema de Gestión de Empleados\n" +
                         "==============================================\n\n" +
                         "Haga clic en 'Registrar Empleado' para iniciar\n" +
                         "el proceso de registro de un nuevo empleado.\n\n" +
                         "El sistema ejecutará automáticamente todos los\n" +
                         "pasos necesarios usando el patrón Facade.");

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        // Botón Registrar Empleado
        btnRegistrar = new JButton("Registrar Empleado");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnRegistrar.setBackground(new Color(46, 204, 113));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setPreferredSize(new Dimension(180, 40));
        btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEmpleado();
            }
        });

        // Botón Limpiar
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnLimpiar.setBackground(new Color(149, 165, 166));
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setPreferredSize(new Dimension(120, 40));
        btnLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarTexto();
            }
        });

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnLimpiar);
        add(panelBotones, BorderLayout.SOUTH);
    }

    /**
     * Ejecuta el proceso de registro de empleado usando el Facade
     */
    private void registrarEmpleado() {
        // Deshabilitar botón mientras se procesa
        btnRegistrar.setEnabled(false);
        btnRegistrar.setText("Procesando...");
        
        // Limpiar área de texto
        areaTexto.setText("");
        
        // Ejecutar el registro usando el Facade
        String resultado = empleadoFacade.registrarNuevoEmpleado();
        
        // Mostrar resultado
        areaTexto.setText(resultado);
        
        // Rehabilitar botón
        btnRegistrar.setEnabled(true);
        btnRegistrar.setText("Registrar Empleado");
        
        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(this,
                "Empleado registrado exitosamente",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Limpia el área de texto
     */
    private void limpiarTexto() {
        areaTexto.setText("Bienvenido al Sistema de Gestión de Empleados\n" +
                         "==============================================\n\n" +
                         "Haga clic en 'Registrar Empleado' para iniciar\n" +
                         "el proceso de registro de un nuevo empleado.\n\n" +
                         "El sistema ejecutará automáticamente todos los\n" +
                         "pasos necesarios usando el patrón Facade.");
    }

    /**
     * Método principal para lanzar la aplicación GUI
     */
    public static void main(String[] args) {
        // Usar el Look and Feel del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
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
