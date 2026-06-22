package service;

import model.Tour;
import java.util.ArrayList;

public class TourService {
    private ArrayList<Tour> listaTours;

    // Constructor que recibe la lista cargada desde el archivo
    public TourService(ArrayList<Tour> listaTours) {
        this.listaTours = listaTours;
    }

    // Operación: Recorrido y visualización completa por consola
    public void mostrarCatalogo() {
        if (listaTours.isEmpty()) {
            System.out.println("El catálogo está vacío.");
            return;
        }
        for (Tour t : listaTours) {
            System.out.println(t);
        }
    }

    // Operación: Filtrado automatizado por tipo (Paso 3 - Búsquedas simples)
    public ArrayList<Tour> filtrarPorTipo(String tipoBuscado) {
        ArrayList<Tour> filtrados = new ArrayList<>();
        for (Tour t : listaTours) {
            if (t.getTipo().equalsIgnoreCase(tipoBuscado)) {
                filtrados.add(t);
            }
        }
        return filtrados;
    }
}
