package com.ddd.sofka.AlmacenContext;

import com.ddd.sofka.generics.Id;


public class PiezaId extends Id {

    public PiezaId(String id){
        super(id);
    }

    public PiezaId(){

    }

    public static PiezaId of(String id){
        return new PiezaId(id);
    }
}
