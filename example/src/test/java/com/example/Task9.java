package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Сделайте сценарии, которые проверяют сортировку стран и геозон (штатов) в учебном приложении litecart.
1) на странице http://localhost/litecart/admin/?app=countries&doc=countries
а) проверить, что страны расположены в алфавитном порядке
б) для тех стран, у которых количество зон отлично от нуля -- открыть страницу этой страны и там проверить, что зоны расположены в алфавитном порядке
2) на странице http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones
зайти в каждую из стран и проверить, что зоны расположены в алфавитном порядке
 */

public class Task9 extends TestBase{

    @Test
    public void test1(){
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        autrz();

        List<WebElement> myList = driver.findElements(By.xpath("//tbody/tr[@class='row']"));
        checkSort(myList);
        System.out.println("OK");
    }

    @Test
    public void test2(){
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        autrz();

        List<WebElement> myList = driver.findElements(By.xpath("//tbody/tr[@class='row'][td[6]!=0]"));
        for (int k =0;k<myList.size(); k++){
            myList = driver.findElements(By.xpath("//tbody/tr[@class='row'][td[6]!=0]"));
            myList.get(k).findElement(By.xpath(".//td/a")).click();
            List<WebElement> list2 = driver.findElements(By.xpath("//html//tr/td[3]"));
            List<String> zone = new ArrayList<>();
            for (int i =1; i<list2.size()-1; i++){
                String txt = list2.get(i).getText();
                zone.add(txt);
            }
            checkSort2(zone);
            System.out.println("OK");
            driver.navigate().back();
        }
    }

    @Test
    public void test3(){
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        autrz();

        List<WebElement> myList = driver.findElements(By.xpath("//tr/td[3]"));
        for (int k =1;k<myList.size(); k++){
            myList = driver.findElements(By.xpath("//tr/td[3]"));
            myList.get(k).findElement(By.xpath(".//a")).click();
            List<WebElement> list2 = driver.findElements(By.xpath("//tr/td[3]/select/option[@selected=\"selected\"]"));
            List<String> zone = new ArrayList<>();
            for (int i =0; i<list2.size(); i++){
                String txt = list2.get(i).getText();
                zone.add(txt);
            }
            checkSort2(zone);
            System.out.println("OK");
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

    private void checkSort2(List<String> list){
        List<String> countrySort = new ArrayList<>(list);
        Collections.sort(countrySort);
        Assert.assertTrue(list.equals(countrySort));
    }

}
