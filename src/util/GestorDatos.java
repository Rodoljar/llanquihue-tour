package util;

import model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorDatos {

    // Método que lee el archivo y retorna la lista dinámica de Tours
    public ArrayList<Tour> leerToursDesdeArchivo(String rutaArchivo) {
        ArrayList<Tour> listaTours = new ArrayList<>();

        // El 'try-with-resources' asegura que el archivo se cierre automáticamente
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; // Salta líneas vacías si existen

                // Separar los datos por cada punto y coma
                String[] partes = linea.split(";");

                // Validamos que la línea tenga exactamente los 3 datos requeridos
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String tipo = partes[1].trim();

                    try {
                        int precio = Integer.parseInt(partes[2].trim());

                        // Instanciamos el objeto. Si falla alguna validación de Tour,
                        // saltará al catch de abajo sin romper el programa.
                        Tour nuevoTour = new Tour(nombre, tipo, precio);
                        listaTours.add(nuevoTour);

                    } catch (NumberFormatException e) {
                        System.out.println("[Error de Formato] No se pudo convertir el precio en la línea: " + linea);
                    } catch (IllegalArgumentException e) {
                        System.out.println("[Error de Validación] " + e.getMessage() + " -> Línea omitida.");
                    }
                } else {
                    System.out.println("[Formato Incorrecto] La línea no tiene 3 campos: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error crítico al leer el archivo: " + e.getMessage());
        }

        return listaTours;
    }
}