package ui;

import data.GestorDatos;
import model.Tour;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos el gestor de datos
        GestorDatos gestor = new GestorDatos();

        // 2. Definimos la ruta de nuestro archivo de texto
        // "resources/tours.txt" le dice a Java que busque en la carpeta de recursos
        String ruta = "resources/tours.txt";

        // 3. Cargamos los datos del archivo en la lista dinámica
        ArrayList<Tour> todosLosTours = gestor.leerToursDesdeArchivo(ruta);

        // --- PARTE 1: MOSTRAR TODOS LOS ELEMENTOS (RECORRIDO) ---
        System.out.println("=============================================");
        System.out.println("    CATÁLOGO COMPLETO - LLANQUIHUE TOUR      ");
        System.out.println("=============================================");
        for (Tour t : todosLosTours) {
            System.out.println(t);
        }
        System.out.println();

        // --- PARTE 2 Y 3: FILTRAR Y MOSTRAR RESULTADOS ---
        // Condición de ejemplo: Queremos buscar sólo los tours de tipo "Lacustre"
        String tipoBuscado = "Lacustre";

        System.out.println("=============================================");
        System.out.println("   FILTRANDO TOURS DE TIPO: " + tipoBuscado.toUpperCase());
        System.out.println("=============================================");

        int contadorFiltro = 0;
        for (Tour t : todosLosTours) {
            // Usamos .equalsIgnoreCase para comparar textos sin importar mayúsculas/minúsculas
            if (t.getTipo().equalsIgnoreCase(tipoBuscado)) {
                System.out.println(t);
                contadorFiltro++;
            }
        }

        if (contadorFiltro == 0) {
            System.out.println("No se encontraron tours de tipo: " + tipoBuscado);
        }
        System.out.println("=============================================");
    }
}
