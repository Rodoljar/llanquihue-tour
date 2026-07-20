package model;

public class Producto {
    private String codigo;
    private String nombre;
    private int precioUnitario;

    public Producto(String codigo, String nombre, int precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(int precioUnitario) { this.precioUnitario = precioUnitario; }

    @Override
    public String toString() {
        return nombre + " ($" + precioUnitario + ")";
    }
}