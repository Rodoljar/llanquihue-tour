package data;

import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {
    private List<Registrable> listaEntidades;
    private final String ARCHIVO_TXT = "entidades.txt";

    public GestorEntidades() {
        this.listaEntidades = new ArrayList<>();
        // Intentamos cargar desde el archivo TXT; si está vacío o no existe, cargamos los de prueba
        cargarDesdeTexto();
        if (this.listaEntidades.isEmpty()) {
            cargarDatosDePrueba();
            guardarEnTexto(); // Creamos el archivo con los datos base
        }
    }

    private void cargarDatosDePrueba() {
        // Guías iniciales de prueba
        GuiaTuristico g1 = new GuiaTuristico("Juan Valdivia", "+56911988889", "Circuito postres de Frutillar", "Mercedes Sprinter");
        GuiaTuristico g2 = new GuiaTuristico("María Inés Suarez", "+56933334444", "Sin asignar", "Sin asignar");

        // Vehículos iniciales de prueba
        Vehiculo v1 = new Vehiculo("HG-DF-88", "Hyundai H1", 11);
        Vehiculo v2 = new Vehiculo("BB-CC-11", "Mercedes Sprinter", 19);

        listaEntidades.add(g1);
        listaEntidades.add(g2);
        listaEntidades.add(v1);
        listaEntidades.add(v2);

        // Servicios iniciales (Polimorfismo)
        listaEntidades.add(new RutaGastronomica("Circuito postres de Frutillar", 3, 18000, g1, 4));
        listaEntidades.add(new PaseoLacustre("Navegación a isla Friendship", 8, 45000, g1, "El Caleuche"));
        listaEntidades.add(new ExcursionCultural("Ruta de los Colonos Alemanes", 5, 30000, g1, "Museo Antonio Felmer"));
    }

    public void agregarEntidad(Registrable entidad) {
        listaEntidades.add(entidad);
        guardarEnTexto(); // Guarda automáticamente al añadir
    }

    public void eliminarEntidad(int indice) {
        if (indice >= 0 && indice < listaEntidades.size()) {
            listaEntidades.remove(indice);
            guardarEnTexto(); // Guarda automáticamente al eliminar
        }
    }

    public List<Registrable> getListaEntidades() {
        return listaEntidades;
    }

    // ==========================================
    //   MÉTODOS DE PERSISTENCIA (LECTURA Y ESCRITURA)
    // ==========================================

    private void guardarEnTexto() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_TXT))) {
            for (Registrable ent : listaEntidades) {
                if (ent instanceof GuiaTuristico) {
                    GuiaTuristico g = (GuiaTuristico) ent;
                    bw.write("GUIA," + g.getNombre() + "," + g.getTelefono() + "," + g.getTourAsignado() + "," + g.getVehiculoAsignado());
                } else if (ent instanceof Vehiculo) {
                    Vehiculo v = (Vehiculo) ent;
                    bw.write("VEHICULO," + v.getPatente() + "," + v.getModelo() + "," + v.getCapacidadPasajeros());
                } else if (ent instanceof RutaGastronomica) {
                    RutaGastronomica r = (RutaGastronomica) ent;
                    bw.write("RUTA_GASTRO," + r.getNombre() + "," + r.getPrecio() + "," + r.getNumeroDeParadas());
                } else if (ent instanceof PaseoLacustre) {
                    PaseoLacustre p = (PaseoLacustre) ent;
                    bw.write("PASEO_LACUSTRE," + p.getNombre() + "," + p.getPrecio() + "," + p.getTipoEmbarcacion());
                } else if (ent instanceof ExcursionCultural) {
                    ExcursionCultural ec = (ExcursionCultural) ent;
                    bw.write("EXCURSION_CULT," + ec.getNombre() + "," + ec.getPrecio() + "," + ec.getLugarHistorico());
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo TXT: " + e.getMessage());
        }
    }

    private void cargarDesdeTexto() {
        File archivo = new File(ARCHIVO_TXT);
        if (!archivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            // Usamos un guía comodín temporal por si los servicios guardados necesitan referencias
            GuiaTuristico guiaGenerico = new GuiaTuristico("Guía General", "+56900000000", "Varios", "Varios");

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 2) continue;

                String tipo = datos[0];
                switch (tipo) {
                    case "GUIA":
                        listaEntidades.add(new GuiaTuristico(datos[1], datos[2], datos[3], datos[4]));
                        break;
                    case "VEHICULO":
                        listaEntidades.add(new Vehiculo(datos[1], datos[2], Integer.parseInt(datos[3])));
                        break;
                    case "RUTA_GASTRO":
                        listaEntidades.add(new RutaGastronomica(datos[1], 3, Integer.parseInt(datos[2]), guiaGenerico, Integer.parseInt(datos[3])));
                        break;
                    case "PASEO_LACUSTRE":
                        listaEntidades.add(new PaseoLacustre(datos[1], 4, Integer.parseInt(datos[2]), guiaGenerico, datos[3]));
                        break;
                    case "EXCURSION_CULT":
                        listaEntidades.add(new ExcursionCultural(datos[1], 5, Integer.parseInt(datos[2]), guiaGenerico, datos[3]));
                        break;
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al cargar el archivo TXT: " + e.getMessage());
        }
    }

    public void desplegarResumenEntidades() {
        System.out.println("--- Resumen de Datos Actualizado en el Archivo " + ARCHIVO_TXT + " ---");
    }
}