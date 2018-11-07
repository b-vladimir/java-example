package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends Page{

  public CartPage(WebDriver driver) {
    super(driver);
  }

  public WebElement messageEmptyCart(){
    return driver.findElement(By.cssSelector("#checkout-cart-wrapper > p:nth-child(1) > em"));
  }

  public void open(){
    driver.findElement(By.cssSelector("#cart > a.link")).click();
  }

  public void deleteProduct(){
    driver.findElement(By.name("remove_cart_item")).click();
  }

  public void waitForChangeProductList(int count){
    wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("#order_confirmation-wrapper > table > tbody > tr"), count + 4));
  }
}
