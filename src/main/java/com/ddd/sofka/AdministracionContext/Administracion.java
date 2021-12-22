package com.ddd.sofka.AdministracionContext;

import co.com.sofka.domain.generic.AggregateEvent;
import com.ddd.sofka.AlmacenContext.AlmacenId;
import com.ddd.sofka.TallerContext.Solicitud;

import java.util.Objects;

public class Administracion extends AggregateEvent<AdministracionId> {

    protected AlmacenId almacenId;
    protected Facturacion facturacion;

    public Administracion(AdministracionId entityId, AlmacenId almacenId, Facturacion facturacion) {
        super(entityId);
        this.almacenId = Objects.requireNonNull(almacenId);
        this.facturacion = Objects.requireNonNull(facturacion);
    }

    private Administracion(AdministracionId entityId){
        super(entityId);
        subscribe(new AdministracionChange(this));
    }

    public void procesarSolicitud(Solicitud solicitud){

    }

    public void solicitarPiezas(){

    }

    public void generarFactura(){
        facturacion.generarFactura();
    }
}
