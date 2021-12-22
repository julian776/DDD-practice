package com.ddd.sofka.AlmacenContext;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class InformacionPieza implements ValueObject<InformacionPieza> {

    private final Float peso;
    private final Double precio;
    private final String marca;

    public InformacionPieza(Float peso, Double precio, String marca){
        this.peso = Objects.requireNonNull(peso, "El peso no puede ser null");
        this.precio = Objects.requireNonNull(precio, "El precio no puede ser null");
        this.marca = Objects.requireNonNull(marca, "La marca no puede ser null");
        if(peso <= 0){
            throw new IllegalArgumentException("Weight can not be negative or equals 0");
        }
        if(precio <= 0){
            throw new IllegalArgumentException("Price can not be negative or equals 0");
        }
        if(marca.isBlank()){
            throw new IllegalArgumentException("Brand must not be empty");
        }
    }


    public Float peso() {
        return peso;
    }

    public Double precio() {
        return precio;
    }

    public String marca() {
        return marca;
    }

    @Override
    public InformacionPieza value() {
        return new InformacionPieza(this.peso, this.precio, this.marca);
    }
}
