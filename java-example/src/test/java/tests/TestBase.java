package tests;

import apmanager.AppManager;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IrinaIv on 7/20/2017.
 */
public class TestBase {
  protected final AppManager app = new AppManager(BrowserType.CHROME);
  protected WebDriver driver;



  @BeforeMethod
  public void setUp() {
    app.init();
  }


  public boolean isElementPresent(By locator) {
    try {
      app.getSessionHelper().driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }



  @AfterMethod
  public void tearDown() {
    app.stop();
  }


  protected void login() {
    app.getSessionHelper().driver.get("http://localhost/litecart/admin/login.php");
    app.getSessionHelper().driver.findElement(By.name("username")).sendKeys("admin");
    app.getSessionHelper().driver.findElement(By.name("username")).click();
    app.getSessionHelper().driver.findElement(By.name("password")).sendKeys("admin");
    app.getSessionHelper().driver.findElement(By.name("login")).click();
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


  protected void goToCountriesPage() {
    app.getSessionHelper().driver.findElement(By.cssSelector("#box-apps-menu > li:nth-child(3)")).click();
  }

  protected void getCountriesList() {
    List<WebElement> countries = app.getSessionHelper().driver.findElements(By.cssSelector("tr.row"));
    for (WebElement element : countries) {
      List<WebElement> names = element.findElements(By.cssSelector(".row > td > a"));
      WebElement name1 = element.findElement(By.cssSelector(".row > td > a"));
      List<String> oldNames = new ArrayList<String>();
      oldNames.add(name1.getText());
      WebElement name2 = element.findElement(By.cssSelector(".row > td > a"));
      List<String> sortedNames = new ArrayList<String>();
      sortedNames.add(name2.getText());
      Collections.sort(sortedNames, String.CASE_INSENSITIVE_ORDER);

      Assert.assertEquals(oldNames, sortedNames);

    }
  }

  protected void goToGeoZones() {
    List<WebElement> countries = app.getSessionHelper().driver.findElements(By.cssSelector(".dataTable > tbody > tr"));
    for (int i = 2; i < countries.size(); i++) {

      List<WebElement> countr = app.getSessionHelper().driver.findElements(By.xpath(String.format("//*[@id='content']/form/table/tbody/tr[%s]", i)));
      WebElement z = app.getSessionHelper().driver.findElement(By.xpath(String.format("//*[@id='content']/form/table/tbody/tr[%s]", i)));
      List<WebElement> edit = app.getSessionHelper().driver.findElements(By.xpath(String.format(".//*[@id='content']/form/table/tbody/tr[%s]/td[5]/a/i", i)));
      WebElement zone = app.getSessionHelper().driver.findElement(By.xpath(String.format(".//*[@id='content']/form/table/tbody/tr[%s]/td[5]/a/i", i)));
      zone.click();
      List<WebElement> innerzones = app.getSessionHelper().driver.findElements(By.cssSelector("#table-zones > tbody > tr"));

      for (int j = 2; j < innerzones.size(); j++) {

        List<WebElement> inzon = app.getSessionHelper().driver.findElements(By.cssSelector("[name^=zones]"));
        WebElement inzon1 = app.getSessionHelper().driver.findElement(By.cssSelector("[name^=zones]"));
        List<String> oldInZones = new ArrayList<String>();
        oldInZones.add(inzon1.getText());
        WebElement inzon2 = app.getSessionHelper().driver.findElement(By.cssSelector("[name^=zones]"));
        List<String> sortedInZones = new ArrayList<String>();
        sortedInZones.add(inzon2.getText());
        Collections.sort(sortedInZones, String.CASE_INSENSITIVE_ORDER);

        Assert.assertEquals(oldInZones, sortedInZones);

      }
      app.getSessionHelper().driver.navigate().back();
    }

  }

  protected void goToGeoZonesPage() {
    app.getSessionHelper().driver.findElement(By.cssSelector("#box-apps-menu > li:nth-child(6)")).click();

  }

  protected void verifyCountOfZons() {
    List<WebElement> zones = app.getSessionHelper().driver.findElements(By.cssSelector(".dataTable > tbody > tr"));
    for (int i = 2; i < zones.size(); i++) {
      List<WebElement> names = app.getSessionHelper().driver.findElements(By.xpath(String.format("//*[@id='content']/form/table/tbody/tr[%s]", i)));
      List<WebElement> zon = app.getSessionHelper().driver.findElements(By.xpath(String.format("//*[@id='content']/form/table/tbody/tr[%s]/td[6]", i)));
      WebElement z = app.getSessionHelper().driver.findElement(By.xpath(String.format("//*[@id='content']/form/table/tbody/tr[%s]/td[6]", i)));
      z.getText();
      if (!z.getText().equals("0")) {
        List<WebElement> edit = app.getSessionHelper().driver.findElements(By.xpath(String.format(".//*[@id='content']/form/table/tbody/tr[%s]/td[7]/a/i", i)));
        WebElement zone = app.getSessionHelper().driver.findElement(By.xpath(String.format(".//*[@id='content']/form/table/tbody/tr[%s]/td[7]/a/i", i)));
        zone.click();
        List<WebElement> innerzones = app.getSessionHelper().driver.findElements(By.cssSelector("#table-zones > tbody > tr"));

        for (int j = 2; j < innerzones.size(); j++) {

          List<WebElement> inzon = app.getSessionHelper().driver.findElements(By.cssSelector(String.format("#table-zones > tbody > tr:nth-child(%s)", j)));
          WebElement inzon1 = app.getSessionHelper().driver.findElement(By.cssSelector(String.format("#table-zones > tbody > tr:nth-child(%s)", j)));
          List<String> oldInZones = new ArrayList<String>();
          oldInZones.add(inzon1.getText());
          WebElement inzon2 = app.getSessionHelper().driver.findElement(By.cssSelector(String.format("#table-zones > tbody > tr:nth-child(%s)", j)));
          List<String> sortedInZones = new ArrayList<String>();
          sortedInZones.add(inzon2.getText());
          Collections.sort(sortedInZones, String.CASE_INSENSITIVE_ORDER);

          Assert.assertEquals(oldInZones, sortedInZones);

        }
        app.getSessionHelper().driver.navigate().back();

      }
    }
  }

  public boolean isAlertPresent() {
    try {
      app.getSessionHelper().driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void closeAlert() {

    app.getSessionHelper().driver.switchTo().alert().accept();
  }
}

