package com.example;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;
    public Select select;//переменная для работы с выпадающим меню

    public static class MyListener extends AbstractWebDriverEventListener{
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by + " found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println(throwable);
        }
    }

    @Before
    public  void start(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 4);
    }

    @After()
    public void stop(){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
        driver = null;
    }

    boolean areElementsPresent(WebDriver driver, By locator) {//метод для проверки того что имеется 1 элемент
        System.out.println("Check the sticker");
        return driver.findElements(locator).size() == 1;
    }

    boolean isElementPresent(WebDriver driver, By locator){//Метод для проверки наличия элемента
        return driver.findElements(locator).size() >0;
    }

    //метод для авторизации в админке
    public void autrz(){
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    //метод для работы в выпадающим меню
    public Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }
}
