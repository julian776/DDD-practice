package com.ddd.sofka.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.sofka.AlmacenContext.PiezaId;

import java.util.Hashtable;

public class PiezasDespachadas extends DomainEvent {
    private final Hashtable<PiezaId, Integer> piezasSolicitadas;

    public PiezasDespachadas(Hashtable<PiezaId, Integer> piezasSolicitadas) {
        super("sofka.almacen.piezasdespachadas");
        this.piezasSolicitadas = piezasSolicitadas;
    }

    public Hashtable<PiezaId, Integer> getPiezasSolicitadas() {
        return piezasSolicitadas;
    }
}
