package tests;

import org.testng.annotations.Test;

/**
 * Created by IrinaIv on 7/24/2017.
 */
public class AdminTest extends TestBase {

  @Test

  public void testAdminPanel() {

    login();
    getTitleListIsPresent();

  }
}
