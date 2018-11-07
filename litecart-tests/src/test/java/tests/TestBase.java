package tests;

import application.Application;
import org.junit.After;
import org.junit.Before;

public class TestBase {

  Application app;

  @Before
  public void start() {
    app = new Application();
  }

  @After()
  public void tearDown() {
    app.stop();
  }

}
