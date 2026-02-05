package modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import utilidades.Nif;

public abstract class VehiculoBase implements java.io.Serializable { 
    private static final long serialVersionUID = 1L;
    protected String marca, modelo, matricula;
    protected double precioBase;
    protected LocalDate fechaMatriculacion;
    protected Nif nifPropietario;

    public VehiculoBase(String marca, String modelo, String matricula, double precio, String nif, String fechaMat) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula.toUpperCase();
        this.precioBase = precio;
        this.nifPropietario = new Nif(nif);
        this.fechaMatriculacion = LocalDate.parse(fechaMat); // Formato YYYY-MM-DD
    }

    // Este es el método que le faltaba a tu error de la opción 1
    public double getPrecioActual() {
        long anios = ChronoUnit.YEARS.between(fechaMatriculacion, LocalDate.now());
        double precioDepreciado = precioBase - (precioBase * (anios * 0.05));
        return Math.max(precioDepreciado, precioBase * 0.1); // Mínimo 10% del valor base
    }

    // Este es el método que le faltaba a tu error en Inventario.java
    public double getPrecio() {
        return precioBase;
    }

    public abstract String identificacion();
    
    public String getMatricula() { 
        return matricula; 
    }
}