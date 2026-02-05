package utilidades;
import excepciones.DniException;
import java.io.Serializable; // [Añadir esta línea]

public class Nif implements Serializable { // [Añadir implements Serializable]
    private static final long serialVersionUID = 1L; // [Recomendado]
    private static final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
    private String nif;

    public Nif(String n) {
        if (!validarNif(n)) {
            throw new DniException("NIF no válido");
        }
        this.nif = n.toUpperCase();
    }

    public static boolean validarNif(String nif) {
        if (nif == null || nif.length() != 9) return false;
        try {
            String numeros = nif.substring(0, 8);
            char letraPropuesta = nif.toUpperCase().charAt(8);
            int dniInt = Integer.parseInt(numeros);
            return letraPropuesta == LETRAS.charAt(dniInt % 23);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() { return nif; }
}