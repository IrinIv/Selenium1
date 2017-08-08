package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by IrinaIv on 8/7/2017.
 */
public class LinksCountriesTest extends TestBase {

  @Test
  public void testLinksCountries() throws InterruptedException {

    login();
    goToCountriesPage();
    goToEditPage();

  }

  public void verifyAllLInks() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(app.getSessionHelper().driver, 10);
    List<WebElement> links = app.getSessionHelper().driver.findElements(By.cssSelector(".fa.fa-external-link"));
    String originalWindow = app.getSessionHelper().driver.getWindowHandle();
    Set<String> existingWindows = app.getSessionHelper().driver.getWindowHandles();

    for (int i = 2; i <= 10; i++) {

      if (i == 4 || i == 5){
        continue;
      }

      WebElement link = app.getSessionHelper().driver.findElement(By.cssSelector(String.format("#content > form > table:nth-child(2) > tbody > tr:nth-child(%s) > td > a > i", i)));
      link.click();

      String newWindow = wait.until(thereIsWindowOtherThen(existingWindows));
      app.getSessionHelper().driver.switchTo().window(newWindow);
      Thread.sleep(2000);

      app.getSessionHelper().driver.close();
      app.getSessionHelper().driver.switchTo().window(originalWindow);

    }
  }

  public ExpectedCondition<String> thereIsWindowOtherThen(Set<String> existingWindows) {
    return new ExpectedCondition<String>() {
      public String apply(WebDriver driver) {
        Set<String> handles = app.getSessionHelper().driver.getWindowHandles();
        handles.removeAll(existingWindows);
        return handles.size() > 0 ? handles.iterator().next() : null;
      }
    };
  }

  public void goToEditPage() throws InterruptedException {
    List<WebElement> countries = app.getSessionHelper().driver.findElements(By.cssSelector(".dataTable > tbody > tr"));
    for (int i = 2; i < 3; i++) {

      List<WebElement> countr = app.getSessionHelper().driver.findElements(By.xpath(String.format("//*[@id='content']/form/table/tbody/tr[%s]", i)));
      WebElement z = app.getSessionHelper().driver.findElement(By.xpath(String.format("//*[@id='content']/form/table/tbody/tr[%s]", i)));
      List<WebElement> edit = app.getSessionHelper().driver.findElements(By.xpath(String.format(".//*[@id='content']/form/table/tbody/tr[%s]/td[7]/a/i", i)));
      WebElement zone = app.getSessionHelper().driver.findElement(By.xpath(String.format(".//*[@id='content']/form/table/tbody/tr[%s]/td[7]/a/i", i)));
      zone.click();
      verifyAllLInks();
      app.getSessionHelper().driver.navigate().back();
    }
  }
}
