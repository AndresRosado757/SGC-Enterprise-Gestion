package utilidades;

import excepciones.DniException;
import java.io.Serializable; // [Añadir esta línea]

public class Nie implements Serializable { // [Añadir implements Serializable]

    private static final long serialVersionUID = 1L; // [Recomendado]
    private static final String LETRAS_MAP = "XYZ";
    private String nie;

    // ... (el resto del código se mantiene igual)
    public Nie(String n) {
        if (!validarNIE(n)) {
            throw new DniException("NIE no válido");
        }
        this.nie = n.toUpperCase();
    }

    public static boolean validarNIE(String nie) {
        if (nie == null || nie.length() != 9) {
            return false;
        }
        String nieUpper = nie.toUpperCase();
        char primera = nieUpper.charAt(0);
        int prefijo = LETRAS_MAP.indexOf(primera);

        if (prefijo == -1) {
            return false;
        }

        try {
            // Reemplazamos letra inicial por su valor (0, 1 o 2) y validamos como NIF
            String numeroCompleto = prefijo + nieUpper.substring(1, 8);
            int num = Integer.parseInt(numeroCompleto);
            char letraCalculada = "TRWAGMYFPDXBNJZSQVHLCKE".charAt(num % 23);
            return nieUpper.charAt(8) == letraCalculada;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return nie;
    }
}
