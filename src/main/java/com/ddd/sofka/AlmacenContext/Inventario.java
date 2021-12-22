package com.ddd.sofka.AlmacenContext;

import co.com.sofka.domain.generic.Entity;

import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

public class Inventario extends Entity<InventarioId> {

    private Capacidad capacidad;
    private Hashtable<PiezaId, PiezaVehiculo> listaPiezas;

    public Inventario(InventarioId entityId, Capacidad capacidad, Hashtable<PiezaId, PiezaVehiculo> listaPiezas){
        super(entityId);
        this.capacidad = Objects.requireNonNull(capacidad, "Capacidad can not be null");
        this.listaPiezas = Objects.requireNonNull(listaPiezas, "The list of piezaVehiculo can not be null");
    }

    public void actualizarCapacidad(Integer max, Integer min){
        this.capacidad = capacidad.actualizar(max, min);
    }

    public void registrarPiezas(List<PiezaVehiculo> listaPiezas){
        listaPiezas.forEach(piece -> {
            this.listaPiezas.put(piece.identity(), piece);
        });
    }

    public void despacharPieza(PiezaId piezaId, Integer cantidad){
        PiezaVehiculo pieza = listaPiezas.get(piezaId);
        pieza.restarCantidad(cantidad);
    }
}

