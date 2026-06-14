package data;

import model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestorDatos {

    // Método que lee el archivo y retorna la lista dinámica de Tours
    public ArrayList<Tour> leerToursDesdeArchivo(String rutaArchivo) {
        ArrayList<Tour> listaTours = new ArrayList<>();

        // El 'try-with-resources' asegura que el archivo se cierre automáticamente al terminar
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            // Leemos línea por línea hasta que el archivo se quede vacío (null)
            while ((linea = br.readLine()) != null) {
                // 1. Separar los datos por cada punto y coma
                String[] partes = linea.split(";");

                // Validamos que la línea tenga exactamente los 3 datos requeridos
                if (partes.length == 3) {
                    String nombre = partes[0];
                    String tipo = partes[1];
                    // Convertimos el precio que viene como texto a un número entero
                    int precio = Integer.parseInt(partes[2]);

                    // 2. Instanciamos el objeto Tour con los datos de la línea
                    Tour nuevoTour = new Tour(nombre, tipo, precio);

                    // 3. Lo agregamos al ArrayList
                    listaTours.add(nuevoTour);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir el precio a número: " + e.getMessage());
        }

        return listaTours;
    }
}