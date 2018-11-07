package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
  protected WebDriver driver;
  protected Wait wait;

  public Page(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, 4);
  }
}
