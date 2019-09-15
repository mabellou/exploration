package com.mabellou.patterns.creational.factorymethod.moto.factory;

import com.mabellou.patterns.creational.factorymethod.moto.Moto;
import com.mabellou.patterns.creational.factorymethod.moto.Engine;
import com.mabellou.patterns.creational.factorymethod.moto.Suspension;
import com.mabellou.patterns.creational.factorymethod.moto.Tire;

public abstract class AbstractMotoFactory {
    public final Moto makeMoto(){
        Moto moto = new Moto();
        moto.addEngine(makeEngine());
        moto.addSuspension(makeSuspension());
        moto.addTire(makeTire());
        return moto;
    }
    public abstract Engine makeEngine();
    public abstract Tire makeTire();
    public abstract Suspension makeSuspension();
}
