package ui;

import data.GestorServicios;
import model.ServicioTuristico;
import model.RutaGastronomica;
import model.PaseoLacustre;
import model.ExcursionCultural;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================================================");
        System.out.println("                LLANQUIHUE TOUR - SISTEMA DE FILTRADO                     ");
        System.out.println("           (Rutas y sabores de la región, para toda la familia.)             ");
        System.out.println("==========================================================================");

        GestorServicios gestor = new GestorServicios();
        ServicioTuristico[] catalogo = gestor.obtenerServiciosDePrueba();

        // 1.  Rutas Gastronómicas
        System.out.println("\n>>> SECCIÓN: RUTAS GASTRONÓMICAS");
        System.out.println("--------------------------------------------------------------------------");
        mostrarFiltrado(catalogo, RutaGastronomica.class);

        // 2.  Paseos Lacustres
        System.out.println("\n>>> SECCIÓN: PASEOS LACUSTRES");
        System.out.println("--------------------------------------------------------------------------");
        mostrarFiltrado(catalogo, PaseoLacustre.class);

        // 3.  Excursiones Culturales
        System.out.println("\n>>> SECCIÓN: EXCURSIONES CULTURALES");
        System.out.println("--------------------------------------------------------------------------");
        mostrarFiltrado(catalogo, ExcursionCultural.class);

        System.out.println("==========================================================================");
    }

    public static void mostrarFiltrado(ServicioTuristico[] catalogo, Class<?> tipoBuscado) {
        for (ServicioTuristico servicio : catalogo) {
            if (tipoBuscado.isInstance(servicio)) {
                System.out.println(servicio);
            }
        }
    }
}