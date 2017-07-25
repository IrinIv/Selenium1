package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by IrinaIv on 7/24/2017.
 */
public class AdminTest extends TestBase {

  @Test

  public void testAdminPanel() {

    login();
    WebElement appear = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Appearence']"));
    appear.click();
    String template = getH1();
    assertEquals(template, ("Template"));

    WebElement logo = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Logotype']"));
    logo.click();
    String logotype = getH1();
    assertEquals(logotype, ("Logotype"));

    WebElement catal = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Catalog']"));
    catal.click();
    String catalog = getH1();
    assertEquals(catalog, ("Catalog"));

    WebElement product = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Product Groups']"));
    product.click();
    String product_groups = getH1();
    assertEquals(product_groups, ("Product Groups"));

    WebElement option = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Option Groups']"));
    option.click();
    String option_groups = getH1();
    assertEquals(option_groups, ("Option Groups"));

    WebElement manufact = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Manufacturers']"));
    manufact.click();
    String manufacturers = getH1();
    assertEquals(manufacturers, ("Manufacturers"));

    WebElement supple = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Suppliers']"));
    supple.click();
    String suppliers = getH1();
    assertEquals(suppliers, ("Suppliers"));

    WebElement delivery = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Delivery Statuses']"));
    delivery.click();
    String delivery_status = getH1();
    assertEquals(delivery_status, ("Delivery Statuses"));

    WebElement sold = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Sold Out Statuses']"));
    sold.click();
    String sold_out_status = getH1();
    assertEquals(sold_out_status, ("Sold Out Statuses"));

    WebElement quantity = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Quantity Units']"));
    quantity.click();
    String quantity_units = getH1();
    assertEquals(quantity_units, ("Quantity Units"));

    WebElement csv = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='CSV Import/Export']"));
    csv.click();
    String csv_import = getH1();
    assertEquals(csv_import, ("CSV Import/Export"));

    WebElement country  = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Countries']"));
    country.click();
    String countries = getH1();
    assertEquals(countries, ("Countries"));

    WebElement currency  = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Currencies']"));
    currency.click();
    String currencies = getH1();
    assertEquals(currencies, ("Currencies"));




  }

}
