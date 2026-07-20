package model;

public class Proveedor extends Persona {
    private String rubro;

    public Proveedor(String nombre, Rut rut, Direccion direccion, String rubro) {
        super(nombre, rut, direccion);
        this.rubro = rubro;
    }

    public String getRubro() { return rubro; }
    public void setRubro(String rubro) { this.rubro = rubro; }

    @Override
    public void mostrarDatos() {
        System.out.println("[PROVEEDOR] Empresa: " + nombre +
                " | RUT: " + rut +
                " | Rubro Comercial: " + rubro +
                " | Dirección Casa Matriz: " + direccion);
    }

    @Override
    public String toString() {
        return "Proveedor: " + nombre + " (" + rubro + ")";
    }
}