package com.ddd.sofka.AdministracionContext;

import co.com.sofka.domain.generic.AggregateEvent;

public class Administracion extends AggregateEvent<AdministracionId> {

    public Administracion(AdministracionId entityId) {
        super(entityId);
    }
}
