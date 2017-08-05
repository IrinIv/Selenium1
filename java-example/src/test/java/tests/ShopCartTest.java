package tests;

import org.openqa.selenium.By;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by IrinaIv on 8/3/2017.
 */
public class ShopCartTest extends TestBase {



  @Test
  public void testShopCart() throws InterruptedException {
    app.getSessionHelper().driver.get("http://localhost/litecart/en/");
    addNewItemToCart();
    openCart();
    removeAllItems();
    app.getSessionHelper().driver.navigate().back();
  }

  private void addNewItemToCart() throws InterruptedException {
    List<WebElement> items = app.getSessionHelper().driver.findElements(By.cssSelector(".link > .name"));
    for (int i = 1; i <= 3; i++) {
      WebElement firstitem = app.getSessionHelper().driver.findElement(By.cssSelector("a.link > .image-wrapper > .image[alt$='Duck']"));
      firstitem.click();
      if (isElementPresent(By.cssSelector(".options>select"))) {
        WebElement sizeitem = app.getSessionHelper().driver.findElement(By.cssSelector(".options>select"));
        Select selectsize = new Select(sizeitem);
        selectsize.selectByVisibleText("Small");
      }

      WebDriverWait wait = new WebDriverWait(app.getSessionHelper().driver, 10);
      WebElement quantity = app.getSessionHelper().driver.findElement(By.xpath(".//*[@id='cart']/a[2]/span[1]"));
      app.getSessionHelper().driver.findElement(By.cssSelector(".quantity > button")).click();
      //wait.until(ExpectedConditions.textToBePresentInElement(quantity, (String.format("%s", i))));
      wait.until(ExpectedConditions.attributeToBe(quantity, "cursor", "wait"));
      app.getSessionHelper().driver.navigate().back();

    }
  }

  private void openCart() {
    app.getSessionHelper().driver.findElement(By.cssSelector("#cart > .link")).click();
  }

  private void removeAllItems() {
    WebDriverWait wait = new WebDriverWait(app.getSessionHelper().driver, 10);
    List<WebElement> items = app.getSessionHelper().driver.findElements(By.cssSelector(".item>form>div>p>button[name='remove_cart_item']"));
    for (int i = 0; i < items.size(); i++) {
      List<WebElement> formitems = app.getSessionHelper().driver.findElements(By.cssSelector(".dataTable.rounded-corners>tbody>tr>td.item"));
      WebElement itemontable = app.getSessionHelper().driver.findElement(By.cssSelector(String.format(".dataTable.rounded-corners>tbody>tr>td.item", i)));
      wait.until(visibilityOf(itemontable));
      app.getSessionHelper().driver.findElement(By.cssSelector(".item>form>div>p>button[name='remove_cart_item']")).click();
      wait.until(ExpectedConditions.stalenessOf(itemontable));
    }
  }

  }


