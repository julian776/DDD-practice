package com.ddd.sofka.TallerContext;

import co.com.sofka.domain.generic.ValueObject;
import com.ddd.sofka.AlmacenContext.PiezaId;

import java.util.List;
import java.util.Objects;

public class Trabajo implements ValueObject<Trabajo> {

    private final String descripcion;
    private final Double precio;
    private final List<PiezaId> piezasAsociadas;
    private final String observaciones;
    private final Float tiempoEstimado;

    public Trabajo(String descripcion, Double precio, List<PiezaId> piezasAsociadas, String observaciones, Float tiempoEstimado){

        this.descripcion = Objects.requireNonNull(descripcion);
        this.precio = Objects.requireNonNull(precio);
        this.piezasAsociadas = Objects.requireNonNull(piezasAsociadas);
        this.observaciones = Objects.requireNonNull(observaciones);
        this.tiempoEstimado = Objects.requireNonNull(tiempoEstimado);
        if(descripcion.isBlank()){
            throw new IllegalArgumentException("La descripcion de un trabajo no puede estar en blanco");
        }
        if(precio<=0){
            throw new IllegalArgumentException("Un precio no puede ser negativo ni igual a cero");
        }
        if(observaciones.isBlank()){
            throw new IllegalArgumentException("Las observaciones de un trabajo no puede estar vacio");
        }
        if(tiempoEstimado<0){
            throw new IllegalArgumentException("El tiempo estimado no puede ser negativo");
        }
    }

    public String descripcion() {
        return descripcion;
    }

    public Double precio() {
        return precio;
    }

    public List<PiezaId> piezasAsociadas() {
        return piezasAsociadas;
    }

    public String observaciones() {
        return observaciones;
    }

    public Float tiempoEstimado() {
        return tiempoEstimado;
    }

    @Override
    public Trabajo value() {
        return new Trabajo(this.descripcion, this.precio, this.piezasAsociadas, this.observaciones, this.tiempoEstimado);
    }
}
