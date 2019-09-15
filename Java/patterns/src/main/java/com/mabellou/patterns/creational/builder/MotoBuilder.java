package com.mabellou.patterns.creational.builder;

public interface MotoBuilder {
    void buildEngine(String sound);
    void buildTire(Long size);
    void buildSuspension();
}
