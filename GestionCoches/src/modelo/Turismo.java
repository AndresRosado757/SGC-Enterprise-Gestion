package modelo;

public class Turismo extends VehiculoBase {
    private int numPlazas;

    public Turismo(String marca, String modelo, String matricula, double precio, String nif, int numPlazas, String fechaMat) {
        super(marca, modelo, matricula, precio, nif, fechaMat);
        this.numPlazas = numPlazas;
    }

    @Override
    public String identificacion() {
        return "TURISMO: " + marca + " " + modelo + " (" + numPlazas + " plazas) - Matrícula: " + matricula;
    }
}