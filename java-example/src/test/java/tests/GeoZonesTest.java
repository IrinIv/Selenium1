package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by IrinaIv on 7/28/2017.
 */
public class GeoZonesTest extends TestBase {

  @Test
  public void testGeoZones() {
    login();
    goToGeoZonesPage();
    //goToGeoZones();
    //getZoneListFromCountry();

  }

  private void goToGeoZonesPage() {
    app.getSessionHelper().driver.findElement(By.cssSelector("#box-apps-menu > li:nth-child(6)")).click();
    app.getSessionHelper().driver.findElement(By.cssSelector("tr:nth-child(n) > td:nth-child(3)"));
  }


}
