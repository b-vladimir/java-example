package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class Task10 extends TestBase{

    @Test
    public void test1(){
        driver.navigate().to("http://localhost/litecart/en/");

        String[] priceSt1 ={"rgba(204, 0, 0, 1)", "700", "18px"}; //стили цены со скидкой на главной
        String[] sPriceSt1 ={"rgba(119, 119, 119, 1)", "line-through", "14.4px"}; //стили цены без скидки на главной
        String[] priceSt2 ={"rgba(204, 0, 0, 1)", "700", "22px"}; //стили цены со скидкой на странице товара
        String[] sPriceSt2 ={"rgba(102, 102, 102, 1)", "line-through", "16px"}; //стили цены без скидки на странице товара

        String name1 = driver.findElement(By.cssSelector
                ("#box-campaigns > div > ul > li > a.link > div.name")).getAttribute("textContent");
        String price1 = driver.findElement(By.cssSelector
                ("#box-campaigns > div > ul > li > a.link > div.price-wrapper > s")).getAttribute("textContent");
        String sPrice1 = driver.findElement(By.cssSelector
                ("#box-campaigns > div > ul > li > a.link > div.price-wrapper > strong")).getAttribute("textContent");
        String[] priceSt10 ={driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > strong")).getCssValue("color"),
                driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > strong")).getCssValue("font-weight"),
                driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > strong")).getCssValue("font-size")};
        String[] sPriceSt10 ={driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > s")).getCssValue("color"),
                driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > s")).getCssValue("text-decoration-line"),
                driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link > div.price-wrapper > s")).getCssValue("font-size")};


        driver.findElement(By.cssSelector("#box-campaigns > div > ul > li > a.link")).click();

        String name2 = driver.findElement(By.cssSelector
                ("#box-product > div:nth-child(1) > h1")).getAttribute("textContent");
        String price2 = driver.findElement(By.cssSelector
                ("#box-product > div.content > div.information > div.price-wrapper > s")).getAttribute("textContent");
        String sPrice2 = driver.findElement(By.cssSelector
                ("#box-product > div.content > div.information > div.price-wrapper > strong")).getAttribute("textContent");
        String[] priceSt20 ={driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > strong")).getCssValue("color"),
                driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > strong")).getCssValue("font-weight"),
                driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > strong")).getCssValue("font-size")};
        String[] sPriceSt20 ={driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > s")).getCssValue("color"),
                driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > s")).getCssValue("text-decoration-line"),
                driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.price-wrapper > s")).getCssValue("font-size")};

        check(name1, name2); // сравнение названий товара на главной и странице товара
        check(price1, price2);  // сравнение цен без скидки на главной и странице товара
        check(sPrice1, sPrice2); // сравнение цен со скидкой на главной и странице товара
        check(priceSt1, priceSt10); // сравнение стилей цены со скидкой на главной
        check(priceSt2, priceSt20); // сравнение стилей цены без скидки на главной
        check(sPriceSt1, sPriceSt10); // сравнение стилей цены со скидкой на странице товара
        check(sPriceSt2, sPriceSt20);// сравнение стилей цены без скидки на странице товара

    }

    private void check(String a, String b){
        Assert.assertTrue(a.equals(b));
        System.out.println("Check is OK");
    }

    private void check(String[] a, String[] b){
        Assert.assertTrue(Arrays.equals(a,b));
        System.out.println("Check is OK");
    }

}
