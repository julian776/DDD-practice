package com.ddd.sofka.AdministracionContext;

import co.com.sofka.domain.generic.Entity;
import com.ddd.sofka.TallerContext.Trabajo;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class Facturacion extends Entity<numeroOrden> {


    private final List<Trabajo> registroTrabajosVehiculo;
    private final Double total;

    public Facturacion(numeroOrden numeroOrden, List<Trabajo> registroTrabajosVehiculo) {
        super(numeroOrden);
        this.registroTrabajosVehiculo = Objects.requireNonNull(registroTrabajosVehiculo);
        total = calcularAcumulado(registroTrabajosVehiculo);
    }

    private Double calcularAcumulado(List<Trabajo> registroTrabajosVehiculo){
        return registroTrabajosVehiculo.stream().reduce(new Trabajo("XX",0D,"xx",1.5F),
                (total, next) -> new Trabajo("XX", total.precio() + next.precio(), "xx",1.5F)).precio();
    }

    private void generarFactura(){
        System.out.println(Calendar.getInstance());
    }
}
