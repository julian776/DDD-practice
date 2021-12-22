package com.ddd.sofka.events.almacen;

import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.sofka.AlmacenContext.PiezaVehiculo;

import java.util.List;

public class CancelacionDespachoProcesada extends DomainEvent {

    private final String motivo;
    private final List<PiezaVehiculo> listaPiezas;

    public CancelacionDespachoProcesada(String motivo, List<PiezaVehiculo> listaPiezas) {
        super("sofka.almacen.devolucion");
        this.motivo = motivo;
        this.listaPiezas = listaPiezas;
    }

    public String getMotivo() {
        return motivo;
    }

    public List<PiezaVehiculo> getListaPiezas() {
        return listaPiezas;
    }
}
