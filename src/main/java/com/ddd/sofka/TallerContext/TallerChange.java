package com.ddd.sofka.TallerContext;

import co.com.sofka.domain.generic.EventChange;
import com.ddd.sofka.events.taller.SolicitudRealizada;
import com.ddd.sofka.events.taller.TrabajoAgregado;

public class TallerChange extends EventChange {

    public TallerChange(Taller taller) {

        apply((SolicitudRealizada event) -> {
            taller.solicitud = event.getSolicitud();
        });

        apply((TrabajoAgregado event) -> {
           taller.listaTrabajosVehiculo.put(event.getTrabajoVehiculo().identity(), event.getTrabajoVehiculo());
        });

        apply();
    }
}
