package com.ddd.sofka.AlmacenContext;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Capacidad implements ValueObject<Capacidad> {

    private final Integer max;
    private final Integer min;

    public Capacidad(Integer max, Integer min){
        this.min = Objects.requireNonNull(min);
        this.max = Objects.requireNonNull(max);
        if (min < 0 || max < 0){
            throw new IllegalArgumentException("Number must not be negative");
        }
        if(min >= max){
            throw new IllegalArgumentException("Minimum capacity can not be equal or greater than max capacity");
        }
        if(max < min){
            throw new IllegalArgumentException("Max capacity can not be less than minimum capacity");
        }
    }

    public Integer max() {
        return max;
    }
    public Integer min(){return min;}


    @Override
    public Capacidad value() {
        return new Capacidad(this.max, this.min);
    }

    public Capacidad actualizar(Integer max, Integer min) {
        return new Capacidad(max, min);
    }
}
