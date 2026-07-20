package model;

import java.util.ArrayList;
import java.util.List;

public class OrdenDeCompra extends DocumentoComercial {
    private Cliente cliente;       // Composición
    private Proveedor proveedor;   // Composición
    private List<Producto> productos; // Composición de lista de objetos

    public OrdenDeCompra(String idDocumento, Cliente cliente, Proveedor proveedor) {
        super(idDocumento);
        this.cliente = cliente;
        this.proveedor = proveedor;
        this.productos = new ArrayList<>();
    }


    public void agregarProducto(Producto p) {
        if (p != null) {
            this.productos.add(p);
        }
    }


    public void agregarProducto(List<Producto> listaNuevos) {
        if (listaNuevos != null) {
            this.productos.addAll(listaNuevos);
        }
    }

    @Override
    public int calcularTotal() {
        int total = 0;
        for (Producto p : productos) {
            total += p.getPrecioUnitario();
        }
        return total;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("==========================================================================");
        System.out.println("[ORDEN DE COMPRA] N°: " + idDocumento + " | Emitida: " + fechaEmision);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("  " + cliente);
        System.out.println("  " + proveedor);
        System.out.println("  Productos detallados:");
        for (Producto p : productos) {
            System.out.println("    - [" + p.getCodigo() + "] " + p.getNombre() + " -> $" + p.getPrecioUnitario());
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("  TOTAL NETO A PAGAR: $" + calcularTotal());
        System.out.println("==========================================================================\n");
    }

    // Getters y Setters
    public Cliente getCliente() { return cliente; }
    public Proveedor getProveedor() { return proveedor; }
    public List<Producto> getProductos() { return productos; }
}