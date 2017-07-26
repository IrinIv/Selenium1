package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by IrinaIv on 7/24/2017.
 */
public class AdminTest extends TestBase {

  @Test

  public void testAdminPanel() {

    login();
    //assertEquals(title, ("%s"));


//    WebElement appear = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Appearence']"));
//    appear.click();
//    String template = getH1();
//    assertEquals(template, ("Template"));
//
//    WebElement logo = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Logotype']"));
//    logo.click();
//    String logotype = getH1();
//    assertEquals(logotype, ("Logotype"));
//
//    WebElement catalog = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Catalog']"));
//    catalog.click();
//    String Catalog = getH1();
//    assertEquals(Catalog, ("Catalog"));
//
//    WebElement product = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Product Groups']"));
//    product.click();
//    String product_groups = getH1();
//    assertEquals(product_groups, ("Product Groups"));
//
//    WebElement option = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Option Groups']"));
//    option.click();
//    String option_groups = getH1();
//    assertEquals(option_groups, ("Option Groups"));
//
//    WebElement manufact = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Manufacturers']"));
//    manufact.click();
//    String manufacturers = getH1();
//    assertEquals(manufacturers, ("Manufacturers"));
//
//    WebElement supple = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Suppliers']"));
//    supple.click();
//    String suppliers = getH1();
//    assertEquals(suppliers, ("Suppliers"));
//
//    WebElement delivery = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Delivery Statuses']"));
//    delivery.click();
//    String delivery_status = getH1();
//    assertEquals(delivery_status, ("Delivery Statuses"));
//
//    WebElement sold = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Sold Out Statuses']"));
//    sold.click();
//    String sold_out_status = getH1();
//    assertEquals(sold_out_status, ("Sold Out Statuses"));
//
//    WebElement quantity = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Quantity Units']"));
//    quantity.click();
//    String quantity_units = getH1();
//    assertEquals(quantity_units, ("Quantity Units"));
//
//    WebElement csv = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='CSV Import/Export']"));
//    csv.click();
//    String csv_import = getH1();
//    assertEquals(csv_import, ("CSV Import/Export"));
//
//    WebElement country  = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Countries']"));
//    country.click();
//    String countries = getH1();
//    assertEquals(countries, ("Countries"));
//
//    WebElement currency  = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Currencies']"));
//    currency.click();
//    String currencies = getH1();
//    assertEquals(currencies, ("Currencies"));
//
//    WebElement custom  = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Customers']"));
//    custom.click();
//    String customers = getH1();
//    assertEquals(customers, ("Customers"));
//
//    WebElement csv2  = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='CSV Import/Export']"));
//    csv2.click();
//    String csv_import2 = getH1();
//    assertEquals(csv_import2, ("CSV Import/Export"));
//
//    WebElement letter  = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Newsletter']"));
//    letter.click();
//    String newsletter = getH1();
//    assertEquals(newsletter, ("Newsletter"));
//
//    WebElement geozones  = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Geo Zones']"));
//    geozones.click();
//    String geo_zones = getH1();
//    assertEquals(geo_zones, ("Geo Zones"));
//
//    WebElement language  = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Languages']"));
//    language.click();
//    String languages = getH1();
//    assertEquals(languages, ("Languages"));
//
//    WebElement storage = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Storage Encoding']"));
//    storage.click();
//    String storage_encoding = getH1();
//    assertEquals(storage_encoding, ("Storage Encoding"));
//
//    WebElement modules = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Modules']"));
//    modules.click();
//    String job = getH1();
//    assertEquals(job, ("Job Modules"));
//
//    WebElement customer = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Customer']"));
//    customer.click();
//    String customer_modules = getH1();
//    assertEquals(customer_modules, ("Customer Modules"));
//
//    WebElement shipping = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Shipping']"));
//    shipping.click();
//    String shipping_modules = getH1();
//    assertEquals(shipping_modules, ("Shipping Modules"));
//
//    WebElement payment = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Payment']"));
//    payment.click();
//    String payment_modules = getH1();
//    assertEquals(payment_modules, ("Payment Modules"));
//
//    WebElement order_total = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Order Total']"));
//    order_total.click();
//    String order_total_modules = getH1();
//    assertEquals(order_total_modules, ("Order Total Modules"));
//
//    WebElement order_success = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Order Success']"));
//    order_success.click();
//    String order_siccess_modules = getH1();
//    assertEquals(order_siccess_modules, ("Order Success Modules"));
//
//    WebElement order_action = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Order Action']"));
//    order_action.click();
//    String order_action_modules = getH1();
//    assertEquals(order_action_modules, ("Order Action Modules"));
//
//    WebElement order = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Orders']"));
//    order.click();
//    String orders = getH1();
//    assertEquals(orders, ("Orders"));
//
//    WebElement order_statuses = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Order Statuses']"));
//    order_statuses.click();
//    String Order_statuses = getH1();
//    assertEquals(Order_statuses, ("Order Statuses"));
//
//    WebElement pages = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Pages']"));
//    pages.click();
//    String Pages = getH1();
//    assertEquals(Pages, ("Pages"));
//
//    WebElement monthly_sales = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Reports']"));
//    monthly_sales.click();
//    String Monthly_sales = getH1();
//    assertEquals(Monthly_sales, ("Monthly Sales"));
//
//    WebElement most_sold_products = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Most Sold Products']"));
//    most_sold_products.click();
//    String Most_sold_products = getH1();
//    assertEquals(Most_sold_products, ("Most Sold Products"));
//
//    WebElement most_shopping_customers = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Most Shopping Customers']"));
//    most_shopping_customers.click();
//    String Most_shopping_customers = getH1();
//    assertEquals(Most_shopping_customers, ("Most Shopping Customers"));
//
//    WebElement settings = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Settings']"));
//    settings.click();
//    String Settings = getH1();
//    assertEquals(Settings, ("Settings"));
//
//    WebElement defset = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Defaults']"));
//    defset.click();
//    String def_settings = getH1();
//    assertEquals(def_settings, ("Settings"));
//
//    WebElement general = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='General']"));
//    general.click();
//    String gen_settings = getH1();
//    assertEquals(gen_settings, ("Settings"));
//
//    WebElement listings = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Listings']"));
//    listings.click();
//    String list_settings = getH1();
//    assertEquals(list_settings, ("Settings"));
//
//    WebElement images = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Images']"));
//    images.click();
//    String img_settings = getH1();
//    assertEquals(img_settings, ("Settings"));
//
//    WebElement checkout = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Checkout']"));
//    checkout.click();
//    String check_settings = getH1();
//    assertEquals(check_settings, ("Settings"));
//
//    WebElement security = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Security']"));
//    security.click();
//    String security_settings = getH1();
//    assertEquals(security_settings, ("Settings"));
//
//    WebElement slides = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Slides']"));
//    slides.click();
//    String Slides = getH1();
//    assertEquals(Slides, ("Slides"));
//
//    WebElement tax = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Tax']"));
//    tax.click();
//    String tax_classes = getH1();
//    assertEquals(tax_classes, ("Tax Classes"));
//
//    WebElement tax_rates = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Tax Rates']"));
//    tax_rates.click();
//    String Tax_rates = getH1();
//    assertEquals(Tax_rates, ("Tax Rates"));
//
//    WebElement transactions = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Translations']"));
//    transactions.click();
//    String search_transactions = getH1();
//    assertEquals(search_transactions, ("Search Translations"));
//
//    WebElement scan_files = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Scan Files']"));
//    scan_files.click();
//    String scan_files_for_translations = getH1();
//    assertEquals(scan_files_for_translations, ("Scan Files For Translations"));
//
//    WebElement csv3  = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='CSV Import/Export']"));
//    csv3.click();
//    String csv_import3 = getH1();
//    assertEquals(csv_import3, ("CSV Import/Export"));
//
//    WebElement users = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='Users']"));
//    users.click();
//    String Users = getH1();
//    assertEquals(Users, ("Users"));
//
//    WebElement vQmods = getWebElementBox().findElement(By.xpath(".//*[@class='name'][text()='vQmods']"));
//    vQmods.click();
//    String vQmod = getH1();
//    assertEquals(vQmod, ("vQmods"));


  }

}
