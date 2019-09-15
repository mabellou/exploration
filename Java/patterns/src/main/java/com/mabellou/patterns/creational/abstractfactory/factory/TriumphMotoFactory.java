package com.mabellou.patterns.creational.abstractfactory.factory;

import com.mabellou.patterns.creational.abstractfactory.Engine;
import com.mabellou.patterns.creational.abstractfactory.Moto;
import com.mabellou.patterns.creational.abstractfactory.Suspension;
import com.mabellou.patterns.creational.abstractfactory.Tire;
import com.mabellou.patterns.creational.abstractfactory.triumph.TriumphEngine;
import com.mabellou.patterns.creational.abstractfactory.triumph.TriumphSuspension;
import com.mabellou.patterns.creational.abstractfactory.triumph.TriumphTire;

public class TriumphMotoFactory implements AbstractMotoFactory {
    @Override
    public Moto makeMoto() {
        return new Moto();
    }

    @Override
    public Engine makeEngine() {
        return new TriumphEngine();
    }

    @Override
    public Tire makeTire() {
        return new TriumphTire();
    }

    @Override
    public Suspension makeSuspension() {
        return new TriumphSuspension();
    }
}
