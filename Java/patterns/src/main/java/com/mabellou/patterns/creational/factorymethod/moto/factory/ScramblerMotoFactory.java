package com.mabellou.patterns.creational.factorymethod.moto.factory;

import com.mabellou.patterns.creational.factorymethod.moto.Engine;
import com.mabellou.patterns.creational.factorymethod.moto.Suspension;
import com.mabellou.patterns.creational.factorymethod.moto.Tire;
import com.mabellou.patterns.creational.factorymethod.moto.parts.CarbonEngine;
import com.mabellou.patterns.creational.factorymethod.moto.parts.FlatSuspension;
import com.mabellou.patterns.creational.factorymethod.moto.parts.PerformanceTire;

public class ScramblerMotoFactory extends AbstractMotoFactory {
    @Override
    public Engine makeEngine() {
        return new CarbonEngine();
    }

    @Override
    public Tire makeTire() {
        return new PerformanceTire();
    }

    @Override
    public Suspension makeSuspension() {
        return new FlatSuspension();
    }
}
