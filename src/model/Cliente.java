package model;

public class Cliente extends Persona {
    private Tarjeta tarjetaAsociada; // Composición

    public Cliente(String nombre, Rut rut, Direccion direccion, Tarjeta tarjetaAsociada) {
        super(nombre, rut, direccion);
        this.tarjetaAsociada = tarjetaAsociada;
    }

    public Tarjeta getTarjetaAsociada() { return tarjetaAsociada; }
    public void setTarjetaAsociada(Tarjeta tarjetaAsociada) { this.tarjetaAsociada = tarjetaAsociada; }

    @Override
    public void mostrarDatos() {
        System.out.println("[CLIENTE] Nombre: " + nombre +
                " | RUT: " + rut +
                " | Dirección: " + direccion +
                " | Pago: " + tarjetaAsociada);
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " (" + rut + ")";
    }
}