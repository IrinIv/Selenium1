package tests;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IrinaIv on 7/29/2017.
 */
public class CampaignsTest extends TestBase {

  @Test
  public void testCampaigs() {

    app.getSessionHelper().driver.get("http://localhost/litecart/en/");
    List<WebElement> campaings = app.getSessionHelper().driver.findElements(By.cssSelector("#box-campaigns > .content"));
    List<String> dataCampaingsPage = new ArrayList<String>();
    List<String> dataProductPage = new ArrayList<String>();
    for (WebElement element : campaings) {
      WebElement name = element.findElement(By.cssSelector("ul > li > .link > .name"));
      System.out.println(name.getText());
      WebElement regprice = element.findElement(By.cssSelector("ul > li > .link > .price-wrapper > .regular-price"));
      System.out.println(regprice.getText());
      System.out.println(regprice.getCssValue("font-weight"));
      System.out.println(regprice.getCssValue("font-size"));
      System.out.println(regprice.getCssValue("color"));

      WebElement campprice = element.findElement(By.cssSelector("ul > li > .link > .price-wrapper > .campaign-price"));
      System.out.println(campprice.getText());
      System.out.println(campprice.getCssValue("font-weight"));
      System.out.println(campprice.getCssValue("font-size"));
      System.out.println(campprice.getCssValue("color"));

      dataCampaingsPage.add(name.getText());
      dataCampaingsPage.add(regprice.getText());
      dataCampaingsPage.add(campprice.getText());
    }

    app.getSessionHelper().driver.findElement(By.cssSelector("#box-campaigns > .content > ul > li > .link")).click();
    List<WebElement> productPage = app.getSessionHelper().driver.findElements(By.cssSelector("#box-product"));
    for (WebElement element : productPage) {
      WebElement productName = element.findElement(By.cssSelector("#box-product > div > .title"));
      System.out.println(productName.getText());
      WebElement prodregprice = element.findElement(By.cssSelector("#box-product > div > div > div > .regular-price"));
      System.out.println(prodregprice.getText());
      System.out.println(prodregprice.getCssValue("font-weight"));
      System.out.println(prodregprice.getCssValue("font-size"));
      System.out.println(prodregprice.getCssValue("color"));

      WebElement prodcampprice = element.findElement(By.cssSelector("#box-product > div > div > div > .campaign-price"));
      System.out.println(prodcampprice.getText());
      System.out.println(prodcampprice.getCssValue("font-weight"));
      System.out.println(prodcampprice.getCssValue("font-size"));
      System.out.println(prodcampprice.getCssValue("color"));

      dataProductPage.add(productName.getText());
      dataProductPage.add(prodregprice.getText());
      dataProductPage.add(prodcampprice.getText());
    }
    Assert.assertEquals(dataCampaingsPage, dataProductPage  );
  }
}
