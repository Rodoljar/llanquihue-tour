package model;

public class GuiaTuristico {
    private String nombre;
    private String telefono;

    // Constructor
    public GuiaTuristico(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        // Formato limpio para incluir en los servicios
        return nombre + " (Tel: " + telefono + ")";
    }
}
