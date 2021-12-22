package com.ddd.sofka.AdministracionContext;

import co.com.sofka.domain.generic.EventChange;
import com.ddd.sofka.events.administracion.AdministracionCreada;
import com.ddd.sofka.events.administracion.FacturaGenerada;
import com.ddd.sofka.events.administracion.PiezasSolicitadas;
import com.ddd.sofka.events.administracion.SolicitudProcesada;

public class AdministracionChange extends EventChange {
    public AdministracionChange(Administracion administracion) {

        apply((AdministracionCreada event) -> {
            administracion.almacenId = event.getAlmacenId();
            administracion.facturacion = event.getFacturacion();
        });

        apply((SolicitudProcesada event) -> {
            administracion.historicoSolicitudes.add(event.getSolicitud());
            administracion.solicitarPiezas(event.getSolicitud().trabajo().piezasAsociadas());
        });

        apply((PiezasSolicitadas event) -> {
            System.out.println("Piezas en la solicitud");
            System.out.println("----------------------");
            event.getPiezas().forEach(piezaId -> {
                System.out.println(piezaId);
            });
        });

        apply((FacturaGenerada event) -> {
            event.getFacturacion().generarFactura();
        });
    }
}
