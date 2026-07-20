package data;

import model.*;
import utils.LectorArchivos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorSistema {

    private List<Registrable> listaEntidades;


    private Map<String, Persona> mapaPersonasPorRut;

    public GestorSistema() {
        this.listaEntidades = new ArrayList<>();
        this.mapaPersonasPorRut = new HashMap<>();


        cargarTodoDesdeArchivos();
    }

    private void cargarTodoDesdeArchivos() {
        System.out.println("=== INICIANDO CARGA DE DATOS DESDE ARCHIVOS TXT ===");

        //  Cargar Clientes
        List<Cliente> clientesCargados = LectorArchivos.cargarClientes("clientes.txt");
        for (Cliente c : clientesCargados) {
            agregarEntidad(c);
        }


        List<Proveedor> proveedoresCargados = LectorArchivos.cargarProveedores("proveedores.txt");
        for (Proveedor p : proveedoresCargados) {
            agregarEntidad(p);
        }


        List<Producto> productosCargados = LectorArchivos.cargarProductos("productos.txt");
        System.out.println(">>> [PRODUCTOS] " + productosCargados.size() + " productos listos para la venta.");
        System.out.println("==================================================\n");
    }

    public void agregarEntidad(Registrable entidad) {
        if (entidad == null) return;

        this.listaEntidades.add(entidad);
        entidad.registrar(); // Ejecuta el método


        if (entidad instanceof Persona) {
            Persona p = (Persona) entidad;
            this.mapaPersonasPorRut.put(p.getRut().toString(), p);
        }
    }

    // Método para buscar y filtrar objetos
    public Persona buscarPersonaPorRut(String rutABuscar) {

        String limpio = rutABuscar.replace(".", "").replaceAll("\\s+", "").trim();
        return this.mapaPersonasPorRut.get(limpio);
    }

    // Recorrer y mostrar colecciones usando instanceof
    public void mostrarCatalogoCompleto() {
        System.out.println("\n==========================================================================");
        System.out.println("                SISTEMA COMERCIAL - RESUMEN DE REGISTROS                  ");
        System.out.println("==========================================================================");

        for (Registrable entidad : listaEntidades) {

            entidad.mostrarDatos();


            if (entidad instanceof Cliente) {
                Cliente c = (Cliente) entidad;
                if (!c.getTarjetaAsociada().validar()) {
                    System.out.println("   --> [ALERTA OPERACIONAL]: Tarjeta inválida. Bloquear compras pendientes.");
                }
            } else if (entidad instanceof OrdenDeCompra) {
                OrdenDeCompra orden = (OrdenDeCompra) entidad;
                if (orden.calcularTotal() > 1000000) {
                    System.out.println("   --> [FINANZAS]: Orden de alto valor. Requiere aprobación de Gerencia.");
                }
            }
            System.out.println("--------------------------------------------------------------------------");
        }
    }


    public List<Registrable> getListaEntidades() {
        return listaEntidades;
    }
}