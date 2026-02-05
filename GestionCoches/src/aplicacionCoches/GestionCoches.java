package aplicacionCoches;

import control.Inventario;
import modelo.*;
import utilidades.*;
import java.util.Scanner;

public class GestionCoches {

    private static final Scanner sc = new Scanner(System.in);
    private static final Inventario inventario = Inventario.getInstancia();

    public static void main(String[] args) {
        // Cargar datos persistentes al arrancar
        inventario.cargarDatos();
        
        // Si el archivo estaba vacío, cargar datos de ejemplo
        if (inventario.getStock().isEmpty()) {
            precargarDatos();
        }

        int opcion = 0; 
        while (opcion != 4) {
            try {
                System.out.println("\n--- SGC-ENTERPRISE: SISTEMA DE GESTIÓN ---");
                System.out.println("1. Listar Stock (con precios depreciados)");
                System.out.println("2. Registrar nuevo vehículo");
                System.out.println("3. Simular Financiación");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> listarStock();
                    case 2 -> registrarVehiculo();
                    case 3 -> simularFinanciacion();
                    case 4 -> System.out.println("Saliendo del sistema...");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void precargarDatos() {
        inventario.registrar(new Turismo("Audi", "A3", "1234BBB", 28000, "12345678Z", 5, "2015-05-10"));
        inventario.registrar(new Industrial("Iveco", "Daily", "5678CCC", 35000, "12345678Z", 3500.0, "2023-01-01"));
        inventario.guardarDatos();
    }

    private static void listarStock() {
        if (inventario.getStock().isEmpty()) {
            System.out.println("No hay vehículos en el inventario.");
            return;
        }
        for (VehiculoBase v : inventario.getStock()) {
            System.out.printf("%s | Precio Actual: %.2f€\n", v.identificacion(), v.getPrecioActual());
        }
    }

    private static void simularFinanciacion() {
        System.out.print("Introduce matrícula: ");
        String m = sc.nextLine();
        VehiculoBase v = inventario.buscarPorMatricula(m);
        System.out.print("¿En cuántos meses? (12-72): ");
        int meses = Integer.parseInt(sc.nextLine());

        double cuota = Finanzas.calcularCuotaMensual(v.getPrecioActual(), meses);
        System.out.println("Resultado: " + meses + " cuotas de " + cuota + "€ (Interés 5% incl.)");
    }

    private static void registrarVehiculo() {
        try {
            System.out.println("\n--- REGISTRO DE NUEVO VEHÍCULO ---");
            System.out.print("Tipo (1. Turismo / 2. Industrial): ");
            int tipo = Integer.parseInt(sc.nextLine());
            
            System.out.print("Marca: "); String marca = sc.nextLine();
            System.out.print("Modelo: "); String modelo = sc.nextLine();
            System.out.print("Matrícula: "); String mat = sc.nextLine();
            System.out.print("Precio base: "); double precio = Double.parseDouble(sc.nextLine());
            System.out.print("DNI Propietario: "); String dni = sc.nextLine();
            System.out.print("Fecha Matriculación (YYYY-MM-DD): "); String fecha = sc.nextLine();

            if (tipo == 1) {
                System.out.print("Número de plazas: ");
                int plazas = Integer.parseInt(sc.nextLine());
                inventario.registrar(new Turismo(marca, modelo, mat, precio, dni, plazas, fecha));
            } else {
                System.out.print("Carga máxima (kg): ");
                double carga = Double.parseDouble(sc.nextLine());
                inventario.registrar(new Industrial(marca, modelo, mat, precio, dni, carga, fecha));
            }
            
            // Guardar cambios en el archivo tras el registro
            inventario.guardarDatos();
            System.out.println("Vehículo registrado y guardado correctamente.");
        } catch (Exception e) {
            System.out.println("Error en el registro: " + e.getMessage());
        }
    }
}