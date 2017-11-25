package tests;

import org.openqa.selenium.support.Color;
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
  public void testCampaings() {

    app.getSessionHelper().driver.get("http://localhost/litecart/en/");
    System.out.println(app.getSessionHelper().driver.manage().logs().getAvailableLogTypes());
    app.getSessionHelper().driver.manage().logs().get("performance").forEach(l -> System.out.println(l));;
    List<WebElement> campaings = app.getSessionHelper().driver.findElements(By.cssSelector("#box-campaigns > .content"));
    List<String> dataCampaingsPage = new ArrayList<String>();
    List<String> dataProductPage = new ArrayList<String>();
    for (WebElement element : campaings) {
      WebElement name = element.findElement(By.cssSelector("ul > li > .link > .name"));
      name.getText();
      WebElement regprice = element.findElement(By.cssSelector("ul > li > .link > .price-wrapper > .regular-price"));
      regprice.getText();
      String tagnameRegprice = regprice.getTagName();
      Assert.assertEquals(tagnameRegprice, "s");

      String regpricefontsize = regprice.getCssValue("font-size");
      System.out.println(regpricefontsize);
      String[] regfont_size = regpricefontsize.replace(".4px", "").split("");
      int n = Integer.parseInt(regfont_size[0].trim());
      int n2 = Integer.parseInt(regfont_size[1].trim());
      int s = Integer.valueOf(String.valueOf(n) + String.valueOf(n2));

      String regpricecolor = (regprice.getCssValue("color"));
      String rdb = Color.fromString(regpricecolor).asRgb();
      String[] numbers = rdb.replace("rgb(", "").replace(")", "").split(",");
      int r = Integer.parseInt(numbers[0].trim());
      int g = Integer.parseInt(numbers[1].trim());
      int b = Integer.parseInt(numbers[2].trim());
      Assert.assertEquals(r, g, b);

      WebElement campprice = element.findElement(By.cssSelector("ul > li > .link > .price-wrapper > .campaign-price"));
      campprice.getText();
      String tagnameCampprice = campprice.getTagName();
      Assert.assertEquals(tagnameCampprice, "strong");

      String camppricefontsize = campprice.getCssValue("font-size");
      System.out.println(camppricefontsize);
      String[] campfont_size = camppricefontsize.replace("px", "").split("");
      int n3 = Integer.parseInt(campfont_size[0].trim());
      int n4 = Integer.parseInt(campfont_size[1].trim());
      int s2 = Integer.valueOf(String.valueOf(n3) + String.valueOf(n4));
      Assert.assertTrue(s2 > s);

      String camppricecolor = (campprice.getCssValue("color"));
      String rdb2 = Color.fromString(camppricecolor).asRgb();
      String[] numbers3 = rdb2.replace("rgb(", "").replace(")", "").split(",");
      int r2 = Integer.parseInt(numbers3[0].trim());
      int g2 = Integer.parseInt(numbers3[1].trim());
      int b2 = Integer.parseInt(numbers3[2].trim());
      Assert.assertTrue( g2 == 0 && b2 == 0);

      dataCampaingsPage.add(name.getText());
      dataCampaingsPage.add(regprice.getText());
      dataCampaingsPage.add(campprice.getText());
    }

    app.getSessionHelper().driver.findElement(By.cssSelector("#box-campaigns > .content > ul > li > .link")).click();
    List<WebElement> productPage = app.getSessionHelper().driver.findElements(By.cssSelector("#box-product"));
    for (WebElement element : productPage) {
      WebElement productName = element.findElement(By.cssSelector("#box-product > div > .title"));
      productName.getText();
      WebElement prodregprice = element.findElement(By.cssSelector("#box-product > div > div > div > .regular-price"));
      prodregprice.getText();

      prodregprice.getTagName();
      String tagnameProdregprice = prodregprice.getTagName();
      Assert.assertEquals(tagnameProdregprice, "s");

      String prodregpricefontsize = prodregprice.getCssValue("font-size");
      System.out.println(prodregpricefontsize);
      String[] prodregfont_size = prodregpricefontsize.replace("px", "").split("");
      int n = Integer.parseInt(prodregfont_size[0].trim());
      int n2 = Integer.parseInt(prodregfont_size[1].trim());
      int s = Integer.valueOf(String.valueOf(n) + String.valueOf(n2));


      prodregprice.getCssValue("color");
      String prodregpricecolor = prodregprice.getCssValue("color");
      String rdb = Color.fromString(prodregpricecolor).asRgb();
      String[] numbers2 = rdb.replace("rgb(", "").replace(")", "").split(",");
      int r = Integer.parseInt(numbers2[0].trim());
      int g = Integer.parseInt(numbers2[1].trim());
      int b = Integer.parseInt(numbers2[2].trim());
      Assert.assertEquals(r, g, b);

      WebElement prodcampprice = element.findElement(By.cssSelector("#box-product > div > div > div > .campaign-price"));
      prodcampprice.getText();
      prodcampprice.getTagName();
      String tagnameProdcampprice = prodcampprice.getTagName();
      Assert.assertEquals(tagnameProdcampprice, "strong");

      String prodcamppricefontsize = prodcampprice.getCssValue("font-size");
      System.out.println(prodcamppricefontsize);
      String[] prodcampfont_size = prodcamppricefontsize.replace("px", "").split("");
      int n3 = Integer.parseInt(prodcampfont_size[0].trim());
      int n4 = Integer.parseInt(prodcampfont_size[1].trim());
      int s2 = Integer.valueOf(String.valueOf(n3) + String.valueOf(n4));
      Assert.assertTrue(s2 > s);


      prodcampprice.getCssValue("color");
      String prodcamppricecolor = (prodcampprice.getCssValue("color"));
      String rdb2 = Color.fromString(prodcamppricecolor).asRgb();
      String[] numbers4 = rdb2.replace("rgb(", "").replace(")", "").split(",");
      int r2 = Integer.parseInt(numbers4[0].trim());
      int g2 = Integer.parseInt(numbers4[1].trim());
      int b2 = Integer.parseInt(numbers4[2].trim());
      Assert.assertTrue( g2 == 0 && b2 == 0);

      dataProductPage.add(productName.getText());
      dataProductPage.add(prodregprice.getText());
      dataProductPage.add(prodcampprice.getText());
    }
    Assert.assertEquals(dataCampaingsPage, dataProductPage);
  }
}
