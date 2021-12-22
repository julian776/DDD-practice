package com.ddd.sofka.TallerContext;

import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Hashtable;
import java.util.Objects;

public class Taller extends AggregateEvent<TallerId> {

    private final Hashtable<VehiculoId, Vehiculo> listaVehiculos;
    private final Solicitud solicitud;
    private final Hashtable<TrabajoVehiculoId, TrabajoVehiculo> listaTrabajosVehiculo;
    //TODO: Revisar la necesidad de solicitud, a lo mejor quitarla y hacer una solicitud directa sin OV
    public Taller(TallerId entityId, Hashtable<VehiculoId, Vehiculo> listaVehiculos, Solicitud solicitud, Hashtable<TrabajoVehiculoId, TrabajoVehiculo> listaTrabajosVehiculo) {
        super(entityId);
        this.listaVehiculos = Objects.requireNonNull(listaVehiculos);
        this.solicitud = solicitud;
        this.listaTrabajosVehiculo = Objects.requireNonNull(listaTrabajosVehiculo);
    }
}
