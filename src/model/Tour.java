package model;

public class Tour {
    // 1. Atributos privados (Encapsulamiento)
    private String nombre;
    private String tipo;
    private int precio;

    // 2. Constructor: Ahora usa los setters para que las validaciones se ejecuten al crear el objeto
    public Tour(String nombre, String tipo, int precio) {
        setNombre(nombre);
        setTipo(tipo);
        setPrecio(precio);
    }

    // 3. Métodos Getters y Setters con validaciones incluidas
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del tour no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de tour no puede estar vacío.");
        }
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser un valor negativo.");
        }
        this.precio = precio;
    }

    // 4. Método toString implementado de forma limpia
    @Override
    public String toString() {
        return "Tour -> Nombre: " + nombre + " | Tipo: " + tipo + " | Precio: $" + precio;
    }
}