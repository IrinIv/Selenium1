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

    app.getShopingHelper().goToStoryPage();
    app.getShopingHelper().addNewItemToCart();
    app.getCartHelper().openCart();
    app.getCartHelper().removeAllItems();
    app.getShopingHelper().driver.navigate().back();
  }

}


