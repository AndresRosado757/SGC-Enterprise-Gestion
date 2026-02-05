package control;

import java.io.*;
import java.util.ArrayList;
import modelo.VehiculoBase;
import excepciones.GestionException;

public class Inventario implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Inventario instancia;
    private ArrayList<VehiculoBase> stock = new ArrayList<>();
    private static final String ARCHIVO = "concesionario.dat";

    private Inventario() {}

    public static Inventario getInstancia() {
        if (instancia == null) {
            instancia = new Inventario();
        }
        return instancia;
    }

    public void registrar(VehiculoBase v) { 
        stock.add(v); 
    }

    public ArrayList<VehiculoBase> getStock() { 
        return stock; 
    }

    public VehiculoBase buscarPorMatricula(String mat) {
        for (VehiculoBase v : stock) {
            if (v.getMatricula().equalsIgnoreCase(mat)) {
                return v;
            }
        }
        throw new GestionException("Vehículo con matrícula " + mat + " no encontrado.");
    }

    public void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(stock);
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarDatos() {
        File f = new File(ARCHIVO);
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                stock = (ArrayList<VehiculoBase>) ois.readObject();
            } catch (Exception e) {
                System.out.println("Error al cargar datos: " + e.getMessage());
            }
        }
    }
}