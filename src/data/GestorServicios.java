package data;

import model.ServicioTuristico;
import model.RutaGastronomica;
import model.PaseoLacustre;
import model.ExcursionCultural;
import model.GuiaTuristico;

import java.util.ArrayList;
import java.util.List;

public class GestorServicios {

    private List<ServicioTuristico> listaServicios;

    public GestorServicios() {
        this.listaServicios = new ArrayList<>();
        cargarServiciosDePrueba();
    }


    private void cargarServiciosDePrueba() {
        // CORREGIDO: Ahora pasamos los 4 parámetros que exige tu nueva clase GuiaTuristico
        GuiaTuristico guia1 = new GuiaTuristico("Juan Valdivia", "+56911988889", "Circuito postres de Frutillar", "Mercedes Sprinter");
        GuiaTuristico guia2 = new GuiaTuristico("María Inés Suarez", "+56933334444", "Sin asignar", "Sin asignar");

        // Agrupados en el origen para que salgan ordenados en el bucle único
        listaServicios.add(new RutaGastronomica("Circuito postres de Frutillar", 3, 18000, guia1, 4));
        listaServicios.add(new RutaGastronomica("Sabores del Mar en Angelmó", 2, 25000, guia2, 3));

        listaServicios.add(new PaseoLacustre("Navegación a isla Friendship", 8, 45000, guia1, "El Caleuche"));
        listaServicios.add(new PaseoLacustre("Cruce Bahía Puerto Varas", 1, 12000, guia2, "Lancha a Motor"));

        listaServicios.add(new ExcursionCultural("Ruta de los Colonos Alemanes", 5, 30000, guia1, "Museo Antonio Felmer"));
        listaServicios.add(new ExcursionCultural("Mitos y Leyendas de Ancud", 6, 35000, guia2, "Fortín San Antonio"));
    }

    public List<ServicioTuristico> getListaServicios() {
        return listaServicios;
    }

    public void desplegarCatalogoPolimorfico() {
        System.out.println("==========================================================================");
        System.out.println("                LLANQUIHUE TOUR - CATÁLOGO DE SERVICIOS                   ");
        System.out.println("         (Rutas y sabores de la región, para toda la familia).            ");
        System.out.println("==========================================================================");

        String ultimaClase = "";

        for (ServicioTuristico servicio : listaServicios) {
            String claseActual = servicio.getClass().getSimpleName();

            if (!claseActual.equals(ultimaClase)) {
                String tituloSeccion = "";

                if (claseActual.equals("RutaGastronomica")) {
                    tituloSeccion = "RUTAS GASTRONÓMICAS";
                } else if (claseActual.equals("PaseoLacustre")) {
                    tituloSeccion = "PASEOS LACUSTRES";
                } else if (claseActual.equals("ExcursionCultural")) {
                    tituloSeccion = "EXCURSIONES CULTURALES";
                }

                System.out.println("\n>>> SECCIÓN: " + tituloSeccion);
                System.out.println("--------------------------------------------------------------------------");
                ultimaClase = claseActual;
            }

            servicio.mostrarInformacion();
        }

        System.out.println("\n==========================================================================");
    }
}