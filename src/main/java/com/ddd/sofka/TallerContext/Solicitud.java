package com.ddd.sofka.TallerContext;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Solicitud implements ValueObject<Solicitud> {

    private final String motivo;
    private final Trabajo trabajo;

    public Solicitud(String motivo, Trabajo trabajo){

        this.motivo = Objects.requireNonNull(motivo);
        this.trabajo = Objects.requireNonNull(trabajo);
        if(motivo.isBlank()){
            throw new IllegalArgumentException("No se puede tener una solicitud sin motivo");
        }
    }

    public String motivo() {
        return motivo;
    }

    public Trabajo trabajo() {
        return trabajo;
    }

    @Override
    public Solicitud value() {
        return new Solicitud(this.motivo, this.trabajo);
    }
}
