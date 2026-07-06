package model;

public class RutaGastronomica extends ServicioTuristico {
    private int numeroDeParadas;

    // El constructor
    public RutaGastronomica(String nombre, int duracionHoras, int precio, GuiaTuristico guia, int numeroDeParadas) {
        super(nombre, duracionHoras, precio, guia);
        this.numeroDeParadas = numeroDeParadas;
    }

    // Getter y Setter
    public int getNumeroDeParadas() { return numeroDeParadas; }
    public void setNumeroDeParadas(int numeroDeParadas) { this.numeroDeParadas = numeroDeParadas; }

    @Override
    public String toString() {
        // Usamos super.toString()
        return "[Ruta Gastronómica] " + super.toString() + " | N° de Paradas: " + numeroDeParadas;

    }

    @Override
    public void mostrarInformacion() {
        // Llama a la base (imprime nombre, precio, duración, guía)
        super.mostrarInformacion();
        // Le pega el atributo exclusivo y hace el salto de línea definitivo
        System.out.println(" | N° de Paradas: " + numeroDeParadas);
    }


}