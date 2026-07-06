package ui;

import data.GestorServicios;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos el gestor
        GestorServicios gestor = new GestorServicios();

        // 2. Ejecutamos el recorrido polimórfico
        gestor.desplegarCatalogoPolimorfico();
    }
}