package com.example;

/*
Сделайте сценарий для добавления нового товара (продукта) в учебном приложении litecart (в админке).
Для добавления товара нужно открыть меню Catalog, в правом верхнем углу нажать кнопку "Add New Product", заполнить поля с информацией о товаре и сохранить.
Достаточно заполнить только информацию на вкладках General, Information и Prices. Скидки (Campains) на вкладке Prices можно не добавлять.
После сохранения товара нужно убедиться, что он появился в каталоге (в админке). Клиентскую часть магазина можно не проверять.
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;

public class Task12 extends TestBase {
    private String[] product = {"TestName", "3", "Test short description", " Test description"};

    @Test
    public void test12(){
        driver.navigate().to("http://localhost/litecart/admin");
        autrz();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Catalog')]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a[2]")).click();
        driver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(1) > td > label:nth-child(3) > input[type=\"radio\"]")).click();
        driver.findElement(By.name("name[en]")).sendKeys(product[0]);
        driver.findElement(By.cssSelector("input[type=\"checkbox\"][value=\"3\"]")).click();
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys(product[1]);
        File file = new File("D:/GoogleDrive/Всякое/icon.jpg");
        WebElement upload = driver.findElement(By.cssSelector("#tab-general > table > tbody > tr:nth-child(9) > td > table > tbody > tr:nth-child(1) > td > input[type=\"file\"]"));
        upload.sendKeys(file.getAbsolutePath());

        driver.findElement(By.xpath("//li/a[contains(text(),'Information')]")).click();
        WebElement manufacture = driver.findElement(By.xpath("//*[@id=\"tab-information\"]/table/tbody/tr[1]/td/select"));
        getSelect(manufacture);
        select.selectByIndex(1);
        driver.findElement(By.name("short_description[en]")).sendKeys(product[2]);
        driver.findElement(By.cssSelector("#tab-information > table > tbody > tr:nth-child(5) > td > span > div > div.trumbowyg-editor"))
                .sendKeys(product[3]);

        driver.findElement(By.xpath("//li/a[contains(text(),'Prices')]")).click();
        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys(product[1]);
        WebElement price = driver.findElement(By.xpath("//*[@id=\"tab-prices\"]/table[1]/tbody/tr/td/select"));
        getSelect(price);
        select.selectByIndex(1);

        driver.findElement(By.name("save")).click();

        driver.findElement(By.cssSelector("tr > td > a[contains(text(), "+product[0]+")]")).click();
    }

}
