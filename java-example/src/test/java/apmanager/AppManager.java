package apmanager;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by IrinaIv on 7/20/2017.
 */
public class AppManager {
  private EventFiringWebDriver driver;
  private WebDriverWait wait;
  private String browser;
  private SessionHelper sessionHelper;
  private final Properties properties;


  public static class MyListener extends AbstractWebDriverEventListener {
    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by + " found");
    }
  }



  public AppManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(String.format("src/test/resources/%s.properties", target)));

    DesiredCapabilities caps = new DesiredCapabilities();
    if ("".equals(properties.getProperty("selenium.server"))) {
      if (browser.equals(BrowserType.CHROME)) {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListener());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        //System.out.println(((HasCapabilities) driver).getCapabilities());
      }
      if (browser.equals(BrowserType.IE)) {
        driver = new EventFiringWebDriver(new InternetExplorerDriver());
        //System.out.println(((HasCapabilities) driver).getCapabilities());
      }
      if (browser.equals(BrowserType.FIREFOX)) {
        //driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true)); //Firefox ESR
        //driver = new FirefoxDriver();  //Firefox new(with geckodriver)
        //driver = new FirefoxDriver(new FirefoxBinary(new File("C:\\Program Files\\Nightly\\firefox.exe")),
        //        new FirefoxProfile(), caps);  //Firefox Nightly  // deprecated

        FirefoxOptions options = new FirefoxOptions()
                .setBinary("C:\\\\Program Files\\\\Nightly\\\\firefox.exe")
                //.addArguments("-console")
                .addPreference("browser.cache.disk.enable", false)
                .addCapabilities(new DesiredCapabilities(
                        ImmutableMap.of("pageLoadStrategy", "eager")));
        driver = new EventFiringWebDriver(new FirefoxDriver(options));
        //System.out.println(((HasCapabilities) driver).getCapabilities());
      }
    } else {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setPlatform(Platform.fromString(System.getProperty("platform", "win8")));
        driver = new EventFiringWebDriver(new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities));

    }

    driver.get(properties.getProperty("web.baseUrl"));
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

  }

  public void stop() {
    driver.manage().addCookie(new Cookie("test", "test"));
    Cookie testCookie = driver.manage().getCookieNamed("test");
    Set<Cookie> cookies = driver.manage().getCookies();
    System.out.println(cookies);
    driver.manage().deleteCookieNamed("test");
    driver.manage().deleteAllCookies();
    driver.quit();
    driver = null;
  }
}
