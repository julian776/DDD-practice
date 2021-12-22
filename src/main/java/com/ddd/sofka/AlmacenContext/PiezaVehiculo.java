package com.ddd.sofka.AlmacenContext;

import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class PiezaVehiculo extends Entity<PiezaId> {

    private Integer cantidad;
    private InformacionPieza informacionPieza;

    public PiezaVehiculo(PiezaId entityId, Integer cantidad, InformacionPieza informacionPieza){
        super(entityId);
        validatePiezaVehiculo(cantidad, informacionPieza);
    }

    private void validatePiezaVehiculo(Integer cantidad, InformacionPieza informacionPieza){
        this.cantidad = Objects.requireNonNull(cantidad, "Cantidad can not be null");
        this.informacionPieza = Objects.requireNonNull(informacionPieza, "Pieza can not be null");
        if(cantidad<= 0){
            throw new IllegalArgumentException("Cantidad can not be negative or equal to 0");
        }
    }

    public void sumarCantidad(Integer sumando){
        if(sumando < 0){
            throw new IllegalArgumentException("Can not sum a negative value");
        }
        this.cantidad += sumando;
    }

    public void restarCantidad(Integer restando){
        if(restando < 0){
            throw new IllegalArgumentException("The number must be positive");
        }
        this.cantidad -= restando;
    }
}
