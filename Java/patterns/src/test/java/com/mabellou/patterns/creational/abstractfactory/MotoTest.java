package com.mabellou.patterns.creational.abstractfactory;

import com.mabellou.patterns.creational.abstractfactory.factory.AbstractMotoFactory;
import com.mabellou.patterns.creational.abstractfactory.factory.HarleyMotoFactory;
import com.mabellou.patterns.creational.abstractfactory.factory.TriumphMotoFactory;
import org.junit.Test;

public class MotoTest {

    @Test
    public void makeHarleyMotoTest(){
        AbstractMotoFactory factory = new HarleyMotoFactory();
        createMoto(factory);
    }

    @Test
    public void makeTriumphMotoTest(){
        AbstractMotoFactory factory = new TriumphMotoFactory();
        createMoto(factory);
    }

    private void createMoto(AbstractMotoFactory factory) {
        Moto moto = factory.makeMoto();
        Engine engine = factory.makeEngine();
        Tire tire = factory.makeTire();
        Suspension suspension = factory.makeSuspension();

        moto.addEngine(engine);
        moto.addSuspension(suspension);
        moto.addTire(tire);

        moto.makeNoise();
        moto.compressSuspension();
        moto.inflateTire();
    }
}
