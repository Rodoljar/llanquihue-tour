package model;

public class PaseoLacustre extends ServicioTuristico {
    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, int duracionHoras, int precio,  GuiaTuristico guia, String tipoEmbarcacion) {
        super(nombre, duracionHoras, precio, guia);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    // Getter y Setter
    public String getTipoEmbarcacion() { return tipoEmbarcacion; }
    public void setTipoEmbarcacion(String tipoEmbarcacion) { this.tipoEmbarcacion = tipoEmbarcacion; }

    @Override
    public String toString() {
        return "[Paseo Lacustre] " + super.toString() + " | Embarcación: " + tipoEmbarcacion;
    }
}