package com.example;

/*
Установите какой-нибудь прокси-сервер, который умеет протоколировать запросы и ответы
Инициализируйте драйвер так, чтобы запросы из браузера отправлялись через этот прокси-сервер, убедитесь, что они там видны
*/

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Task18 {

  public WebDriver driver;
  public WebDriverWait wait;
  public Proxy proxy;

  @Before
  public  void start(){
    proxy = new Proxy();
    proxy.setHttpProxy("192.168.22.173:8888");
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(CapabilityType.PROXY, proxy);
    driver = new ChromeDriver(caps);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 30);
  }

  @Test
  public void test(){
    driver.get("https://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.xpath("//html//span[1]/span[1]/input[1]")).click();
    wait.until(titleIs("webdriver - Пошук Google"));
    Assert.assertEquals(false, driver.getTitle().isEmpty());
  }

  @After
  public void stop(){
    driver.quit();
    driver = null;
  }

}