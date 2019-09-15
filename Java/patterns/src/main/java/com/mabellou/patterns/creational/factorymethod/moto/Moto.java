package com.mabellou.patterns.creational.factorymethod.moto;

public class Moto {

    private Engine engine;
    private Suspension suspension;
    private Tire tire;

    public Moto(Engine engine, Suspension suspension, Tire tire) {
        this.engine = engine;
        this.suspension = suspension;
        this.tire = tire;
    }

    public Moto(){
    }

    public void addEngine(Engine engine){
        this.engine = engine;
    }

    public void addTire(Tire tire){
        this.tire = tire;
    }

    public void addSuspension(Suspension suspension){
        this.suspension = suspension;
    }

    public void makeNoise(){
        this.engine.makeNoise();
    }

    public void inflateTire(){
        this.tire.inflate();
    }

    public void compressSuspension(){
        this.suspension.compress();
    }
}
