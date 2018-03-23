package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task7 extends TestBase {

    @Test
    public void test1(){
        driver.navigate().to("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("5815");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Appearence')]")).click();
        verify();
        driver.findElement(By.cssSelector("li[id=doc-template]")).click();
        verify();
        driver.findElement(By.cssSelector("li[id=doc-logotype]")).click();
        verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Catalog')]")).click();
        verify();
        driver.findElement(By.cssSelector("li[id=doc-catalog]")).click();
        verify();
        driver.findElement(By.cssSelector("li[id=doc-product_groups]")).click();
        verify();
        driver.findElement(By.cssSelector("li[id=doc-option_groups]")).click();
        verify();
        driver.findElement(By.cssSelector("li[id=doc-manufacturers]")).click();
        verify();
        driver.findElement(By.cssSelector("li[id=doc-suppliers]")).click();
        verify();
        driver.findElement(By.cssSelector("li[id=doc-delivery_statuses]")).click();
        verify();
        driver.findElement(By.cssSelector("li[id=doc-sold_out_statuses]")).click();
        verify();
        driver.findElement(By.cssSelector("li[id=doc-quantity_units]")).click();
        verify();
        driver.findElement(By.cssSelector("li[id=doc-csv]")).click();
        verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Countries')]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Customers')]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-customers]")).click();
        verify();
        driver.findElement(By.cssSelector("li[id=doc-csv]")).click();
        verify();
        driver.findElement(By.cssSelector("li[id=doc-newsletter]")).click();
        verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Geo Zones')]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Languages')]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-languages]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-storage_encoding]")).click(); verify();


        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void verify(){
        Assert.assertEquals(false, driver.getTitle().isEmpty());
        System.out.println("Title is ok");
    }

}
