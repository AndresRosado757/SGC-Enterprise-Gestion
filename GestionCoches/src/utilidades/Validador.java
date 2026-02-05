package utilidades;

import excepciones.DniException; // Importación necesaria

public class Validador {
    public static boolean validarDocumento(String doc) {
        if (doc == null || doc.isEmpty()) return false;
        char inicio = doc.toUpperCase().charAt(0);
        // Si empieza por letra de NIE, usa el validador de NIE, sino el de NIF
        if ("XYZ".contains(String.valueOf(inicio))) {
            return Nie.validarNIE(doc);
        }
        return Nif.validarNif(doc);
    }
}