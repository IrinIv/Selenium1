package tests;

import org.openqa.selenium.By;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by IrinaIv on 8/3/2017.
 */
public class ShopCartTest extends TestBase {


  @Test
  public void testShopCart() throws InterruptedException {

    app.getSessionHelper().driver.get("http://localhost/litecart/en/");
    for(int i = 0; i < 3; i++) {
      addNewItemToCart();
      app.getSessionHelper().driver.navigate().back();
    }
    openCart();
    for(int i = 0; i < 3; i++) {
      removeAllItems();
    }

  }

  private void removeAllItems() {
    app.getSessionHelper().driver.findElement(By.cssSelector(".item>form>div>p>button[name='remove_cart_item']")).click();
  }

  private void openCart() {
    app.getSessionHelper().driver.findElement(By.cssSelector("#cart > .link"));
  }

  private void waitCountOfItems() throws InterruptedException {
    WebElement quantity = app.getSessionHelper().driver.findElement(By.cssSelector(".quantity"));
    quantity.getAttribute("value");
    WebDriverWait wait = new WebDriverWait(app.getSessionHelper().driver, 10);
    wait.until(visibilityOf(quantity));

  }


  private void addNewItemToCart() throws InterruptedException {
    List<WebElement> items = app.getSessionHelper().driver.findElements(By.cssSelector(".link > .name"));
    for (int i = 0; i < 1; i++ ) {
      WebElement firstitem = app.getSessionHelper().driver.findElement(By.cssSelector("a.link > .image-wrapper > .image[alt$='Duck']"));
      firstitem.click();

      if (isElementPresent(By.cssSelector(".options>select"))) {

        WebElement sizeitem = app.getSessionHelper().driver.findElement(By.cssSelector(".options>select"));
        Select selectsize = new Select(sizeitem);
        selectsize.selectByVisibleText("Small");
      }

      app.getSessionHelper().driver.findElement(By.cssSelector(".quantity > button")).click();
      waitCountOfItems();

      if (isAlertPresent()) {
        closeAlert();
      }




      }

    }
  }
