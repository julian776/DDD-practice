package com.ddd.sofka.events.almacen;

import co.com.sofka.domain.generic.DomainEvent;

public class CapacidadAumentada extends DomainEvent {
    private final Integer max;
    private final Integer min;

    public CapacidadAumentada(Integer max, Integer min) {
        super("sofka.almacen.capacidadaumentada");
        this.max = max;
        this.min = min;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }
}
