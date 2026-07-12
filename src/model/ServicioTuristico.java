package model;

public class ServicioTuristico implements Registrable {
    protected String nombre;
    protected int duracionHoras;
    protected int precio;
    protected GuiaTuristico guia;

    public ServicioTuristico(String nombre, int duracionHoras, int precio, GuiaTuristico guia) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
        this.precio = precio;
        this.guia = guia;
    }


    // GETTERS Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public GuiaTuristico getGuia() {
        return guia;
    }

    public void setGuia(GuiaTuristico guia) {
        this.guia = guia;
    }


    // MÉTODOS DE COMPORTAMIENTO

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Duración: " + duracionHoras + " hrs | Precio: $" + precio + " | Guía: " + guia;
    }

    public void mostrarInformacion() {
        System.out.print("[Servicio] Nombre: " + nombre +
                " | Duración: " + duracionHoras + " hrs" +
                " | Precio: $" + precio +
                " | Guía: " + (guia != null ? guia.getNombre() : "Sin guía"));
    }

    @Override
    public void mostrarResumen() {
        mostrarInformacion();
    }
}