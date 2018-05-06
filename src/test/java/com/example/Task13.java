package com.example;

/*
Сделайте сценарий для добавления товаров в корзину и удаления товаров из корзины.
Сценарий должен состоять из следующих частей:
1) открыть страницу какого-нибудь товара
2) добавить его в корзину
3) подождать, пока счётчик товаров в корзине обновится
4) вернуться на главную страницу, повторить предыдущие шаги ещё два раза, чтобы в общей сложности в корзине было 3 единицы товара
5) открыть корзину (в правом верхнем углу кликнуть по ссылке Checkout)
6) удалить все товары из корзины один за другим, после каждого удаления подождать, пока внизу обновится таблица
*/

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Task13 extends TestBase {

    @Test
    public void test(){
        for (int i =1; i<4; i++) {
            driver.get("http://localhost/litecart/en/");
            driver.findElement(By.cssSelector("#box-most-popular > div > ul > li:nth-child("+i+")")).click();
            if (isElementPresent(driver, By.cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select"))){
                WebElement kind = driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select"));
                getSelect(kind);
                select.selectByIndex(2);
            }
            driver.findElement(By.name("add_cart_product")).click();
            wait.until(ExpectedConditions.attributeToBe(By.cssSelector("span.quantity"), "textContent", ""+i+""));
        }
        driver.findElement(By.cssSelector("#cart > a.link")).click();

        driver.findElement(By.name("remove_cart_item")).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#order_confirmation-wrapper > table > tbody > tr"), 7));
        driver.findElement(By.name("remove_cart_item")).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#order_confirmation-wrapper > table > tbody > tr"), 6));
        driver.findElement(By.name("remove_cart_item")).click();

        String check = driver.findElement(By.cssSelector("#checkout-cart-wrapper > p:nth-child(1) > em")).getText();
        System.out.println(check);
        Assert.assertTrue(check.equals("There are no items in your cart."));

    }
}
