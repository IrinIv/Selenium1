package tests;

import org.testng.annotations.Test;

/**
 * Created by IrinaIv on 7/28/2017.
 */
public class GeoZonesTest extends TestBase {

  @Test
  public void testGeoZones() {
    login();
    goToGeoZonesPage();
    goToGeoZones();

  }


}
