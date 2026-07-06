package model;

public class ExcursionCultural extends ServicioTuristico {
    private String lugarHistorico;

    public ExcursionCultural(String nombre, int duracionHoras, int precio, GuiaTuristico guia, String lugarHistorico) {
        super(nombre, duracionHoras, precio, guia);
        this.lugarHistorico = lugarHistorico;
    }

    // Getter y Setter
    public String getLugarHistorico() { return lugarHistorico; }
    public void setLugarHistorico(String lugarHistorico) { this.lugarHistorico = lugarHistorico; }

    @Override
    public String toString() {
        return "[Excursión Cultural] " + super.toString() + " | Lugar Histórico: " + lugarHistorico;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println(" | Lugar Histórico: " + lugarHistorico);
    }


}
