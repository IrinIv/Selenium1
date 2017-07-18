import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementSelectionStateToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Irina on 7/17/17.
 */
public class MyFirstTest {

  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);

  }

  @Test
  public void testMyFirst() {

    driver.get("http://google.com");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    //wait.until(visibilityOfElementLocated(By.name("btnG")));
    driver.findElement(By.name("btnG")).click();
    wait.until(titleIs("webdriver - Google Search"));

  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }

}
