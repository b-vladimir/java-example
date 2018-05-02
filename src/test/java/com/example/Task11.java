package com.example;

/*
Сделайте сценарий для регистрации нового пользователя в учебном приложении litecart (не в админке, а в клиентской части магазина).
Сценарий должен состоять из следующих частей:
1) регистрация новой учётной записи с достаточно уникальным адресом электронной почты (чтобы не конфликтовало с ранее созданными пользователями),
2) выход (logout), потому что после успешной регистрации автоматически происходит вход,
3) повторный вход в только что созданную учётную запись,
4) и ещё раз выход
 */

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task11 extends TestBase{
    private String [] user = {"test5", "12345", "awerbnmf@dfg.sdf", "1234567890", "123", "Bolivia"};

    @Test
    public void test(){
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("#box-account-login > div > form > table > tbody > tr:nth-child(5) > td > a")).click();

        driver.findElement(By.cssSelector("#create-account > div > form > table > tbody > tr:nth-child(2) > td:nth-child(1) > input[type=\"text\"]")).sendKeys("a");
        driver.findElement(By.cssSelector("tr > td> input[name=lastname]")).sendKeys(user[0]);
        driver.findElement(By.cssSelector("tr > td> input[name=address1]")).sendKeys(user[0]);
        driver.findElement(By.cssSelector("tr > td> input[name=postcode]")).sendKeys(user[1]);
        driver.findElement(By.cssSelector("tr > td> input[name=city]")).sendKeys(user[0]);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"create-account\"]/div/form/table/tbody/tr[5]/td[1]/select"));
        getSelect(element);
        select.selectByVisibleText(user[5]);
        driver.findElement(By.cssSelector("tr > td> input[name=email]")).sendKeys(user[2]);
        driver.findElement(By.cssSelector("tr > td> input[name=phone]")).sendKeys(user[3]);
        driver.findElement(By.cssSelector("tr > td> input[name=password]")).sendKeys(user[4]);
        driver.findElement(By.cssSelector("tr > td> input[name=confirmed_password]")).sendKeys(user[4]);
        driver.findElement(By.cssSelector("#create-account > div > form > table > tbody > tr:nth-child(10) > td > button")).click();

        driver.findElement(By.cssSelector("#box-account > div > ul > li:nth-child(4) > a")).click();
        driver.findElement(By.xpath("//*[@id=\"box-account-login\"]/div/form/table/tbody/tr[1]/td/input")).sendKeys(user[2]);
        driver.findElement(By.xpath("//*[@id=\"box-account-login\"]/div/form/table/tbody/tr[2]/td/input")).sendKeys(user[4]);
        driver.findElement(By.xpath("//*[@id=\"box-account-login\"]/div/form/table/tbody/tr[4]/td/span/button[1]")).click();
        driver.findElement(By.cssSelector("#box-account > div > ul > li:nth-child(4) > a")).click();

        String check = driver.findElement(By.cssSelector("#notices > div")).getText();
        System.out.println(check);
        Assert.assertTrue(check.equals("You are now logged out."));
    }


}
