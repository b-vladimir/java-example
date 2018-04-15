package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task9_1 extends TestBase{

    @Test
    public void test1(){
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        autrz();

        List<WebElement> myList = driver.findElements(By.xpath("//tbody/tr[@class='row']"));
        checkSort(myList);

    }

    @Test
    public void test2(){
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        autrz();

        List<WebElement> myList = driver.findElements(By.xpath("//tbody/tr[@class='row'][td[6]!=0]"));
        for (WebElement x: myList){
            x.findElement(By.xpath(".//td/a")).click();
            List<WebElement> list2 = driver.findElements(By.xpath("//html//tr/td[@style=\"\"]"));
            driver.navigate().back();
        }

        System.out.println("Breakpoint");
    }

    private void checkSort(List<WebElement> list){
        List<String> country = new ArrayList<>();
        List<String> countrySort = new ArrayList<>();
        for (WebElement i: list){
            String txt = i.findElement(By.cssSelector("td a")).getText();
            country.add(txt);
            countrySort.add(txt);
        }
        Collections.sort(countrySort);
        Assert.assertTrue(country.equals(countrySort));
    }

}
