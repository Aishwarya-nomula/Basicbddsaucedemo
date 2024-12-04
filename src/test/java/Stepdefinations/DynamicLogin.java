package Stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicLogin {



  WebDriver driver;

  @Given("I am on the SauceDemo login page")
  public void i_am_on_the_saucedemo_login_page() {

    driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
  }

  @When("I login with username {string} and password {string}")
  public void i_login_with_username_and_password(String username, String password) {
    driver.findElement(By.id("user-name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("login-button")).click();
  }

  @Then("I should see the product page if {string} is {string}")
  public void i_should_see_the_product_page_if_status_is(String status, String expectedStatus) {
    if ("valid".equals(expectedStatus)) {
      String expectedUrl = "https://www.saucedemo.com/inventory.html";
      String actualUrl = driver.getCurrentUrl();
      Assert.assertEquals("Login should succeed for valid credentials", expectedUrl, actualUrl);
    } else {
      boolean isErrorMessageDisplayed = driver.findElement(By.cssSelector(".error-message-container")).isDisplayed();
      Assert.assertTrue("Error message should be displayed for invalid credentials", isErrorMessageDisplayed);
    }
    driver.quit();
  }
}
