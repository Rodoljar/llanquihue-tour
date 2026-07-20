package app;

import data.GestorSistema;
import model.*;
import utils.LectorArchivos;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   LLANQUIHUE TOUR - SISTEMA DE GESTIÓN MODULAR   ");
        System.out.println("==================================================");


        GestorSistema sistema = new GestorSistema();


        List<Producto> catalogoTours = LectorArchivos.cargarProductos("productos.txt");

        System.out.println("\n=== SIMULACIÓN DE RESERVAS Y ASIGNACIÓN DE ITINERARIOS ===");


        System.out.println(">>> Buscando Turista RUT 15.632.784-K...");
        Persona turistaEncontrado = sistema.buscarPersonaPorRut("15.632.784-K");

        System.out.println(">>> Buscando Operador Turístico RUT 76.452.190-7...");
        Persona operadorEncontrado = sistema.buscarPersonaPorRut("76.452.190-7");


        if (turistaEncontrado instanceof Cliente && operadorEncontrado instanceof Proveedor) {
            Cliente turista = (Cliente) turistaEncontrado;
            Proveedor operador = (Proveedor) operadorEncontrado;


            OrdenDeCompra reservaGrupal = new OrdenDeCompra("RES-2026-001", turista, operador);


            if (!catalogoTours.isEmpty()) {
                reservaGrupal.agregarProducto(catalogoTours.get(0)); // Cupo Tour Frutillar ($45.000)
                reservaGrupal.agregarProducto(catalogoTours.get(1)); // Cupo Volcán Osorno ($85.000)


                for (int i = 0; i < 12; i++) {
                    reservaGrupal.agregarProducto(catalogoTours.get(1)); // 12 ascenciones adicionales para el grupo
                }
            }


            sistema.agregarEntidad(reservaGrupal);
        } else {
            System.out.println(">>> [ERROR]: No se pudo emitir la reserva. Pasajero o Prestador no válidos.");
        }

        // 5. Crear una Reserva Individual Estándar (Menor a un millón)
        Persona turista2 = sistema.buscarPersonaPorRut("18.421.359-3");
        if (turista2 instanceof Cliente && operadorEncontrado instanceof Proveedor) {
            OrdenDeCompra reservaIndividual = new OrdenDeCompra("RES-2026-002", (Cliente) turista2, (Proveedor) operadorEncontrado);
            if (catalogoTours.size() > 2) {
                reservaIndividual.agregarProducto(catalogoTours.get(2)); // Navegación Lago ($35.000)
                reservaIndividual.agregarProducto(catalogoTours.get(3)); // Trekking Alerce ($55.000)
            }
            sistema.agregarEntidad(reservaIndividual);
        }

        // 6. Desplegar el reporte final
        sistema.mostrarCatalogoCompleto();
    }
}