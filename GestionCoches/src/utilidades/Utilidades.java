package utilidades;

import java.time.LocalDate;

/**
 * Métodos de utilidad general. Reutiliza la lógica de redondeo de tus proyectos.
 */
public class Utilidades {

    /**
     * Redondea a dos decimales, esencial para precios y cuotas.
     */
    public static double redondear(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }

    /**
     * Formatea fechas a día/mes/año.
     */
    public static String muestraFecha(LocalDate f) {
        if (f == null) return "N/A";
        return f.getDayOfMonth() + "/" + f.getMonthValue() + "/" + f.getYear();
    }
}