package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task8 extends TestBase{

    @Test
    public void test(){
        driver.get("http://localhost/litecart/en/");
        WebElement element = driver.findElement(By.xpath("//html//div[@id='box-most-popular']//li[1]/a[1]"));
        //List<WebElement> myList = element.findElements(By.xpath(".//div[1]/div"));
        Assert.assertEquals(true,
                areElementsPresent(driver, By.xpath("//html//div[@id='box-most-popular']//li[1]/a[1]/div[1]/div")));

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
