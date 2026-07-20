package model;

public abstract class Persona implements Registrable {
    protected String nombre;
    protected Rut rut; // Composición
    protected Direccion direccion; // Composición

    public Persona(String nombre, Rut rut, Direccion direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Rut getRut() { return rut; }
    public void setRut(Rut rut) { this.rut = rut; }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    // Implementación obligatoria compartida de la interfaz Registrable
    @Override
    public void registrar() {
        System.out.println(">>> [SISTEMA] Registrando a " + nombre + " (RUT: " + rut + ") en la base de datos.");
    }
}