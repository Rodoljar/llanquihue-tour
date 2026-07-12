package ui;

import data.GestorEntidades;

public class Main {
    public static void main(String[] args) {

        GestorEntidades gestor = new GestorEntidades();


        WelcomeGUI bienvenida = new WelcomeGUI(gestor);
        bienvenida.setVisible(true);
    }
}