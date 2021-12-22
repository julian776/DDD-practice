package com.ddd.sofka.events.taller;

import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.sofka.TallerContext.Trabajo;
import com.ddd.sofka.TallerContext.TrabajoVehiculo;
import com.ddd.sofka.TallerContext.TrabajoVehiculoId;

import java.util.Hashtable;

public class TrabajoAgregado extends DomainEvent {

    private final TrabajoVehiculo trabajoVehiculo;

    public TrabajoAgregado(TrabajoVehiculo trabajoVehiculo) {
        super("sofka.taller.trabajoagregado");
        this.trabajoVehiculo = trabajoVehiculo;
    }

    public TrabajoVehiculo getTrabajoVehiculo() {
        return trabajoVehiculo;
    }
}
