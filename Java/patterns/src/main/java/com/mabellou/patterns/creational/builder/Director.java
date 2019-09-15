package com.mabellou.patterns.creational.builder;

public class Director {
    public void construct(MotoBuilder builder) {
        String sound = "vroooom";
        builder.buildEngine(sound);
        builder.buildSuspension();
        builder.buildTire(1L);
    }
}
