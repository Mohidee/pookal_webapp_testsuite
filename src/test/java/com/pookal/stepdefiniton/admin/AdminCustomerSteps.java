package com.pookal.stepdefiniton.admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pookal.admin.AdminCustomerPage;
import com.pookal.utilityfiles.*;

public class AdminCustomerSteps {

    private WebDriver driver;
    private AdminCustomerPage adminCustomerPage;

    @Given("the admin is on the customers page")
    public void the_admin_is_on_the_customers_page() {
        driver = DriverFactory.getDriver();
        adminCustomerPage = new AdminCustomerPage(driver);
    }

    @When("the admin clicks the Add Customer button")
    public void the_admin_clicks_the_add_customer_button() throws InterruptedException {
        adminCustomerPage.clickAddCustomer();
        Thread.sleep(2000); // Wait for modal animation to complete
    }

    @Then("the Create New Shop modal should be displayed")
    public void the_create_new_shop_modal_should_be_displayed() {
        Assert.assertTrue(adminCustomerPage.isCreateNewShopModalDisplayed(),
            "Create New Shop modal is not displayed");
    }

    @When("the admin enters full name {string}")
    public void the_admin_enters_full_name(String fullName) {
        adminCustomerPage.enterFullName(fullName);
    }

    @And("the admin enters email {string}")
    public void the_admin_enters_email(String email) {
        adminCustomerPage.enterEmail(email);
    }

    @And("the admin enters password {string}")
    public void the_admin_enters_password(String password) {
        adminCustomerPage.enterPassword(password);
    }

    @And("the admin enters role {string}")
    public void the_admin_enters_role(String role) {
        adminCustomerPage.enterRole(role);
    }

    @And("the admin enters shop name {string}")
    public void the_admin_enters_shop_name(String shopName) {
        adminCustomerPage.enterShopName(shopName);
    }

    @And("the admin enters phone {string}")
    public void the_admin_enters_phone(String phone) {
        adminCustomerPage.enterPhone(phone);
    }

    @And("the admin uploads an image {string}")
    public void the_admin_uploads_an_image(String imagePath) {
        adminCustomerPage.uploadImage(imagePath);
    }

    @And("the admin selects plan {string}")
    public void the_admin_selects_plan(String plan) {
        adminCustomerPage.selectPlan(plan);
    }

    @And("the admin selects billing cycle {string}")
    public void the_admin_selects_billing_cycle(String billingCycle) {
        adminCustomerPage.selectBillingCycle(billingCycle);
    }

    @And("the admin enters start date {string}")
    public void the_admin_enters_start_date(String startDate) {
        adminCustomerPage.enterStartDate(startDate);
    }

    @And("the admin enters notes {string}")
    public void the_admin_enters_notes(String notes) {
        adminCustomerPage.enterNotes(notes);
    }

    @And("the admin clicks the submit button")
    public void the_admin_clicks_the_submit_button() {
        adminCustomerPage.clickSubmit();
    }

    @And("the admin closes the modal")
    public void the_admin_closes_the_modal() {
        adminCustomerPage.closeModal();
    }
}
