package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends  Page{

  public ProductPage(WebDriver driver) {
    super(driver);
  }

  public void addProductToCart() {
    driver.findElement(By.name("add_cart_product")).click();
  }

  public void waitChangeProductsCount(int i) {
    wait.until(ExpectedConditions.attributeToBe(By.cssSelector("span.quantity"), "textContent", "" + i + ""));
  }
}
