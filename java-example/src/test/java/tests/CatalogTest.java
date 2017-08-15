package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IrinaIv on 8/15/2017.
 */
public class CatalogTest extends TestBase {

  @Test
  public void testCatalog() {

    //login();
    verifyItemPage();
  }

  private void verifyItemPage() {
    app.getSessionHelper().driver.findElement(By.cssSelector("#box-apps-menu > li:nth-child(2)")).click();
    List<WebElement> allelements = app.getSessionHelper().driver.findElements(By.cssSelector(".dataTable > tbody > tr"));
    for (int i = 4; i < allelements.size(); i++ ) {
      List<WebElement> names = app.getSessionHelper().driver.findElements(By.cssSelector(String.format("#content > form > table > tbody > tr:nth-child(%s)", i)));
      WebElement name1 = app.getSessionHelper().driver.findElement(By.cssSelector(String.format("#content > form > table > tbody > tr:nth-child(%s) > td:nth-child(3) > a", i)));
      name1.click();
      System.out.println(app.getSessionHelper().driver.manage().logs().getAvailableLogTypes());
      app.getSessionHelper().driver.manage().logs().get("browser").forEach(l -> System.out.println(l));
      List logs = app.getSessionHelper().driver.manage().logs().get("browser").getAll();
      //List logs = app.getSessionHelper().driver.manage().logs().get("performance").getAll();
      Assert.assertTrue(logs.isEmpty());
      app.getSessionHelper().driver.navigate().back();

    }
  }
}
