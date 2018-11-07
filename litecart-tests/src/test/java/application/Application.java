package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.MainPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;

public class Application {

  private WebDriver driver;
  private WebDriverWait wait;

  private CartPage cartPage;
  private MainPage mainPage;
  private ProductPage productPage;

  public Application() {
    this.driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
    this.wait = new WebDriverWait(driver, 4);
    mainPage = new MainPage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);
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

  public void deleteProductsFromCart(int count) {
    cartPage.deleteProduct();
    int x = count;
    if (count > 1) {
      for (int i = 1; i < count; i++) {
        cartPage.waitForChangeProductList(x);
        cartPage.deleteProduct();
        --x;
      }
    }
  }

  public String getTextEmptyCart() {
    return cartPage.messageEmptyCart().getText();
  }

  public void goToCart() {
    cartPage.open();
  }

  public void addProductsToCart(int count) {
    for (int i = 1; i < count + 1; i++) {
      mainPage.open();
      mainPage.goToPopularProduct(i);
      if (isElementPresent(driver, By.cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select"))) {
        Select select =  new Select(driver.findElement(By.cssSelector("#box-product > div.content > div.information > div.buy_now > form > table > tbody > tr:nth-child(1) > td > select")));
        select.selectByIndex(2);
      }
      productPage.addProductToCart();
      productPage.waitChangeProductsCount(i);
    }
  }

  boolean isElementPresent(WebDriver driver, By locator) {//Метод для проверки наличия элемента
    return driver.findElements(locator).size() > 0;
  }

}
