package model;

import utils.RutInvalidoException;

public class Rut implements Validable {
    private int numero;
    private char dv;


    public Rut(String rutCompleto) throws RutInvalidoException {
        procesarYValidar(rutCompleto);
    }

    private void procesarYValidar(String rutCompleto) throws RutInvalidoException {
        if (rutCompleto == null || rutCompleto.trim().isEmpty()) {
            throw new RutInvalidoException("El RUT no puede estar vacío.");
        }


        String limpio = rutCompleto.replaceAll("\\s+", "").replace(".", "").replace("-", "").trim();

        if (limpio.length() < 2) {
            throw new RutInvalidoException("El formato del RUT es demasiado corto.");
        }

        try {

            this.dv = limpio.charAt(limpio.length() - 1);

            this.numero = Integer.parseInt(limpio.substring(0, limpio.length() - 1));


            if (!validar()) {
                throw new RutInvalidoException("El dígito verificador '" + dv + "' no corresponde al RUT ingresado.");
            }
        } catch (NumberFormatException e) {
            throw new RutInvalidoException("El cuerpo del RUT debe contener solo números.");
        }
    }


    @Override
    public boolean validar() {
        return true;
    }

    public int getNumero() { return numero; }
    public char getDv() { return dv; }


    @Override
    public String toString() {
        return numero + "-" + dv;
    }
}