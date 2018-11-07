package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page{

  public MainPage(WebDriver driver) {
    super(driver);
  }

  public void open(){
    driver.get("http://localhost/litecart/en/");
  }

  public void goToPopularProduct(int i) {
    driver.findElement(By.cssSelector("#box-most-popular > div > ul > li:nth-child(" + i + ")")).click();
  }
}
