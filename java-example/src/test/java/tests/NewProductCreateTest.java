package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IrinaIv on 8/1/2017.
 */
public class NewProductCreateTest extends TestBase {

  @Test
  public void testNewProductCreate() {
    login();
    addNewProduct();
    fillGeneralTab();
    fillInformationTab();
    fillPriceTab();
    saveNewProduct();
    verifyNewProductExist();

  }

  String prodname = "Yellow Duck";

  private void verifyNewProductExist() {

    List<WebElement> allelements = app.getSessionHelper().driver.findElements(By.cssSelector(".dataTable > tbody > tr"));
    for (int i = 4; i < allelements.size(); i++ ) {
      List<WebElement> names = app.getSessionHelper().driver.findElements(By.cssSelector(String.format("#content > form > table > tbody > tr:nth-child(%s)", i)));
      WebElement name1 = app.getSessionHelper().driver.findElement(By.cssSelector(String.format("#content > form > table > tbody > tr:nth-child(%s)", i)));
      List<String> withnewproduct = new ArrayList<String>();
      withnewproduct.add(name1.getText());

      Assert.assertTrue(withnewproduct.contains(prodname));

    }

  }

  private void addNewProduct() {
    app.getSessionHelper().driver.findElement(By.cssSelector("#box-apps-menu > li:nth-child(2)")).click();
    app.getSessionHelper().driver.findElement(By.cssSelector("#content > div:nth-child(3) > a:nth-child(2)")).click();

  }

  private void fillGeneralTab() {
    app.getSessionHelper().driver.findElements(By.cssSelector("#tab-general>table>tbody>tr>td>label"));

    List<WebElement> status = app.getSessionHelper().driver.findElements(By.cssSelector("#tab-general>table>tbody>tr>td>label"));
    for (WebElement element : status) {
      WebElement st = app.getSessionHelper().driver.findElement(By.cssSelector("#tab-general>table>tbody>tr>td>label"));
      String stat = st.getAttribute("checked");
      if (stat == null) {
        st.click();
      }
    }


    app.getSessionHelper().driver.findElement(By.cssSelector(".input-wrapper > input")).sendKeys(prodname);
    app.getSessionHelper().driver.findElement(By.cssSelector("#tab-general > table > tbody > tr > td > input")).sendKeys("R2345");

    List<WebElement> categories = app.getSessionHelper().driver.findElements(By.cssSelector("#tab-general > table > tbody > tr:nth-child(4) > td > div > table > tbody > tr"));
    for (int i = 1; i <= categories.size(); i++) {
      WebElement categ = app.getSessionHelper().driver.findElement(By.cssSelector(String.format(".input-wrapper > table > tbody > tr:nth-child(%s)  > td > input[name='categories[]']", i)));
      String cat = categ.getAttribute("checked");
      if (cat != null) {
        categ.click();
      }
      categ.click();
    }

    WebElement defcateg = app.getSessionHelper().driver.findElement(By.cssSelector("#tab-general > table > tbody > tr > td > select"));
    Select selectdefcat = new Select(defcateg);
    selectdefcat.selectByVisibleText("Rubber Ducks");

    List<WebElement> productgroups = app.getSessionHelper().driver.findElements(By.cssSelector("#tab-general > table > tbody > tr:nth-child(7) > td > div > table > tbody > tr"));
    for (int i = 2; i <= productgroups.size(); i++) {
      WebElement prodgr = app.getSessionHelper().driver.findElement(By.cssSelector(String.format(".input-wrapper > table > tbody > tr:nth-child(%s)  > td > input[name='product_groups[]']", i)));
      String prgroup = prodgr.getAttribute("checked");
      WebElement grtext = app.getSessionHelper().driver.findElement(By.cssSelector(String.format("#tab-general > table > tbody > tr:nth-child(7) > td > div > table > tbody > tr:nth-child(%s) > td:nth-child(2)", i)));
      String text = grtext.getAttribute("innerText");
      if (text.equalsIgnoreCase("Unisex")) {
        prodgr.click();
      }
    }

    WebElement quantity = app.getSessionHelper().driver.findElement(By.cssSelector("#tab-general>table>tbody>tr>td>table>tbody>tr>td>input[name='quantity']"));
    quantity.clear();
    quantity.sendKeys("10.00");

    WebElement unitid = app.getSessionHelper().driver.findElement(By.cssSelector("select[name='quantity_unit_id']"));
    Select selectunitid = new Select(unitid);
    selectunitid.selectByVisibleText("pcs");

    WebElement delstatus =  app.getSessionHelper().driver.findElement(By.cssSelector("select[name='delivery_status_id']"));
    Select selectdelstatus = new Select(delstatus);
    selectdelstatus.selectByVisibleText("3-5 days");

    WebElement soldst =  app.getSessionHelper().driver.findElement(By.cssSelector("select[name='sold_out_status_id']"));
    Select selectsoldstatus = new Select(soldst);
    selectsoldstatus.selectByVisibleText("Sold out");

    File image = new File("src/test/resources/Duck.jpg");
    WebElement images = app.getSessionHelper().driver.findElement(By.cssSelector("#tab-general>table>tbody>tr>td>table>tbody>tr>td>input[name='new_images[]']"));
    images.sendKeys(image.getAbsolutePath());

    app.getSessionHelper().driver.findElement(By.cssSelector("#tab-general>table>tbody>tr>td>input[name='date_valid_from']")).sendKeys("08-02-2017");
    app.getSessionHelper().driver.findElement(By.cssSelector("#tab-general>table>tbody>tr>td>input[name='date_valid_to']")).sendKeys("10-02-2017");

  }

