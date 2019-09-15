package com.mabellou.patterns.creational.abstractfactory.factory;

import com.mabellou.patterns.creational.abstractfactory.Engine;
import com.mabellou.patterns.creational.abstractfactory.Moto;
import com.mabellou.patterns.creational.abstractfactory.Suspension;
import com.mabellou.patterns.creational.abstractfactory.Tire;
import com.mabellou.patterns.creational.abstractfactory.harley.HarleyEngine;
import com.mabellou.patterns.creational.abstractfactory.harley.HarleySuspension;
import com.mabellou.patterns.creational.abstractfactory.harley.HarleyTire;

public class HarleyMotoFactory implements AbstractMotoFactory {
    @Override
    public Moto makeMoto() {
        return new Moto();
    }

    @Override
    public Engine makeEngine() {
        return new HarleyEngine();
    }

    @Override
    public Tire makeTire() {
        return new HarleyTire();
    }

    @Override
    public Suspension makeSuspension() {
        return new HarleySuspension();
    }
}
