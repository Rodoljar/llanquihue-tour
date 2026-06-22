package app;

import model.Tour;
import util.GestorDatos;
import service.TourService;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos el gestor de datos (ahora desde el paquete util)
        GestorDatos gestor = new GestorDatos();

        // 2. Definimos la ruta de nuestro archivo de texto
        String ruta = "resources/tours.txt";

        // 3. Cargamos los datos del archivo en la lista dinámica
        ArrayList<Tour> todosLosTours = gestor.leerToursDesdeArchivo(ruta);

        // 4. Inicializamos el servicio con la lista cargada
        TourService servicio = new TourService(todosLosTours);

        // --- PASO 3: MOSTRAR TODOS LOS ELEMENTOS (RECORRIDO AUTOMATIZADO) ---
        System.out.println("=============================================");
        System.out.println("    CATÁLOGO COMPLETO - LLANQUIHUE TOUR      ");
        System.out.println("=============================================");
        servicio.mostrarCatalogo();
        System.out.println();

        // --- PASO 3: BÚSQUEDA Y FILTRADO ---
        String tipoBuscado = "Lacustre";

        System.out.println("=============================================");
        System.out.println("   FILTRANDO TOURS DE TIPO: " + tipoBuscado.toUpperCase());
        System.out.println("=============================================");

        ArrayList<Tour> toursFiltrados = servicio.filtrarPorTipo(tipoBuscado);

        if (toursFiltrados.isEmpty()) {
            System.out.println("No se encontraron tours de tipo: " + tipoBuscado);
        } else {
            for (Tour t : toursFiltrados) {
                System.out.println(t);
            }
        }
        System.out.println("=============================================");
    }
}