package com.ddd.sofka.TallerContext;

import co.com.sofka.domain.generic.EventChange;
import com.ddd.sofka.events.taller.SolicitudRealizada;
import com.ddd.sofka.events.taller.TallerCreado;
import com.ddd.sofka.events.taller.TrabajoAgregado;
import com.ddd.sofka.events.taller.TrabajoCancelado;

public class TallerChange extends EventChange {

    public TallerChange(Taller taller) {

        apply((TallerCreado event) -> {
            taller.listaVehiculos = event.getListaVehiculos();
            taller.listaTrabajosVehiculo = event.getListaTrabajosVehiculo();
            taller.solicitud = event.getSolicitud();
        });

        apply((SolicitudRealizada event) -> {
            taller.solicitud = event.getSolicitud();
        });

        apply((TrabajoAgregado event) -> {
           taller.listaTrabajosVehiculo.put(event.getTrabajoVehiculo().identity(), event.getTrabajoVehiculo());
        });

        apply((TrabajoCancelado event) -> {
            taller.listaTrabajosVehiculo.remove(event.getTrabajoVehiculoId());
        });
    }
}
