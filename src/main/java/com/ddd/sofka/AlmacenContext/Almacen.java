package com.ddd.sofka.AlmacenContext;

import co.com.sofka.domain.generic.AggregateEvent;
import com.ddd.sofka.events.AlmacenCreado;
import com.ddd.sofka.events.CancelacionDespachoProcesada;
import com.ddd.sofka.events.PiezasDespachadas;
import com.ddd.sofka.events.PiezasProcesadas;

import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

public class Almacen extends AggregateEvent<AlmacenId> {

    private final Inventario inventario;

    public Almacen(AlmacenId entityId, Inventario inventario) {
        super(entityId);
        this.inventario = Objects.requireNonNull(inventario);
        appendChange(new AlmacenCreado()).apply();
    }

    public void procesarPiezas(List<PiezaVehiculo> listaPiezas){
        Objects.requireNonNull(listaPiezas);
        inventario.registrarPiezas(listaPiezas);
        appendChange(new PiezasProcesadas(listaPiezas)).apply();
    }

    public void despacharPiezas(Hashtable<PiezaId, Integer> piezasSolicitadas){
        Objects.requireNonNull(piezasSolicitadas);
        piezasSolicitadas.forEach((piezaId, cantidad) -> {
            inventario.despacharPieza(piezaId, cantidad);
        });
        appendChange(new PiezasDespachadas(piezasSolicitadas)).apply();
    }

    public void procesarCancelacionDespacho(String motivo, List<PiezaVehiculo> listaPiezas){
        Objects.requireNonNull(motivo);
        if(motivo.isBlank()){
            throw new IllegalArgumentException("El motivo de la devolucion no puede ser vacio");
        }
        Objects.requireNonNull(listaPiezas);
        inventario.registrarPiezas(listaPiezas);
        appendChange(new CancelacionDespachoProcesada(motivo, listaPiezas)).apply();
    }
}
