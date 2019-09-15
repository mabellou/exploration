package com.mabellou.patterns.creational.factorymethod.fromthebook;

public abstract class Application {
    public void newDocument(){
        Document document = this.createDocument();
        document.makeSomething();
    }

    public abstract Document createDocument();
}
