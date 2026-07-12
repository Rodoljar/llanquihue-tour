package data;

import model.Registrable;
import model.GuiaTuristico;
import model.Vehiculo;
import model.ColaboradorExterno;
// Importamos tus servicios de la semana pasada
import model.RutaGastronomica;
import model.PaseoLacustre;
import model.ExcursionCultural;

import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {

    private List<Registrable> listaEntidades;

    public GestorEntidades() {
        this.listaEntidades = new ArrayList<>();
        cargarEntidadesDePrueba();
    }

    private void cargarEntidadesDePrueba() {
        // Guías base
        GuiaTuristico guia1 = new GuiaTuristico("Juan Valdivia", "+56911988889");
        GuiaTuristico guia2 = new GuiaTuristico("María Inés Suarez", "+56933334444");

        listaEntidades.add(guia1);
        listaEntidades.add(guia2);

        // ¡Tus servicios de la semana pasada integrados aquí mismo!
        listaEntidades.add(new RutaGastronomica("Circuito postres de Frutillar", 3, 18000, guia1, 4));
        listaEntidades.add(new PaseoLacustre("Navegación a isla Friendship", 8, 45000, guia1, "El Caleuche"));
        listaEntidades.add(new ExcursionCultural("Ruta de los Colonos Alemanes", 5, 30000, guia1, "Museo Antonio Felmer"));

        // Los nuevos recursos de la semana 8
        listaEntidades.add(new Vehiculo("HG-DF-88", "Hyundai H1", 11));
        listaEntidades.add(new ColaboradorExterno("Restaurante El Fogón", "+5665223344", "Sabores Llanquihue"));
        listaEntidades.add(new Vehiculo("BB-CC-11", "Mercedes Sprinter", 19));
    }

    public void agregarEntidad(Registrable entidad) {
        this.listaEntidades.add(entidad);
    }

    public void desplegarResumenEntidades() {
        System.out.println("==========================================================================");
        System.out.println("                LLANQUIHUE TOUR - REGISTRO GENERAL UNIFICADO              ");
        System.out.println("==========================================================================");

        for (Registrable entidad : listaEntidades) {


            entidad.mostrarResumen();


            if (entidad instanceof Vehiculo) {
                Vehiculo v = (Vehiculo) entidad;
                if (v.getCapacidadPasajeros() > 15) {
                    System.out.println("   --> [AVISO]: Vehículo mayor. Requiere conductor con Licencia Profesional.");
                }
            } else if (entidad instanceof RutaGastronomica) {
                System.out.println("\n   --> [TIPS]: Recordar a los clientes llevar efectivo para propinas opcionales.");
            } else if (entidad instanceof PaseoLacustre) {
                System.out.println("\n   --> [SEGURIDAD]: Obligatorio el uso de chaleco salvavidas en toda la navegación.");
            }

            System.out.println("\n--------------------------------------------------------------------------");
        }
    }

    public List<Registrable> getListaEntidades() {
        return listaEntidades;
    }

    public void eliminarEntidad(int index) {
        if (index >= 0 && index < listaEntidades.size()) {
            this.listaEntidades.remove(index);
        }
    }
}