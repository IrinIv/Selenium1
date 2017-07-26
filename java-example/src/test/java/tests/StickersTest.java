package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by IrinaIv on 7/26/2017.
 */
public class StickersTest extends TestBase {

  @Test
  public void testStickersIsPresent() {

    app.getSessionHelper().driver.get("http://localhost/litecart/en/");
    getStickersIsPresent();

  }


}
