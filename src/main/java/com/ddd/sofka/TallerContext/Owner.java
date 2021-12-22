package com.ddd.sofka.TallerContext;

import java.io.Serializable;
import java.util.Objects;

public final class Owner implements Serializable {

    private final String nombre;
    private final Long numeroIdentificacion;

    public Owner(String nombre, Long numeroIdentificacion){
        this.nombre = Objects.requireNonNull(nombre, "Un nombre no puede ser null");
        this.numeroIdentificacion = Objects.requireNonNull(numeroIdentificacion, "Un numero de identificacion no puede ser null");
        if(nombre.isBlank()){
            throw new IllegalArgumentException("Nombre puede ser vacio");
        }
        if(numeroIdentificacion < 0){
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
        Owner owner = (Owner) o;
        return Objects.equals(nombre, owner.nombre) && Objects.equals(numeroIdentificacion, owner.numeroIdentificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, numeroIdentificacion);
    }
}
