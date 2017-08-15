package apmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by IrinaIv on 7/20/2017.
 */
public class SessionHelper {
  public EventFiringWebDriver driver;

  public SessionHelper(EventFiringWebDriver driver) {
    this.driver = driver;
  }

  protected void login(String username, String password) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    //driver.get("http://localhost/litecart/admin/login.php");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys(username);
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.xpath("//*[@id=\"box-login\"]/form/div[2]/button")).click();
  }
}
