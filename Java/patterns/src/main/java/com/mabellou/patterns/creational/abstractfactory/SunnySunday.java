package com.mabellou.patterns.creational.abstractfactory;

import com.mabellou.patterns.creational.abstractfactory.factory.AbstractMotoFactory;

public class SunnySunday {

    private AbstractMotoFactory factory;
    private Moto moto;

    public SunnySunday(AbstractMotoFactory factory) {
        this.factory = factory;
    }

    public void prepareSunnySunday(){
        moto = factory.makeMoto();
        moto.addEngine(factory.makeEngine());
        moto.addTire(factory.makeTire());
        moto.addSuspension(factory.makeSuspension());
    }
}
