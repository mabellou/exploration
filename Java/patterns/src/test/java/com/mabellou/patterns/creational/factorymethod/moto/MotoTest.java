package com.mabellou.patterns.creational.factorymethod.moto;

import com.mabellou.patterns.creational.factorymethod.moto.factory.AbstractMotoFactory;
import com.mabellou.patterns.creational.factorymethod.moto.factory.ScramblerMotoFactory;
import org.junit.Test;

public class MotoTest {

    @Test
    public void makeMotoWithFactoryMethod(){
        AbstractMotoFactory factory = new ScramblerMotoFactory();
        Moto moto = factory.makeMoto();
    }
}
