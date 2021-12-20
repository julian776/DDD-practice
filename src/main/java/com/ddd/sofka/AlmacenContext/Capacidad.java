package com.ddd.sofka.AlmacenContext;

import java.io.Serializable;
import java.util.Objects;

public class Capacidad implements Serializable {

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

    public Integer getMax() {
        return max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capacidad capacidad = (Capacidad) o;
        return Objects.equals(max, capacidad.max) && Objects.equals(min, capacidad.min);
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, min);
    }

    public Capacidad actualizar(Integer max, Integer min) {
        return new Capacidad(max, min);
    }
}
