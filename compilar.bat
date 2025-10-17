@echo off
echo Compilando proyecto...
javac -d bin -sourcepath src src\com\rrhh\Main.java
if %errorlevel% equ 0 (
    echo Compilacion exitosa!
) else (
    echo Error en la compilacion.
    exit /b 1
)
