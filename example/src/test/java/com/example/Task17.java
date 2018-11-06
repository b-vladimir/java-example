package com.example;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task17 extends TestBase {

    @Test
    public void test(){
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=2");
        autrz();
        List<WebElement> myList = driver.findElements(By.xpath
                ("//tbody/tr[@class='row'][td[1]/input[contains(@name, 'products')]]"));
        System.out.println("Breakpoint");
    }
}
