package com.mabellou.patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class MotoRegistry {
    Map<String, Moto> motoMap = new HashMap<>();

    public void addMotoToRegistry(String id, Moto moto){
        this.motoMap.put(id, moto);
    }

    public Moto getMotoById(String id){
        Moto moto = this.motoMap.get(id);
        return moto.clone();
    }
}
