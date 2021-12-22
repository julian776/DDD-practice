package com.ddd.sofka.TallerContext;

import java.util.Objects;

public class Mecanico {

    private final String nombre;
    private final Long numeroIdentificacion;

    public Mecanico(String nombre, Long numeroIdentificacion){
        this.nombre = Objects.requireNonNull(nombre);
        this.numeroIdentificacion = Objects.requireNonNull(numeroIdentificacion);
        if(nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar en blanco");
        }
        if(numeroIdentificacion<0){
            throw new IllegalArgumentException("Un numero de identificacion no puede ser negativo");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Long getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mecanico mecanico = (Mecanico) o;
        return Objects.equals(nombre, mecanico.nombre) && Objects.equals(numeroIdentificacion, mecanico.numeroIdentificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, numeroIdentificacion);
    }
}
