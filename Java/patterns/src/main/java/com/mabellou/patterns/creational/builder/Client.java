package com.mabellou.patterns.creational.builder;

public class Client {

    public HarleyMoto makeHarley(){
        HarleyMotoBuilder builder = new HarleyMotoBuilder();
        Director director =  new Director();

        director.construct(builder);

        HarleyMoto harleyMoto = builder.getResult();
        return harleyMoto;
    }
}
