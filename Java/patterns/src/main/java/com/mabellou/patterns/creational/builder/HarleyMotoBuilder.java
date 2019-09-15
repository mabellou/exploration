package com.mabellou.patterns.creational.builder;

import com.mabellou.patterns.creational.builder.parts.CarbonEngine;
import com.mabellou.patterns.creational.builder.parts.FlatSuspension;
import com.mabellou.patterns.creational.builder.parts.TouringTire;

public class HarleyMotoBuilder implements MotoBuilder {
    private HarleyMoto harleyMotoInConstruction;

    public HarleyMotoBuilder() {
        this.harleyMotoInConstruction = new HarleyMoto();
    }

    public void buildEngine(String sound){
        harleyMotoInConstruction.addEngine(new CarbonEngine());
    }

    public void buildTire(Long size){
        harleyMotoInConstruction.addTire(new TouringTire());
    }

    public void buildSuspension(){
        harleyMotoInConstruction.addSuspension(new FlatSuspension());
    }


    public HarleyMoto getResult() {
        return harleyMotoInConstruction;
    }
}
