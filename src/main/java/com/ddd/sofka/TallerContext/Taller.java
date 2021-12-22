package com.ddd.sofka.TallerContext;

import co.com.sofka.domain.generic.AggregateEvent;
import com.ddd.sofka.AdministracionContext.Administracion;
import com.ddd.sofka.events.taller.SolicitudRealizada;
import com.ddd.sofka.events.taller.TrabajoAgregado;

import java.util.Hashtable;
import java.util.Objects;

public class Taller extends AggregateEvent<TallerId> {

    protected Hashtable<VehiculoId, Vehiculo> listaVehiculos;
    protected Solicitud solicitud;
    protected Hashtable<TrabajoVehiculoId, TrabajoVehiculo> listaTrabajosVehiculo;

    public Taller(TallerId entityId, Hashtable<VehiculoId, Vehiculo> listaVehiculos, Solicitud solicitud, Hashtable<TrabajoVehiculoId, TrabajoVehiculo> listaTrabajosVehiculo) {
        super(entityId);
        this.listaVehiculos = Objects.requireNonNull(listaVehiculos);
        this.solicitud = Objects.requireNonNull(solicitud);
        this.listaTrabajosVehiculo = Objects.requireNonNull(listaTrabajosVehiculo);
    }

    private Taller(TallerId entityId){
        super(entityId);
        subscribe(new TallerChange(this));
    }
    public void realizarSolicitud(Solicitud solicitud, Administracion administracion){
        Objects.requireNonNull(solicitud);
        Objects.requireNonNull(administracion);
        appendChange(new SolicitudRealizada(solicitud, administracion)).apply();
    }

    public void agregarTrabajo(TrabajoVehiculo trabajoVehiculo){
        Objects.requireNonNull(trabajoVehiculo);
        appendChange(new TrabajoAgregado(trabajoVehiculo)).apply();
    }

}
