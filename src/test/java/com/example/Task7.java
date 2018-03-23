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
        List<WebElement> myList = driver.findElements(By.xpath("//span[@class='name']"));

        for (int i =0; i<myList.size(); i++){
            //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[class=name]")));
            myList.get(i).click();
            Assert.assertEquals(false, driver.getTitle().isEmpty());
        }

        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
