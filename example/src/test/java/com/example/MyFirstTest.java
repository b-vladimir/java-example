package com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest extends TestBase{


    @Test
    public void myFirstTest(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.xpath("//html//span[1]/span[1]/input[1]")).click();
        wait.until(titleIs("webdriver - Пошук Google"));
//        if(driver.getTitle().isEmpty()){
//            System.out.println("Title is empty");
//        }else {
//            System.out.println("All is OK");
//        }
        Assert.assertEquals(false, driver.getTitle().isEmpty());
    }


}
