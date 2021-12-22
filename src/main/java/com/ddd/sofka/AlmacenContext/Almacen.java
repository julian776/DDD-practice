package com.ddd.sofka.AlmacenContext;

import co.com.sofka.domain.generic.AggregateEvent;
import com.ddd.sofka.events.almacen.*;

import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

public class Almacen extends AggregateEvent<AlmacenId> {

    protected Inventario inventario;

    public Almacen(AlmacenId entityId, Inventario inventario) {
        super(entityId);
        this.inventario = Objects.requireNonNull(inventario);
        appendChange(new AlmacenCreado(inventario)).apply();
    }

    private Almacen(AlmacenId entityId){
        super(entityId);
        subscribe(new AlmacenChange(this));
    }

    public void procesarPiezas(List<PiezaVehiculo> listaPiezas){
        appendChange(new PiezasProcesadas(listaPiezas)).apply();
    }

    public void despacharPiezas(Hashtable<PiezaId, Integer> piezasSolicitadas){
        Objects.requireNonNull(piezasSolicitadas);
        appendChange(new PiezasDespachadas(piezasSolicitadas)).apply();
    }

    public void procesarCancelacionDespacho(String motivo, List<PiezaVehiculo> listaPiezas){
        Objects.requireNonNull(motivo);
        Objects.requireNonNull(listaPiezas);
        appendChange(new CancelacionDespachoProcesada(motivo, listaPiezas)).apply();
    }

    public void actualizarCapacidad(Integer max, Integer min){
        appendChange(new CapacidadAumentada(max, min)).apply();
    }

    public Inventario getInventario() {
        return inventario;
    }
}
