package com.mabellou.patterns.creational.factorymethod.fromthebook;

public class MyApplication extends Application {

    @Override
    public Document createDocument() {
        return new MyDocument();
    }
}