  private void fillInformationTab() {
    app.getSessionHelper().driver.findElement(By.cssSelector("#content > form > div > ul > li:nth-child(2) > a")).click();

    WebElement manufacturer = app.getSessionHelper().driver.findElement(By.cssSelector("#tab-information>table>tbody>tr>td>select[name='manufacturer_id']"));
    Select selectmanufact = new Select(manufacturer);
    selectmanufact.selectByVisibleText("ACME Corp.");

    WebElement supplier = app.getSessionHelper().driver.findElement(By.cssSelector("#tab-information>table>tbody>tr>td>select[name='supplier_id']"));
    Select selectsupplier = new Select(supplier);
    selectsupplier.selectByIndex(0);

    app.getSessionHelper().driver.findElement(By.cssSelector("#tab-information>table>tbody>tr>td>input")).sendKeys("Ducks");
    app.getSessionHelper().driver.findElement(By.cssSelector(".input-wrapper>input[name='short_description[en]']")).sendKeys("Yellow duck");
    app.getSessionHelper().driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys("a little yellow duck");
    app.getSessionHelper().driver.findElement(By.cssSelector(".input-wrapper>input[name='head_title[en]']")).sendKeys("yellow duck");
    app.getSessionHelper().driver.findElement(By.cssSelector(".input-wrapper>input[name='meta_description[en]']")).sendKeys("yellow duck");
  }


  private void fillPriceTab() {
    app.getSessionHelper().driver.findElement(By.cssSelector("#content > form > div > ul > li:nth-child(4) > a")).click();
    WebElement price = app.getSessionHelper().driver.findElement(By.cssSelector("#tab-prices>table>tbody>tr>td>input[name='purchase_price']"));
    price.clear();
    price.sendKeys("1.00");

    WebElement curren = app.getSessionHelper().driver.findElement(By.cssSelector("#tab-prices>table>tbody>tr>td>select[name='purchase_price_currency_code']"));
    Select selectcurren = new Select(curren);
    selectcurren.selectByVisibleText("US Dollars");

    WebElement tax = app.getSessionHelper().driver.findElement(By.cssSelector("#table-prices>tbody>tr>td>select"));
    Select selecttax = new Select(tax);
    selecttax.selectByVisibleText("Standard");

    app.getSessionHelper().driver.findElement(By.cssSelector(".input-wrapper>input[name='prices[USD]']")).sendKeys("0.25");

  }

  private void saveNewProduct() {
    app.getSessionHelper().driver.findElement(By.cssSelector(".button-set>button[name='save']")).click();

  }

}
