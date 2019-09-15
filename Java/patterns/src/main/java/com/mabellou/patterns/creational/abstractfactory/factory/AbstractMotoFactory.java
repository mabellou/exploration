package com.mabellou.patterns.creational.abstractfactory.factory;

import com.mabellou.patterns.creational.abstractfactory.Engine;
import com.mabellou.patterns.creational.abstractfactory.Moto;
import com.mabellou.patterns.creational.abstractfactory.Suspension;
import com.mabellou.patterns.creational.abstractfactory.Tire;

public interface AbstractMotoFactory {
    Moto makeMoto();
    Engine makeEngine();
    Tire makeTire();
    Suspension makeSuspension();
}
