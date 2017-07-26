package tests;

import apmanager.AppManager;
import model.Titles;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

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


//  public List<Titles> getTitleList() {
//    List<Titles> titles = new ArrayList<Titles>();
//    List<WebElement> elements = app.getSessionHelper().driver.findElements(By.xpath("//ul[@id='box-apps-menu']"));
//    for (WebElement element : elements) {
//      WebElement name = element.findElement(By.xpath(".//*[@class='name']"));
//      name.click();
//      String title = goToRightPage().findElement(By.tagName("h1")).getText();
//      System.out.println(title);
//      Titles titl = new Titles(title);
//      titles.add(titl);
//    }
//      return titles;

//  }
}
