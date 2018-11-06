package com.example;

/*
Сделайте сценарий, который проверяет, не появляются ли в логе браузера сообщения при открытии страниц в учебном приложении, а именно -- страниц товаров в каталоге в административной панели.
Сценарий должен состоять из следующих частей:
1) зайти в админку
2) открыть каталог, категорию, которая содержит товары (страница http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1)
3) последовательно открывать страницы товаров и проверять, не появляются ли в логе браузера сообщения (любого уровня)
*/

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

public class Task17 extends TestBase {

  @Test
  public void test(){
    driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=2");
    autrz();
    List<WebElement> myList = driver.findElements(By.xpath
            ("//tbody/tr[@class='row'][td[1]/input[contains(@name, 'products')]]/td[3]/a"));
    for (int i = 0; i < myList.size(); i++) {
      myList.get(i).click();
      driver.manage().logs().get("browser").forEach(logEntry -> System.out.println(logEntry));
      driver.navigate().back();
      myList = driver.findElements(By.xpath
              ("//tbody/tr[@class='row'][td[1]/input[contains(@name, 'products')]]/td[3]/a"));
    }
    System.out.println("Test is done");
  }
}