package com.ddd.sofka.events.taller;

import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.sofka.AdministracionContext.Administracion;
import com.ddd.sofka.TallerContext.Solicitud;

public class SolicitudRealizada extends DomainEvent {
    private final Solicitud solicitud;

    public SolicitudRealizada(Solicitud solicitud, Administracion administracion) {
        super("sofka.taller.solicitudrealizada");
        this.solicitud = solicitud;
        administracion.procesarSolicitud(solicitud);
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }
}
