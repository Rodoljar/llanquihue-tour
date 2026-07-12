package model;

public class ColaboradorExterno extends Persona {
    private String empresaAsociada;

    public ColaboradorExterno(String nombre, String telefono, String empresaAsociada) {
        super(nombre, telefono);
        this.empresaAsociada = empresaAsociada;
    }

    public String getEmpresaAsociada() { return empresaAsociada; }

    @Override
    public void mostrarResumen() {
        System.out.println("[ENTIDAD: COLABORADOR] Nombre: " + nombre + " | Empresa: " + empresaAsociada + " | Tel: " + telefono);
    }
}