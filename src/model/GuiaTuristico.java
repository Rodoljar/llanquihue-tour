package model;

public class GuiaTuristico extends Persona {
    private String tourAsignado;
    private String vehiculoAsignado;

    public GuiaTuristico(String nombre, String telefono, String tourAsignado, String vehiculoAsignado) {
        super(nombre, telefono);
        this.tourAsignado = tourAsignado;
        this.vehiculoAsignado = vehiculoAsignado;
    }

    public String getTourAsignado() {
        return tourAsignado;
    }

    public String getVehiculoAsignado() {
        return vehiculoAsignado;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("[ENTIDAD: GUÍA] Nombre: " + getNombre() +
                " | Contacto: " + getTelefono() +
                " | Tour: " + tourAsignado +
                " | Vehículo: " + vehiculoAsignado);
    }
}