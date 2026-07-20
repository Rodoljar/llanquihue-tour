package model;

public class Tarjeta implements Validable {
    private String numeroTarjeta;
    private String tipo; // Ejemplo: Visa, Mastercard, Redcompra

    public Tarjeta(String numeroTarjeta, String tipo) {
        this.numeroTarjeta = numeroTarjeta != null ? numeroTarjeta.replaceAll("\\s+", "") : "";
        this.tipo = tipo;
    }

    // Implementación de Validable
    @Override
    public boolean validar() {

        return this.numeroTarjeta != null && this.numeroTarjeta.length() == 16;
    }


    public String getNumeroTarjeta() { return numeroTarjeta; }
    public void setNumeroTarjeta(String numeroTarjeta) { this.numeroTarjeta = numeroTarjeta; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        if (!validar()) {
            return "Tarjeta Inválida (Largo incorrecto)";
        }
        // Retorna los últimos 4 dígitos por seguridad
        String ultimosDigitos = numeroTarjeta.substring(numeroTarjeta.length() - 4);
        return tipo + " terminar en ****" + ultimosDigitos;
    }
}