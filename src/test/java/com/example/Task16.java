package com.example;

/*
Установите виртуальную машину, внутри которой работает Windows, и создайте грид, который состоит из диспетчера, работающего на вашей основной машине, и двух узлов -- один тоже на основной машине, а другой внутри виртуальной машины.
Настройте узлы так, чтобы в виртуальной машине был доступен браузер Internet Explorer, а на основной машине, наоборот, он был недоступен.
Попробуйте запустить какие-нибудь тесты удалённо на этом гриде, указывая разные браузеры, и убедитесь, что Internet Explorer действительно запускается внутри виртуальной машины, а другие браузеры, наоборот, на вашей основной машине.
*/

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Task16 {

    public WebDriver driver;
    public WebDriverWait wait;
    public Select select;//переменная для работы с выпадающим меню

    @Before
    public  void start() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"), DesiredCapabilities.internetExplorer());;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
    }

    @Test
    public void myFirstTest(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.xpath("//html//span[1]/span[1]/input[1]")).click();
        wait.until(titleIs("webdriver - Пошук Google"));
        Assert.assertEquals(false, driver.getTitle().isEmpty());
    }

    @After
    public void stop(){
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
        driver = null;
    }

}
