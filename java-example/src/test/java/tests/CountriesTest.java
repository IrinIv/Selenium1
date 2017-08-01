package tests;

import org.testng.annotations.Test;

/**
 * Created by IrinaIv on 7/27/2017.
 */
public class CountriesTest extends TestBase {

  @Test
  public void testCountries() {

    login();
    goToCountriesPage();
    getCountriesList();
    verifyCountOfZons();
  }

}
