package com.ddd.sofka.events.almacen;

import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.sofka.AlmacenContext.Inventario;

public class AlmacenCreado extends DomainEvent {

    private final Inventario inventario;

    public AlmacenCreado(Inventario inventario) {
        super("sofka.almacen.almacencreado");
        this.inventario = inventario;
    }

    public Inventario getInventario() {
        return inventario;
    }
}
