package excepciones;


public class DniException extends RuntimeException {
    public DniException(String mensaje) {
        super(mensaje);
    }
}