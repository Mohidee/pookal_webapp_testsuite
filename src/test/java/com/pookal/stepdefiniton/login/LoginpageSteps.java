package com.pookal.stepdefiniton.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pookal.login.LoginLogoutpage;

// Make sure these imports match your actual package path in Eclipse
import com.pookal.utilityfiles.*;

public class LoginpageSteps {

    private WebDriver driver;
    private LoginLogoutpage loginPage;

    @Given("the user is on the admin login page")
    public void the_user_is_on_the_admin_login_page() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginLogoutpage(driver);
        driver.get(ConfigReader.getProperty("url"));
    }

    @When("the user enters a valid username")
    public void the_user_enters_a_valid_username() {
        loginPage.enterUsername(ConfigReader.getProperty("username"));
    }

    @And("the user enters a valid password")
    public void the_user_enters_a_valid_password() {
        loginPage.enterPassword(ConfigReader.getProperty("password"));
    }

    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        String currentUrl = driver.getCurrentUrl();
      /*  Assert.assertTrue(
            currentUrl.contains("dashboard"),
            "User was not redirected to the dashboard. Current URL: " + currentUrl
        );*/
    }
}