package com.ddd.sofka.AlmacenContext;

import co.com.sofka.domain.generic.EventChange;
import com.ddd.sofka.events.almacen.*;

import java.util.Objects;

public class AlmacenChange extends EventChange {
    public AlmacenChange(Almacen almacen) {

        apply((AlmacenCreado event) -> {
            almacen.inventario = event.getInventario();
        });

        apply((PiezasProcesadas event) -> {
            Objects.requireNonNull(event.getListaPiezas());
            almacen.inventario.registrarPiezas(event.getListaPiezas());
        });

        apply((PiezasDespachadas event) -> {
            event.getPiezasSolicitadas().forEach((piezaId, cantidad) -> {
                almacen.inventario.despacharPieza(piezaId, cantidad);
            });
        });

        apply((CancelacionDespachoProcesada event) -> {
            if(event.getMotivo().isBlank()){
                throw new IllegalArgumentException("El motivo de la devolucion no puede ser vacio");
            }
            almacen.inventario.registrarPiezas(event.getListaPiezas());
        });

        apply((CapacidadAumentada event) -> {
            almacen.inventario.actualizarCapacidad(event.getMax(), event.getMin());
        });
    }
}
