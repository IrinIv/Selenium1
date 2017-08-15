package tests;

import com.google.common.io.Files;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Irina on 7/17/17.
 */
public class MyFirstTest {

  private EventFiringWebDriver driver;
  private WebDriverWait wait;

  public static class MyListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by + " found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable);
      File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      try {
        Files.copy(tempFile, new File("screen.png"));
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println(new File("screen.png").getAbsolutePath());
    }
  }

  @BeforeMethod
  public void start() {
    driver = new EventFiringWebDriver(new ChromeDriver());
    driver.register(new MyListener());
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);

  }

  @Test
  public void testMyFirst() {

    driver.get("http://google.com");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    //wait.until(visibilityOfElementLocated(By.name("btnG")));
    driver.findElement(By.name("btnK")).click();
    wait.until(titleIs("webdriver - Google Search"));

  }

  @AfterMethod
  public void stop() {
    driver.quit();
    driver = null;
  }

}
