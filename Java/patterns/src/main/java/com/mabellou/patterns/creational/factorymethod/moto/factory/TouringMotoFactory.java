package com.mabellou.patterns.creational.factorymethod.moto.factory;

import com.mabellou.patterns.creational.factorymethod.moto.Engine;
import com.mabellou.patterns.creational.factorymethod.moto.Suspension;
import com.mabellou.patterns.creational.factorymethod.moto.Tire;
import com.mabellou.patterns.creational.factorymethod.moto.parts.CarbonEngine;
import com.mabellou.patterns.creational.factorymethod.moto.parts.SoftSuspension;
import com.mabellou.patterns.creational.factorymethod.moto.parts.TouringTire;

public class TouringMotoFactory extends AbstractMotoFactory {

    @Override
    public Engine makeEngine() {
        return new CarbonEngine();
    }

    @Override
    public Tire makeTire() {
        return new TouringTire();
    }

    @Override
    public Suspension makeSuspension() {
        return new SoftSuspension();
    }
}
