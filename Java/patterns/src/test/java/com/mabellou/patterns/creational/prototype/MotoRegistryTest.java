package com.mabellou.patterns.creational.prototype;

import com.mabellou.patterns.creational.prototype.parts.CarbonEngine;
import com.mabellou.patterns.creational.prototype.parts.FlatSuspension;
import com.mabellou.patterns.creational.prototype.parts.TouringTire;
import org.junit.Test;

public class MotoRegistryTest {

    @Test
    public void makeMotoWithPrototype(){
        MotoRegistry motoRegistry = new MotoRegistry();
        motoRegistry.addMotoToRegistry("harley", new Moto(new CarbonEngine(), new FlatSuspension(), new TouringTire()));

        Moto moto = motoRegistry.getMotoById("harley");
    }
}
