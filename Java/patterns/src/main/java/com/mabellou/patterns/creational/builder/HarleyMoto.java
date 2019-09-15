package com.mabellou.patterns.creational.builder;

public class HarleyMoto {
    private Engine engine;
    private Tire tire;
    private Suspension suspension;

    public HarleyMoto() {
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
