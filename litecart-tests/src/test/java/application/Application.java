package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Application {

  private WebDriver driver;
  private WebDriverWait wait;

  public void deleteProductsFromCart(int count) {
    driver.findElement(By.name("remove_cart_item")).click();
    int x = count;
    if (count > 1) {
      for (int i = 1; i < count; i++) {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#order_confirmation-wrapper > table > tbody > tr"), x + 4));
        driver.findElement(By.name("remove_cart_item")).click();
        --x;
      }
    }
  }

  public String getTextEmptyCart() {
    return driver.findElement(By.cssSelector("#checkout-cart-wrapper > p:nth-child(1) > em")).getText();
  }

  public void goToCart() {
    driver.findElement(By.cssSelector("#cart > a.link")).click();
  }

  public void addProductsToCart(int count) {
    for (int i = 1; i < count + 1; i++) {
      driver.get("http://localhost/litecart/en/");
      driver.findElement(By.cssSelector("#box-most-popular > div > ul > li:nth-child(" + i + ")")).click();
      if (isElementPresent(driver, By.cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select"))) {
        Select select =  new Select(driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select")));
        select.selectByIndex(2);
      }
      driver.findElement(By.name("add_cart_product")).click();
      wait.until(ExpectedConditions.attributeToBe(By.cssSelector("span.quantity"), "textContent", "" + i + ""));
    }
  }

  public void init() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 4);
  }

  public void stop() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.quit();
    driver = null;
  }

  boolean isElementPresent(WebDriver driver, By locator) {//Метод для проверки наличия элемента
    return driver.findElements(locator).size() > 0;
  }

}
