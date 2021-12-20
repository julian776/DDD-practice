package com.ddd.sofka.AlmacenContext;

import java.io.Serializable;
import java.util.Objects;

public class InformacionPieza implements Serializable {

    private final Float peso;
    private final Double precio;
    private final String marca;

    public InformacionPieza(Float peso, Double precio, String marca){
        this.peso = Objects.requireNonNull(peso, "El peso no puede ser null");
        this.precio = Objects.requireNonNull(precio, "El precio no puede ser null");
        this.marca = Objects.requireNonNull(marca, "La marca no puede ser null");
        if(peso <= 0){
            throw new IllegalArgumentException("Weight can not be negative or equals 0");
        }
        if(precio <= 0){
            throw new IllegalArgumentException("Price can not be negative or equals 0");
        }
        if(marca.isBlank()){
            throw new IllegalArgumentException("Brand must not be empty");
        }
    }


    public Float getPeso() {
        return peso;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformacionPieza that = (InformacionPieza) o;
        return Objects.equals(peso, that.peso) && Objects.equals(precio, that.precio) && Objects.equals(marca, that.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peso, precio, marca);
    }
}
