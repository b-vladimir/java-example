package com.example;

/*
Сделайте сценарий для регистрации нового пользователя в учебном приложении litecart (не в админке, а в клиентской части магазина).
Сценарий должен состоять из следующих частей:
1) регистрация новой учётной записи с достаточно уникальным адресом электронной почты (чтобы не конфликтовало с ранее созданными пользователями),
2) выход (logout), потому что после успешной регистрации автоматически происходит вход,
3) повторный вход в только что созданную учётную запись,
4) и ещё раз выход
 */

import org.junit.Test;
import org.openqa.selenium.By;

public class Task11 extends TestBase{

    @Test
    public void test(){
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("#box-account-login > div > form > table > tbody > tr:nth-child(5) > td > a")).click();
        

    }

}
