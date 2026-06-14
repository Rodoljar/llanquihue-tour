package model;

public class Tour {
    // 1. Atributos privados (Encapsulamiento)
    private String nombre;
    private String tipo;
    private int precio;

    // 2. Constructor: Nos permite instanciar  el objeto con datos
    public Tour(String nombre, String tipo, int precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    // 3. Métodos Getters y Setters (Para acceder y modificar los datos de forma segura)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    // 4. Método toString: Define cómo se mostrará el objeto cuando lo imprimamos
    @Override
    public String toString() {
        return "Tour/" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '/';
    }
}