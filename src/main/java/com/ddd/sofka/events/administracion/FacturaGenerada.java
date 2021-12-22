package com.ddd.sofka.events.administracion;

import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.sofka.AdministracionContext.Facturacion;

public class FacturaGenerada extends DomainEvent {
    private final Facturacion facturacion;

    public FacturaGenerada(Facturacion facturacion) {
        super("sofka.administracion.facturacreada");
        this.facturacion = facturacion;
    }

    public Facturacion getFacturacion() {
        return facturacion;
    }
}
