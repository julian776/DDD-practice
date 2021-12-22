package com.ddd.sofka.TallerContext;

import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Vehiculo extends Entity<VehiculoId> {

    private final TrabajoVehiculoId trabajoVehiculoId;
    private final Owner owner;
    private final Registro registro;
    private boolean lucesEncendidas = false;
    private boolean motorEncendido = false;
    private boolean aireEncendido = false;

    public Vehiculo(VehiculoId entityId, TrabajoVehiculoId trabajoVehiculoId, Owner owner, Registro registro){
        super(entityId);
        this.trabajoVehiculoId = Objects.requireNonNull(trabajoVehiculoId);
        this.owner = Objects.requireNonNull(owner);
        this.registro = Objects.requireNonNull(registro);
    }

    public void encender(){
        this.motorEncendido = true;
    }
    public void apagar(){
        this.motorEncendido = false;
    }

    public void encenderLuces(){
        this.lucesEncendidas = true;
    }
    public void apagarLuces(){
        this.lucesEncendidas = false;
    }

    public void encenderAire(){
        this.aireEncendido = true;
    }
    public void apagarAire(){
        this.aireEncendido = false;
    }

    public TrabajoVehiculoId getTrabajoVehiculoId() {
        return trabajoVehiculoId;
    }

    public Owner getOwner() {
        return owner;
    }

    public Registro getRegistro() {
        return registro;
    }

    public boolean isLucesEncendidas() {
        return lucesEncendidas;
    }

    public boolean isMotorEncendido() {
        return motorEncendido;
    }

    public boolean isAireEncendido() {
        return aireEncendido;
    }
}
