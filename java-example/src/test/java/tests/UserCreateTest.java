package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by IrinaIv on 7/31/2017.
 */
public class UserCreateTest extends TestBase {

  @Test
  public void testUserCreate() {

    //login();
    //goToSecuritySettings();
    //turnOffCaptcha();
    app.getSessionHelper().driver.get("http://localhost/litecart/en/");
    loginNewUser();
  }

  private void loginNewUser() {
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='box-account-login']//a")).click();
    long now = System.currentTimeMillis();
    String firstname = String.format("firstname%s", now);
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='create-account']//tr[2]/td[1]/input")).sendKeys(firstname);
    String lastname = String.format("lastname%s", now);
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='create-account']//tr[2]/td[2]/input")).sendKeys(lastname);
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='create-account']//tr[3]/td[1]/input")).sendKeys("34 Short Ave");
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='create-account']//tr[4]/td[1]/input")).sendKeys("94505");
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='create-account']//tr[4]/td[2]/input")).sendKeys("Mountain View");
    WebElement country = app.getSessionHelper().driver.findElement(By.xpath("//*[@id='create-account']//tr[5]/td[1]/span[2]"));
    country.click();
    WebElement state = app.getSessionHelper().driver.findElement(By.xpath("//*[@id='create-account']//tr[5]/td[2]/select"));
    state.click();
    String email = String.format("email%s@gmail.com", now);
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='create-account']//tr[6]/td[1]/input")).sendKeys(email);
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='create-account']//tr[6]/td[2]/input")).sendKeys("6501231234");
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='create-account']//tr[8]/td[1]/input")).sendKeys("password");
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='create-account']//tr[8]/td[2]/input")).sendKeys("password");
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='create-account']//tr[9]/td/button")).click();
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='box-account']/div/ul/li[3]/a")).click();
    String useremail = app.getSessionHelper().driver.findElement(By.xpath("//*[@id='create-account']//tr[1]/td[1]/input")).getAttribute("value");
    app.getSessionHelper().driver.navigate().back();
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='box-account']/div/ul/li[4]/a")).click();
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='box-account-login']//tr[1]/td/input")).sendKeys(useremail);
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='box-account-login']//tr[2]/td/input")).sendKeys("password");
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='box-account-login']//tr[4]/td/span/button[1]")).click();
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id='box-account']/div/ul/li[4]/a")).click();
  }

  private void turnOffCaptcha() {
    app.getSessionHelper().driver.findElement(By.cssSelector("tr.row"));
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id=\"content\"]//tr[7]/td[3]/a")).click();
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id=\"content\"]//tr[7]/td[2]/label[2]")).click();
    app.getSessionHelper().driver.findElement(By.xpath("//*[@id=\"content\"]//tr[7]/td[3]/button[1]")).click();
  }

  private void goToSecuritySettings() {
    app.getSessionHelper().driver.findElement(By.cssSelector("#box-apps-menu > li:nth-child(12)")).click();
    app.getSessionHelper().driver.findElement(By.cssSelector(".docs > li:nth-child(8)")).click();
  }
}
