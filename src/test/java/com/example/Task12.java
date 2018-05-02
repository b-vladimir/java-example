package com.example;

/*
Сделайте сценарий для добавления нового товара (продукта) в учебном приложении litecart (в админке).
Для добавления товара нужно открыть меню Catalog, в правом верхнем углу нажать кнопку "Add New Product", заполнить поля с информацией о товаре и сохранить.
Достаточно заполнить только информацию на вкладках General, Information и Prices. Скидки (Campains) на вкладке Prices можно не добавлять.
После сохранения товара нужно убедиться, что он появился в каталоге (в админке). Клиентскую часть магазина можно не проверять.
 */

import org.junit.Test;
import org.openqa.selenium.By;

public class Task12 extends TestBase {
    private String[] product = {"TestName", "3"};

    @Test
    public void test12(){
        driver.navigate().to("http://localhost/litecart/admin");
        autrz();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Catalog')]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a[2]")).click();
        driver.findElement(By.name("name[en]")).sendKeys(product[0]);
        driver.findElement(By.cssSelector("input[type=\"checkbox\"][value=\"3\"]")).click();
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys(product[1]);

        driver.findElement(By.xpath("//li/a[contains(text(),'Information')]")).click();

    }

}
