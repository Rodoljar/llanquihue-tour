package model;

public class GuiaTuristico extends Persona {

    public GuiaTuristico(String nombre, String telefono) {
        super(nombre, telefono);
    }

    @Override
    public String toString() {
        return nombre + " (Tel: " + telefono + ")";
    }

    @Override
    public void mostrarResumen() {
        System.out.println("[ENTIDAD: GUÍA] Nombre: " + nombre + " | Contacto: " + telefono);
    }
}