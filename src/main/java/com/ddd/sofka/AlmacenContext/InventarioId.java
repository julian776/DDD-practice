package com.ddd.sofka.AlmacenContext;

import com.ddd.sofka.generics.Id;

public class InventarioId extends Id {

    public InventarioId(String id){
        super(id);
    }
    public InventarioId(){

    }

    public InventarioId of(String id){
        return new InventarioId(id);
    }
}
