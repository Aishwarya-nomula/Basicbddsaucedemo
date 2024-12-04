package Stepdefinations;


import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.Assert;

public class LoginPage{

  WebDriver driver;

  @Given("I am on the SauceDemo login page")
  public void i_am_on_the_saucedemo_login_page() {

    driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
  }

  @When("I login with valid credentials")
  public void i_login_with_valid_credentials() {
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
  }

  @Then("I should see the product page")
  public void i_should_see_the_product_page() {
    String expectedUrl = "https://www.saucedemo.com/inventory.html";
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(expectedUrl, actualUrl);
    driver.quit();
  }
}




















