package apmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by IrinaIv on 8/18/2017.
 */
public class ShopingHelper {

  public EventFiringWebDriver driver;

  public ShopingHelper(EventFiringWebDriver driver) {
    this.driver = driver;
  }

  public void goToStoryPage() {
    driver.get("http://localhost/litecart/en/");
  }

  public void addNewItemToCart() throws InterruptedException {
    List<WebElement> items = driver.findElements(By.cssSelector(".link > .name"));
    for (int i = 1; i <= 3; i++) {
      WebElement firstitem = driver.findElement(By.cssSelector("a.link > .image-wrapper > .image[alt$='Duck']"));
      firstitem.click();
      if (isElementPresent(By.cssSelector(".options>select"))) {
        WebElement sizeitem = driver.findElement(By.cssSelector(".options>select"));
        Select selectsize = new Select(sizeitem);
        selectsize.selectByVisibleText("Small");
      }

      WebDriverWait wait = new WebDriverWait(driver, 10);
      WebElement quantity = driver.findElement(By.xpath(".//*[@id='cart']/a[2]/span[1]"));
      driver.findElement(By.cssSelector(".quantity > button")).click();
      //wait.until(ExpectedConditions.textToBePresentInElement(quantity, (String.format("%s", i))));
      wait.until(ExpectedConditions.attributeToBe(quantity, "cursor", "wait"));
      driver.navigate().back();

    }
  }

  public boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }


}
