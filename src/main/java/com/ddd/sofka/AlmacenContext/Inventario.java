package com.ddd.sofka.AlmacenContext;

import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

public class Inventario extends InventarioId{

    private Capacidad capacidad;
    private Hashtable<String, PiezaVehiculo> listaPiezas;

    public Inventario(String id, Capacidad capacidad, Hashtable<String, PiezaVehiculo> listaPiezas){
        super(id);
        this.capacidad = Objects.requireNonNull(capacidad, "Capacidad can not be null");
        this.listaPiezas = Objects.requireNonNull(listaPiezas, "The list of piezaVehiculo can not be null");
    }

    public Inventario(Capacidad capacidad, Hashtable<String, PiezaVehiculo> listaPiezas){
        super();
        this.capacidad = Objects.requireNonNull(capacidad, "Capacidad can not be null");
        this.listaPiezas = Objects.requireNonNull(listaPiezas, "The list of piezaVehiculo can not be null");
    }

    public void actualizarCapacidad(Integer max, Integer min){
        this.capacidad = capacidad.actualizar(max, min);
    }

    public void registrarPiezas(List<PiezaVehiculo> listaPiezas){
        listaPiezas.forEach(piece -> {
            this.listaPiezas.put(piece.getId(), piece);
        });
    }

    public void despacharPiezas(String id, Integer cantidad){
        PiezaVehiculo pieza = listaPiezas.get(id);
        pieza.restarCantidad(cantidad);
    }
}

