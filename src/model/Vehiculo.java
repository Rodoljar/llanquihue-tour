package model;

public class Vehiculo implements Registrable {
    private String patente;
    private String modelo;
    private int capacidadPasajeros;

    public Vehiculo(String patente, String modelo, int capacidadPasajeros) {
        this.patente = patente;
        this.modelo = modelo;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public String getPatente() { return patente; }
    public String getModelo() { return modelo; }
    public int getCapacidadPasajeros() { return capacidadPasajeros; }

    @Override
    public void mostrarResumen() {
        System.out.println("[ENTIDAD: VEHÍCULO] Modelo: " + modelo + " | Patente: " + patente + " | Capacidad: " + capacidadPasajeros + " pasajeros");
    }
}