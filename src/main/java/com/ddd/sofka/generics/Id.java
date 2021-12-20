package com.ddd.sofka.generics;

import com.ddd.sofka.AlmacenContext.PiezaVehiculo;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class Id implements Serializable {

    private final String id;

    public Id(){
        this(UUID.randomUUID().toString());
    }

    public Id(String id){
        this.id = Objects.requireNonNull(id, "You must provide a valid id");
        if(id.isBlank()){
            throw new IllegalArgumentException("Id can not be empty");
        }
    }

    public String getId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id1 = (Id) o;
        return Objects.equals(id, id1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
