package com.mabellou.patterns.creational.prototype;

public class Moto implements Prototype<Moto>{

    private Engine engine;
    private Suspension suspension;
    private Tire tire;

    public Moto(Engine engine, Suspension suspension, Tire tire) {
        this.engine = engine;
        this.suspension = suspension;
        this.tire = tire;
    }

    public Moto(Moto moto) {
        this.engine = moto.engine;
        this.suspension = moto.suspension;
        this.tire = moto.tire;
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

    @Override
    public Moto clone() {
        return new Moto(this);
    }
}
