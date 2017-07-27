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
    getTitleListIsPresent();

  }
}
