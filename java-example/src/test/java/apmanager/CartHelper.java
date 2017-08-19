package apmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Created by IrinaIv on 8/18/2017.
 */
public class CartHelper
{
  private final EventFiringWebDriver driver;

  public CartHelper(EventFiringWebDriver driver) {
    this.driver = driver;
  }

  public void openCart() {
    driver.findElement(By.cssSelector("#cart > .link")).click();
  }

  public void removeAllItems() {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    List<WebElement> items = driver.findElements(By.cssSelector(".item>form>div>p>button[name='remove_cart_item']"));
    for (int i = 0; i < items.size(); i++) {
      List<WebElement> formitems = driver.findElements(By.cssSelector(".dataTable.rounded-corners>tbody>tr>td.item"));
      WebElement itemontable = driver.findElement(By.cssSelector(String.format(".dataTable.rounded-corners>tbody>tr>td.item", i)));
      wait.until(visibilityOf(itemontable));
      driver.findElement(By.cssSelector(".item>form>div>p>button[name='remove_cart_item']")).click();
      wait.until(ExpectedConditions.stalenessOf(itemontable));
    }
  }

}
