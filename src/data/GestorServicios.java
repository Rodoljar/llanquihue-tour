package data;

import model.ServicioTuristico;
import model.RutaGastronomica;
import model.PaseoLacustre;
import model.ExcursionCultural;
import model.GuiaTuristico;

public class GestorServicios {

    public ServicioTuristico[] obtenerServiciosDePrueba() {
        GuiaTuristico guia1 = new GuiaTuristico("Juan Valdivia", "+56911988889");
        GuiaTuristico guia2 = new GuiaTuristico("María Inés Suarez", "+56933334444");

        ServicioTuristico[] lista = new ServicioTuristico[6];

        // Los parámetros : Nombre, Duración, Precio, Guía, Atributo especial
        lista[0] = new RutaGastronomica("Circuito postres de Frutillar", 3, 18000, guia1, 4);
        lista[1] = new RutaGastronomica("Sabores del Mar en Angelmó", 2, 25000, guia2, 3);

        lista[2] = new PaseoLacustre("Navegación a isla Fiendship", 8, 45000, guia1, "El Caleuche");
        lista[3] = new PaseoLacustre("Cruce Bahía Puerto Varas", 1, 12000, guia2, "Lancha a Motor");

        lista[4] = new ExcursionCultural("Ruta de los Colonos Alemanes", 5, 30000, guia1, "Museo Antonio Felmer");
        lista[5] = new ExcursionCultural("Mitos y Leyendas de Ancud", 6, 35000, guia2, "Fortín San Antonio");

        return lista;
    }
}