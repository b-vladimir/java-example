package tests;

import application.Application;
import org.junit.After;
import org.junit.Before;

public class TestBase {

  protected final Application app = new Application();

  @Before
  public void start() {
    app.init();
  }

  @After()
  public void tearDown() {
    app.stop();
  }

}
