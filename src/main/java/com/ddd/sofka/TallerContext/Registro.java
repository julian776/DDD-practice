package com.ddd.sofka.TallerContext;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Registro implements ValueObject<Registro> {

    private final Long numeroSerie;
    private final Integer motor;
    private final String color;
    private final String marca;

    public Registro(Long numeroSerie, Integer motor, String color, String marca){
        this.numeroSerie = Objects.requireNonNull(numeroSerie);
        this.motor = Objects.requireNonNull(motor);
        this.color = Objects.requireNonNull(color);
        this.marca = Objects.requireNonNull(marca);
        validateRegistro(numeroSerie, motor, color, marca);
    }

    private void validateRegistro(Long numeroSerie, Integer motor, String color, String marca){
        if(numeroSerie<0){
            throw new IllegalArgumentException("Un numero de serie no puede ser negativo");
        }
        if(motor<25){
            throw new IllegalArgumentException("CC Motor invalido");
        }
        if(color.isBlank()){
            throw new IllegalArgumentException("El color no puede estar en blanco");
        }
        if(marca.isBlank()){
            throw new IllegalArgumentException("La marca no puede estar en blanco");
        }
    }

    public Long numeroSerie() {
        return numeroSerie;
    }

    public Integer motor() {
        return motor;
    }

    public String color() {
        return color;
    }

    public String marca() {
        return marca;
    }

    @Override
    public Registro value() {
        return new Registro(this.numeroSerie, this.motor, this.color, this.marca);
    }
}
