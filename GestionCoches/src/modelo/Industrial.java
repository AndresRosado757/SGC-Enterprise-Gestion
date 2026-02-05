package modelo;

public class Industrial extends VehiculoBase {
    private double cargaMax;

    public Industrial(String marca, String modelo, String matricula, double precio, String nif, double cargaMax, String fechaMat) {
        super(marca, modelo, matricula, precio, nif, fechaMat);
        this.cargaMax = cargaMax;
    }

    @Override
    public String identificacion() {
        return "INDUSTRIAL: " + marca + " " + modelo + " (Carga: " + cargaMax + "kg) - Matrícula: " + matricula;
    }
}