package com.mabellou.patterns.creational.builder;

import org.junit.Test;

public class ClientTest {

    @Test
    public void builderClientTest(){
        Client client = new Client();
        HarleyMoto harleyMoto = client.makeHarley();
    }

}
