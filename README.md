# Sistema de Gestión de Empleados - Patrón Facade

## 📋 Descripción
Aplicación Java que demuestra el uso del **patrón de diseño Facade** para simplificar el proceso de registro de nuevos empleados en un sistema de RRHH.

La aplicación incluye:
- 🖥️ **Interfaz Gráfica (GUI)** con Swing
- 💻 **Modo Consola** para ejecución en terminal

## 🏗️ Estructura del Proyecto

```
facade_nomina/
├── src/
│   └── com/
│       └── rrhh/
│           ├── Main.java                    # Punto de entrada de la aplicación
│           ├── facade/
│           │   └── EmpleadoFacade.java      # Facade que coordina todos los servicios
│           ├── gui/
│           │   └── EmpleadoGUI.java         # Interfaz gráfica con Swing
│           └── services/
│               ├── UsuarioService.java      # Servicio de creación de usuarios
│               ├── CorreoService.java       # Servicio de correo corporativo
│               ├── NominaService.java       # Servicio de registro en nómina
│               ├── PermisosService.java     # Servicio de permisos de acceso
│               └── BeneficiosService.java   # Servicio de beneficios
├── bin/                                      # Clases compiladas
├── compilar.bat                              # Script de compilación
├── ejecutar.bat                              # Ejecutar en modo consola
├── ejecutar_gui.bat                          # Ejecutar con interfaz gráfica
└── README.md
```

## 🎯 Patrón Facade

El patrón Facade proporciona una interfaz unificada para un conjunto de interfaces en un subsistema. Define una interfaz de nivel superior que hace que el subsistema sea más fácil de usar.

### Ventajas:
- ✅ Simplifica la interacción con sistemas complejos
- ✅ Reduce el acoplamiento entre el cliente y los subsistemas
- ✅ Facilita el mantenimiento y la evolución del código
- ✅ Proporciona un punto de entrada único y claro

## 🚀 Compilación y Ejecución

### Opción 1: Usar los scripts (Recomendado)

**Compilar:**
```bash
compilar.bat
```

**Ejecutar con interfaz gráfica (GUI):**
```bash
ejecutar_gui.bat
```

**Ejecutar en modo consola:**
```bash
ejecutar.bat
```

### Opción 2: Comandos manuales

**Compilar:**
```bash
javac -d bin -sourcepath src src\com\rrhh\Main.java
```

**Ejecutar con GUI:**
```bash
java -cp bin com.rrhh.Main
```

**Ejecutar en consola:**
```bash
java -cp bin com.rrhh.Main console
```

## 🖥️ Interfaz Gráfica

La aplicación incluye una interfaz gráfica moderna con Swing que ofrece:

- **Botón "Registrar Empleado"**: Ejecuta el proceso completo de registro
- **Área de texto**: Muestra los mensajes del proceso en tiempo real
- **Botón "Limpiar"**: Limpia el área de texto
- **Diseño moderno**: Colores profesionales y diseño intuitivo
- **Diálogo de confirmación**: Notifica cuando el registro se completa exitosamente

## 📤 Salida Esperada

### Modo Consola:
```
--- Registro de nuevo empleado ---
Usuario creado correctamente.
Correo corporativo asignado.
Empleado registrado en nómina.
Permisos de acceso asignados.
Beneficios activados.
--- Registro completado con éxito ---
```

### Modo GUI:
Los mensajes se muestran en un área de texto dentro de la ventana gráfica, con un diálogo de confirmación al finalizar.

## 📚 Conceptos Aplicados

- **Patrón Facade**: Simplifica la interacción con múltiples subsistemas
- **Separación de responsabilidades**: Cada servicio tiene una única responsabilidad
- **Encapsulación**: La complejidad de múltiples servicios se oculta detrás del Facade
- **Paquetes Java**: Organización lógica del código en paquetes (`com.rrhh.facade`, `com.rrhh.services`, `com.rrhh.gui`)
- **Swing GUI**: Interfaz gráfica con componentes Java Swing
- **Event-Driven Programming**: Manejo de eventos con ActionListeners
- **Javadoc**: Documentación clara de clases y métodos

## 👨‍💻 Autor
Proyecto educativo para demostrar el patrón Facade en Java
