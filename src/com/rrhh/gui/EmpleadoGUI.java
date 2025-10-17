package com.rrhh.gui;

import com.rrhh.facade.EmpleadoFacade;
import com.rrhh.model.Empleado;

import javax.swing.*;
import java.awt.*;

/**
 * Interfaz gráfica para el sistema de gestión de empleados con formulario de entrada.
 */
public class EmpleadoGUI extends JFrame {
    private EmpleadoFacade empleadoFacade;
    
    // Campos de entrada
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCedula;
    private JTextField txtCargo;
    private JTextField txtSalario;
    
    // Área de resultados
    private JTextArea areaTexto;
    
    // Botones
    private JButton btnRegistrar;
    private JButton btnLimpiar;
    
    // Label de estadísticas
    private JLabel lblEstadisticas;

    public EmpleadoGUI() {
        empleadoFacade = new EmpleadoFacade();
        inicializarComponentes();
        actualizarEstadisticas();
    }

    private void inicializarComponentes() {
        setTitle("Sistema de Gestión de Empleados - Patrón Facade");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel superior
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(new Color(41, 128, 185));
        
        JLabel lblTitulo = new JLabel("Sistema de Gestión de Empleados (RRHH)", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        
        lblEstadisticas = new JLabel("Empleados registrados: 0", SwingConstants.CENTER);
        lblEstadisticas.setFont(new Font("Arial", Font.PLAIN, 12));
        lblEstadisticas.setForeground(Color.WHITE);
        lblEstadisticas.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        
        panelSuperior.add(lblTitulo, BorderLayout.NORTH);
        panelSuperior.add(lblEstadisticas, BorderLayout.SOUTH);
        add(panelSuperior, BorderLayout.NORTH);
        
        // Panel central
        JPanel panelCentral = new JPanel(new GridLayout(1, 2, 10, 0));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        panelCentral.add(crearPanelFormulario());
        panelCentral.add(crearPanelResultados());
        
        add(panelCentral, BorderLayout.CENTER);
        
        // Panel de botones
        add(crearPanelBotones(), BorderLayout.SOUTH);
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(41, 128, 185), 2),
            "Datos del Empleado",
            0, 0, new Font("Arial", Font.BOLD, 14), new Color(41, 128, 185)));

        // Nombre
        panel.add(crearCampo("Nombre:", txtNombre = new JTextField(20)));
        panel.add(Box.createVerticalStrut(10));
        
        // Apellido
        panel.add(crearCampo("Apellido:", txtApellido = new JTextField(20)));
        panel.add(Box.createVerticalStrut(10));
        
        // Cédula
        panel.add(crearCampo("Cédula:", txtCedula = new JTextField(20)));
        panel.add(Box.createVerticalStrut(10));
        
        // Cargo
        panel.add(crearCampo("Cargo:", txtCargo = new JTextField(20)));
        panel.add(Box.createVerticalStrut(10));
        
        // Salario
        panel.add(crearCampo("Salario:", txtSalario = new JTextField(20)));
        panel.add(Box.createVerticalStrut(10));
        
        // Información
        JLabel lblInfo = new JLabel("<html><i>Complete todos los campos para registrar un empleado</i></html>");
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 11));
        lblInfo.setForeground(Color.GRAY);
        lblInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblInfo);
        
        return panel;
    }

    private JPanel crearCampo(String etiqueta, JTextField campo) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setMaximumSize(new Dimension(400, 60));
        
        JLabel label = new JLabel(etiqueta);
        label.setFont(new Font("Arial", Font.BOLD, 13));
        label.setPreferredSize(new Dimension(80, 25));
        
        campo.setFont(new Font("Arial", Font.PLAIN, 13));
        campo.setPreferredSize(new Dimension(200, 30));
        
        panel.add(label, BorderLayout.WEST);
        panel.add(campo, BorderLayout.CENTER);
        
        return panel;
    }

    private JPanel crearPanelResultados() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(46, 204, 113), 2),
            "Resultado del Registro",
            0, 0, new Font("Arial", Font.BOLD, 14), new Color(46, 204, 113)));

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Consolas", Font.PLAIN, 12));
        areaTexto.setMargin(new Insets(10, 10, 10, 10));
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setText("Esperando registro de empleado...\n\n" +
                         "Complete el formulario y haga clic en 'Registrar Empleado'.");

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        btnRegistrar = new JButton("Registrar Empleado");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnRegistrar.setBackground(new Color(46, 204, 113));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setOpaque(true);
        btnRegistrar.setPreferredSize(new Dimension(180, 40));
        btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(e -> registrarEmpleado());

        btnLimpiar = new JButton("Limpiar Formulario");
        btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnLimpiar.setBackground(new Color(149, 165, 166));
        btnLimpiar.setForeground(Color.WHITE);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setOpaque(true);
        btnLimpiar.setPreferredSize(new Dimension(180, 40));
        btnLimpiar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLimpiar.addActionListener(e -> limpiarFormulario());

        panel.add(btnRegistrar);
        panel.add(btnLimpiar);
        
        return panel;
    }

    private void registrarEmpleado() {
        // Validar campos
        if (!validarCampos()) {
            return;
        }

        // Verificar si la cédula ya existe
        String cedula = txtCedula.getText().trim();
        if (empleadoFacade.existeCedula(cedula)) {
            JOptionPane.showMessageDialog(this,
                    "La cédula " + cedula + " ya está registrada en el sistema.",
                    "Cédula Duplicada",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Crear objeto Empleado
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String cargo = txtCargo.getText().trim();
            double salario = Double.parseDouble(txtSalario.getText().trim());

            Empleado empleado = new Empleado(nombre, apellido, cedula, cargo, salario);

            // Registrar usando el Facade
            btnRegistrar.setEnabled(false);
            btnRegistrar.setText("Procesando...");

            String resultado = empleadoFacade.registrarNuevoEmpleado(empleado);
            areaTexto.setText(resultado);

            btnRegistrar.setEnabled(true);
            btnRegistrar.setText("Registrar Empleado");

            // Actualizar estadísticas
            actualizarEstadisticas();

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this,
                    "Empleado " + empleado.getNombreCompleto() + " registrado exitosamente",
                    "Registro Exitoso",
                    JOptionPane.INFORMATION_MESSAGE);

            // Limpiar formulario
            limpiarFormulario();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "El salario debe ser un número válido",
                    "Error de Formato",
                    JOptionPane.ERROR_MESSAGE);
            btnRegistrar.setEnabled(true);
            btnRegistrar.setText("Registrar Empleado");
        }
    }

    private boolean validarCampos() {
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre es obligatorio", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
            txtNombre.requestFocus();
            return false;
        }
        if (txtApellido.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El apellido es obligatorio", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
            txtApellido.requestFocus();
            return false;
        }
        if (txtCedula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La cédula es obligatoria", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
            txtCedula.requestFocus();
            return false;
        }
        if (txtCargo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El cargo es obligatorio", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
            txtCargo.requestFocus();
            return false;
        }
        if (txtSalario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El salario es obligatorio", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
            txtSalario.requestFocus();
            return false;
        }
        return true;
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtCargo.setText("");
        txtSalario.setText("");
        areaTexto.setText("Esperando registro de empleado...\n\n" +
                         "Complete el formulario y haga clic en 'Registrar Empleado'.");
        txtNombre.requestFocus();
    }

    private void actualizarEstadisticas() {
        int total = empleadoFacade.getTotalEmpleados();
        lblEstadisticas.setText("Empleados registrados: " + total);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            EmpleadoGUI gui = new EmpleadoGUI();
            gui.setVisible(true);
        });
    }
}
