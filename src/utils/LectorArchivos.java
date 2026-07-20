package utils;

import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivos {

    // Lee los dato
    public static List<Cliente> cargarClientes(String rutaArchivo) {
        List<Cliente> lista = new ArrayList<>();
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 6) continue; // Validación de estructura

                try {
                    String nombre = datos[0].trim();
                    Rut rut = new Rut(datos[1].trim()); // Validación y excepción interna
                    Direccion dir = new Direccion(datos[2].trim(), Integer.parseInt(datos[3].trim()), datos[4].trim());
                    Tarjeta tar = new Tarjeta(datos[5].trim(), datos.length > 6 ? datos[6].trim() : "Visa");

                    lista.add(new Cliente(nombre, rut, dir, tar));
                } catch (RutInvalidoException | NumberFormatException e) {
                    System.out.println(">>> [ERROR LECTURA CLIENTE]: " + e.getMessage() + " en línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de clientes: " + e.getMessage());
        }
        return lista;
    }

    // Lee los datos de proveedores
    public static List<Proveedor> cargarProveedores(String rutaArchivo) {
        List<Proveedor> lista = new ArrayList<>();
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 6) continue;

                try {
                    String nombre = datos[0].trim();
                    Rut rut = new Rut(datos[1].trim());
                    Direccion dir = new Direccion(datos[2].trim(), Integer.parseInt(datos[3].trim()), datos[4].trim());
                    String rubro = datos[5].trim();

                    lista.add(new Proveedor(nombre, rut, dir, rubro));
                } catch (RutInvalidoException | NumberFormatException e) {
                    System.out.println(">>> [ERROR LECTURA PROVEEDOR]: " + e.getMessage() + " en línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de proveedores: " + e.getMessage());
        }
        return lista;
    }

    // Lee los datos de productos
    public static List<Producto> cargarProductos(String rutaArchivo) {
        List<Producto> lista = new ArrayList<>();
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 3) continue;

                try {
                    String codigo = datos[0].trim();
                    String nombre = datos[1].trim();
                    int precio = Integer.parseInt(datos[2].trim());

                    lista.add(new Producto(codigo, nombre, precio));
                } catch (NumberFormatException e) {
                    System.out.println(">>> [ERROR LECTURA PRODUCTO]: Precio inválido en línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de productos: " + e.getMessage());
        }
        return lista;
    }
}