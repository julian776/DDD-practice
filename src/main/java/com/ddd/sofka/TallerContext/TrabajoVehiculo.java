package com.ddd.sofka.TallerContext;

import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class TrabajoVehiculo extends Entity<TrabajoVehiculoId> {

    private final Mecanico mecanico;
    private final Trabajo trabajo;

    public TrabajoVehiculo(TrabajoVehiculoId entityId, Mecanico mecanico, Trabajo trabajo){
        super(entityId);
        this.mecanico = Objects.requireNonNull(mecanico);
        this.trabajo = Objects.requireNonNull(trabajo);
    }

    public void revisionGeneral(Vehiculo vehiculo){
        var registro = vehiculo.getRegistro();
        System.out.println(registro.color());
        System.out.println(registro.marca());
        System.out.println(registro.motor());
        System.out.println(registro.numeroSerie());
    }
}
