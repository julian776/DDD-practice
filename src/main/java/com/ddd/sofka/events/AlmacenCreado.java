package com.ddd.sofka.events;

import co.com.sofka.domain.generic.DomainEvent;

public class AlmacenCreado extends DomainEvent {

    public AlmacenCreado() {
        super("sofka.almacen.almacencreado");
    }
}
