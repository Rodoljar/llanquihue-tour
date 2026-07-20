package model;

public class Empleado extends Persona {
    private String cargo;
    private int sueldoBase;

    public Empleado(String nombre, Rut rut, Direccion direccion, String cargo, int sueldoBase) {
        super(nombre, rut, direccion);
        this.cargo = cargo;
        this.sueldoBase = sueldoBase;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public int getSueldoBase() { return sueldoBase; }
    public void setSueldoBase(int sueldoBase) { this.sueldoBase = sueldoBase; }

    @Override
    public void mostrarDatos() {
        System.out.println("[EMPLEADO] Nombre: " + nombre +
                " | RUT: " + rut +
                " | Cargo: " + cargo +
                " | Sueldo Base: $" + sueldoBase);
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + " - Cargo: " + cargo;
    }
}