package model;

public class ServicioTuristico {
    protected String nombre;
    protected int duracionHoras;
    protected int precio; // <-- Agregamos el precio
    protected GuiaTuristico guia;

    // Actualizamos el constructor para que reciba el precio
    public ServicioTuristico(String nombre, int duracionHoras, int precio, GuiaTuristico guia) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
        this.precio = precio;
        this.guia = guia;
    }

    // Getters y Setters para el precio
    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getDuracionHoras() { return duracionHoras; }
    public void setDuracionHoras(int duracionHoras) { this.duracionHoras = duracionHoras; }

    public GuiaTuristico getGuia() { return guia; }
    public void setGuia(GuiaTuristico guia) { this.guia = guia; }

    @Override
    public String toString() {
        // Sumamos el valor formateado al toString común
        return "Nombre: " + nombre + " | Duración: " + duracionHoras + " hrs | Precio: $" + precio + " | Guía: " + guia;
    }


    public void mostrarInformacion() {
        System.out.print("[Servicio] Nombre: " + nombre +
                " | Duración: " + duracionHoras + " hrs" +
                " | Precio: $" + precio +
                " | Guía: " + (guia != null ? guia.getNombre() : "Sin guía"));
    }

}