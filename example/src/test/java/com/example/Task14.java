package com.example;

/*
открываются в новом окне
Сделайте сценарий, который проверяет, что ссылки на странице редактирования страны открываются в новом окне.
Сценарий должен состоять из следующих частей:
1) зайти в админку
2) открыть пункт меню Countries (или страницу http://localhost/litecart/admin/?app=countries&doc=countries)
3) открыть на редактирование какую-нибудь страну или начать создание новой
4) возле некоторых полей есть ссылки с иконкой в виде квадратика со стрелкой -- они ведут на внешние страницы и открываются в новом окне, именно это и нужно проверить.
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Set;

public class Task14 extends TestBase{

    @Test
    public void test(){
        driver.navigate().to("http://localhost/litecart/admin");
        autrz();
        driver.findElement(By.cssSelector("#box-apps-menu > li:nth-child(3) > a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/table/tbody/tr[2]/td[7]/a")).click();
        externalLink(driver, By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(2) > td > a"));
        externalLink(driver, By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(3) > td > a"));
        externalLink(driver, By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(6) > td > a"));
        externalLink(driver, By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(7) > td > a:nth-child(3)"));
        externalLink(driver, By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(8) > td > a"));
        externalLink(driver, By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(9) > td > a"));
        externalLink(driver, By.cssSelector("#content > form > table:nth-child(2) > tbody > tr:nth-child(10) > td > a"));
    }

    public void externalLink(WebDriver driver, By location){
        String mainWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();
        driver.findElement(location).click();
        String newWindow = wait.until(thereIsWindowOtherThan(oldWindows));
        driver.switchTo().window(newWindow);
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    public ExpectedCondition<String> thereIsWindowOtherThan(Set<String> oldWindows){
        return new ExpectedCondition<String>() {
            @Override
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next():null;
            }
        };
    }
}
