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
        List<WebElement> myList;

        myList = driver.findElements(By.xpath("//div[@id='box-most-popular']//li"));
        for (int i =1; i<myList.size()+1;i++) {
            Assert.assertEquals(true,
                    areElementsPresent(driver, By.xpath("//html//div[@id='box-most-popular']//li["+i+"]/a[1]/div[1]/div")));
            System.out.println("Sticker is OK");
        }System.out.println("");

        myList = driver.findElements(By.xpath("//div[@id='box-campaigns']//li"));
        for (int i =1; i<myList.size()+1;i++) {
            Assert.assertEquals(true,
                    areElementsPresent(driver, By.xpath("//html//div[@id='box-most-popular']//li["+i+"]/a[1]/div[1]/div")));
            System.out.println("Sticker is OK");
        }System.out.println("");

        myList = driver.findElements(By.xpath("//div[@id='box-latest-products']//li"));
        for (int i =1; i<myList.size()+1;i++) {
            Assert.assertEquals(true,
                    areElementsPresent(driver, By.xpath("//html//div[@id='box-most-popular']//li["+i+"]/a[1]/div[1]/div")));
            System.out.println("Sticker is OK");
        }System.out.println("");

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
