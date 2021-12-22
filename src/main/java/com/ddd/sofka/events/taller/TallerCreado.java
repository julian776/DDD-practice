package com.ddd.sofka.events.taller;

import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.sofka.TallerContext.*;

import java.util.Hashtable;

public class TallerCreado extends DomainEvent {

    private final Hashtable<VehiculoId, Vehiculo> listaVehiculos;
    private final Solicitud solicitud;
    private final Hashtable<TrabajoVehiculoId, TrabajoVehiculo> listaTrabajosVehiculo;

    public TallerCreado(Hashtable<VehiculoId, Vehiculo> listaVehiculos, Solicitud solicitud, Hashtable<TrabajoVehiculoId, TrabajoVehiculo> listaTrabajosVehiculo) {
        super("sofka.taller.tallercreado");
        this.listaVehiculos = listaVehiculos;
        this.solicitud = solicitud;
        this.listaTrabajosVehiculo = listaTrabajosVehiculo;
    }

    public Hashtable<VehiculoId, Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public Hashtable<TrabajoVehiculoId, TrabajoVehiculo> getListaTrabajosVehiculo() {
        return listaTrabajosVehiculo;
    }
}
