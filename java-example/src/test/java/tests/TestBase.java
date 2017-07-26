package tests;

import apmanager.AppManager;
import model.Titles;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
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
    List<WebElement> elements = app.getSessionHelper().driver.findElements(By.xpath("//ul[@id='box-apps-menu']"));
    for (WebElement element : elements) {

      WebElement point = element.findElement(By.xpath(String.format(".//li[@id='app-']//*[@class='name']")));
      point.click();
      app.getSessionHelper().driver.navigate().refresh();
      //WebElement item = point.findElement(By.xpath(".//*[@class='name']"));
      //item.click();
      //WebElement name = point.findElement(By.xpath(String.format(".//*[contains(text(), \'%s\')]", element.getText())));
      //name.click();

      String Title = goToRightPage().findElement(By.tagName("h1")).getText();
      System.out.println(Title);
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
