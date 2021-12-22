package com.ddd.sofka.AdministracionContext;

import co.com.sofka.domain.generic.AggregateEvent;
import com.ddd.sofka.AlmacenContext.AlmacenId;
import com.ddd.sofka.AlmacenContext.PiezaId;
import com.ddd.sofka.TallerContext.Solicitud;
import com.ddd.sofka.events.administracion.AdministracionCreada;
import com.ddd.sofka.events.administracion.FacturaGenerada;
import com.ddd.sofka.events.administracion.PiezasSolicitadas;
import com.ddd.sofka.events.administracion.SolicitudProcesada;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Administracion extends AggregateEvent<AdministracionId> {

    protected AlmacenId almacenId;
    protected Facturacion facturacion;
    protected List<Solicitud> historicoSolicitudes = new ArrayList<>();

    public Administracion(AdministracionId entityId, AlmacenId almacenId, Facturacion facturacion) {
        super(entityId);
        Objects.requireNonNull(almacenId);
        Objects.requireNonNull(facturacion);
        appendChange(new AdministracionCreada(almacenId, facturacion)).apply();
    }

    private Administracion(AdministracionId entityId){
        super(entityId);
        subscribe(new AdministracionChange(this));
    }

    public void procesarSolicitud(Solicitud solicitud){
        Objects.requireNonNull(solicitud);
        appendChange(new SolicitudProcesada(solicitud)).apply();
    }

    public void solicitarPiezas(List<PiezaId> piezas){
        appendChange(new PiezasSolicitadas(piezas)).apply();
    }

    public void generarFactura(){
        appendChange(new FacturaGenerada(this.facturacion)).apply();
    }
}
