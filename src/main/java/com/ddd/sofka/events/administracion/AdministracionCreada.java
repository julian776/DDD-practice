package com.ddd.sofka.events.administracion;

import co.com.sofka.domain.generic.DomainEvent;
import com.ddd.sofka.AdministracionContext.Facturacion;
import com.ddd.sofka.AlmacenContext.AlmacenId;

public class AdministracionCreada extends DomainEvent {

    private final AlmacenId almacenId;
    private final Facturacion facturacion;

    public AdministracionCreada(AlmacenId almacenId, Facturacion facturacion) {
        super("sofka.administracion.administracioncreada");
        this.almacenId = almacenId;
        this.facturacion = facturacion;
    }

    public AlmacenId getAlmacenId() {
        return almacenId;
    }

    public Facturacion getFacturacion() {
        return facturacion;
    }
}
