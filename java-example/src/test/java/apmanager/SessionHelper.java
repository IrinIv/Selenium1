package apmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by IrinaIv on 7/20/2017.
 */
public class SessionHelper {
  public WebDriver driver;

  public SessionHelper(WebDriver driver) {
    this.driver = driver;
  }

  protected void login(String username, String password) {
    //driver.get("http://localhost/litecart/admin/login.php");
    driver.findElement(By.name("username")).sendKeys(username);
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.name("login")).click();
  }
}
