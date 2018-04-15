package com.example;

import org.junit.Test;

public class Task9_1 extends TestBase{

    @Test
    public void test(){
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries/");
    }

}
