package com.ddd.sofka.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.sofka.AlmacenContext.PiezaVehiculo;

import java.util.List;

public class PiezasProcesadas extends DomainEvent {
    private final List<PiezaVehiculo> listaPiezas;

    public PiezasProcesadas(List<PiezaVehiculo> listaPiezas){
        super("sofka.almacen.piezasprocesadas");
        this.listaPiezas = listaPiezas;
    }

    public List<PiezaVehiculo> getListaPiezas() {
        return listaPiezas;
    }
}
