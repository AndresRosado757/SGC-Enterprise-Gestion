package utilidades;

public class Finanzas {
    public static double calcularCuotaMensual(double precio, int meses) {
        if (meses <= 0) return 0;
        double totalConInteres = precio * 1.05; // 5% de interés fijo
        return Utilidades.redondear(totalConInteres / meses); // Redondeo a 2 decimales
    }
}