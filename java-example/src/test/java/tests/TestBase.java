package tests;

import apmanager.AppManager;
import model.Titles;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by IrinaIv on 7/20/2017.
 */
public class TestBase {
  protected final AppManager app = new AppManager(BrowserType.CHROME);
  private WebDriver driver;

  @BeforeMethod
  public void setUp() {
    app.init();
  }


  public boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }


  @AfterMethod
  public void tearDown() {
    app.stop();
  }

  protected WebElement goToRightPage() {
    return app.getSessionHelper().driver.findElement(By.cssSelector("tr:nth-child(n) > td:nth-child(3)"));
  }

  protected WebElement getWebElementBox() {
    return app.getSessionHelper().driver.findElement(By.xpath("//ul[@id='box-apps-menu']"));
  }

  protected void login() {
    app.getSessionHelper().driver.get("http://localhost/litecart/admin/login.php");
    app.getSessionHelper().driver.findElement(By.name("username")).sendKeys("admin");
    app.getSessionHelper().driver.findElement(By.name("username")).click();
    app.getSessionHelper().driver.findElement(By.name("password")).sendKeys("admin");
    app.getSessionHelper().driver.findElement(By.name("login")).click();
  }

  protected String getH1() {
    return goToRightPage().findElement(By.tagName("h1")).getText();
  }


  protected void getTitleListIsPresent() {
    List<WebElement> menuItems = app.getSessionHelper().driver.findElements(By.id("app-"));
    for (int i = 1; i <= menuItems.size(); i++) {
      WebElement item = app.getSessionHelper().driver.findElement(By.cssSelector(String.format("#box-apps-menu > li:nth-child(%s)", i)));
      item.click();
      app.getSessionHelper().driver.findElement(By.cssSelector("#content h1"));
      List<WebElement> innerItems = app.getSessionHelper().driver.findElements(By.cssSelector(".docs > li"));
      if (innerItems.size() > 0) {
        for (int j = 1; j <= innerItems.size(); j++) {
          WebElement innerItem = app.getSessionHelper().driver.findElement(By.cssSelector(String.format(".docs > li:nth-child(%s)", j)));
          innerItem.click();
          app.getSessionHelper().driver.findElement(By.cssSelector("#content h1"));
        }
      }
    }
  }


  protected void getStickersIsPresent() {
    List<WebElement> elements = app.getSessionHelper().driver.findElements(By.xpath("//div[@class='image-wrapper']"));
    for (WebElement element : elements) {

      List<WebElement> stickers = element.findElements(By.xpath(".//div[starts-with(@class,'sticker')]"));
      WebElement name = element.findElement(By.xpath(".//div[starts-with(@class,'sticker')]"));
      Assert.assertEquals(1, stickers.size());
      System.out.println(name.getText());
    }
  }


}
