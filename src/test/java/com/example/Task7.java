package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task7 extends TestBase {

    @Test
    public void test1(){
        driver.navigate().to("http://localhost/litecart/admin");
        autrz();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Appearence')]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-template]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-logotype]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Catalog')]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-catalog]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-product_groups]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-option_groups]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-manufacturers]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-suppliers]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-delivery_statuses]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-sold_out_statuses]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-quantity_units]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-csv]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Countries')]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Customers')]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-customers]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-csv]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-newsletter]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Geo Zones')]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Languages')]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-languages]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-storage_encoding]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Modules')]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-jobs]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-customer]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-shipping]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-payment]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-order_total]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-order_success]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-order_action]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Orders')]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-orders]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-order_statuses]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Pages')]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Reports')]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-monthly_sales]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-most_sold_products]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-most_shopping_customers]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Settings')]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-store_info]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-defaults]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-general]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-listings]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-images]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-checkout]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-advanced]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-security]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Slides')]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Tax')]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-tax_classes]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-tax_rates]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Translations')]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-search]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-scan]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-csv]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'Users')]")).click(); verify();

        driver.findElement(By.xpath("//span[@class='name'][contains(text(),'vQmods')]")).click(); verify();
        driver.findElement(By.cssSelector("li[id=doc-vqmods]")).click(); verify();

    }

    public void verify(){
        Assert.assertEquals(false, driver.getTitle().isEmpty());
        System.out.println("Title is ok");
    }

}
