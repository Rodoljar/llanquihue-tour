package model;

import java.util.Date;

public abstract class DocumentoComercial implements Registrable {
    protected String idDocumento;
    protected Date fechaEmision;

    public DocumentoComercial(String idDocumento) {
        this.idDocumento = idDocumento;
        this.fechaEmision = new Date(); // Fecha actual de creación
    }

    public String getIdDocumento() { return idDocumento; }
    public Date getFechaEmision() { return fechaEmision; }


    public abstract int calcularTotal();

    @Override
    public void registrar() {
        System.out.println(">>> [FINANZAS] Archivando Documento Comercial N°: " + idDocumento);
    }
}