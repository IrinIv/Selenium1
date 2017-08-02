package tests;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

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
    app.getSessionHelper().driver.findElement(By.cssSelector(".input-wrapper > input")).sendKeys("Yellow Duck");
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

    app.getSessionHelper().driver.findElement(By.cssSelector(".button-set>button[name='save']")).click();

  }


}
