package com.ddd.sofka.events.administracion;

import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.sofka.TallerContext.Solicitud;

public class SolicitudProcesada extends DomainEvent {
    private final Solicitud solicitud;

    public SolicitudProcesada(Solicitud solicitud) {
        super("sofka.administracion.solicitudprocesada");
        this.solicitud = solicitud;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }
}
