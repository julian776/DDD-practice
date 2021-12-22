package com.ddd.sofka.events.taller;

import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.sofka.TallerContext.TrabajoVehiculoId;

public class TrabajoCancelado extends DomainEvent {
    private final TrabajoVehiculoId trabajoVehiculoId;

    public TrabajoCancelado(TrabajoVehiculoId trabajoVehiculoId) {
        super("sofka.taller.trabajocancelado");
        this.trabajoVehiculoId = trabajoVehiculoId;
    }

    public TrabajoVehiculoId getTrabajoVehiculoId() {
        return trabajoVehiculoId;
    }
}
