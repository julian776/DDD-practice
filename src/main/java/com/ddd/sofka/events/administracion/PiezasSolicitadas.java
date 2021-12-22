package com.ddd.sofka.events.administracion;

import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.sofka.AlmacenContext.PiezaId;

import java.util.List;

public class PiezasSolicitadas extends DomainEvent {
    private final List<PiezaId> piezas;

    public PiezasSolicitadas(List<PiezaId> piezas) {
        super("sofka.administracion.piezassolicitadas");
        this.piezas = piezas;
    }

    public List<PiezaId> getPiezas() {
        return piezas;
    }
}
