package com.pookal.admin;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pookal.utilityfiles.WaitUtils;

public class AdminCustomerPage {

    private WebDriver driver;
    private WaitUtils waitUtils;
    private WebDriverWait wait;

    public AdminCustomerPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Tabs
    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    private WebElement customersTab;

    @FindBy(xpath = "//button[contains(text(),'Subscriptions')]")
    private WebElement subscriptionsTab;

    @FindBy(xpath = "//button[contains(text(),'Plans')]")
    private WebElement plansTab;

    @FindBy(xpath = "//button[contains(text(),'Demo Requests')]")
    private WebElement demoRequestsTab;

    // Add Customer Button
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    private WebElement addCustomerButton;

    // ==================== Create New Shop Modal Elements ====================

    // Modal Title - broad XPath to match any element containing the modal title text
    @FindBy(xpath = "//*[contains(text(),'Create New Shop')]")
    private WebElement createNewShopModalTitle;
    

    // Modal Close Button
    @FindBy(xpath = "//button[contains(@class,'close')] | //button[contains(@aria-label,'Close')]")
    private WebElement modalCloseButton;

    // Full Name
    @FindBy(xpath = "//label[contains(text(),'Full Name')]/following::input[1]")
    private WebElement fullNameInput;

    // Email
    @FindBy(xpath = "//label[contains(text(),'Email')]/following::input[1]")
    private WebElement emailInput;

    // Password
    @FindBy(xpath = "//label[contains(text(),'Password')]/following::input[1]")
    private WebElement passwordInput;

    // Role
    @FindBy(xpath = "//label[contains(text(),'Role')]/following::input[1]")
    private WebElement roleInput;

    // Shop Name
    @FindBy(xpath = "//label[contains(text(),'Shop Name')]/following::input[1]")
    private WebElement shopNameInput;

    // Phone
    @FindBy(xpath = "//label[contains(text(),'Phone')]/following::input[1]")
    private WebElement phoneInput;

    // Image Upload Field
    @FindBy(xpath = "//input[@type='file']")
    private WebElement imageUploadInput;

    @FindBy(xpath = "//label[contains(text(),'Image') or contains(text(),'Logo') or contains(text(),'Photo')]/following::input[@type='file'][1]")
    private WebElement imageUploadByLabel;

    @FindBy(xpath = "//button[contains(text(),'Upload') or contains(text(),'Choose')] | //label[contains(@class,'upload')]")
    private WebElement imageUploadButton;

    // Plan Dropdown
    @FindBy(xpath = "//label[contains(text(),'Plan')]/following::select[1] | //label[contains(text(),'Plan')]/following::div[contains(@class,'select')][1]")
    private WebElement planDropdown;

    // Billing Cycle Dropdown
    @FindBy(xpath = "//label[contains(text(),'Billing Cycle')]/following::select[1] | //label[contains(text(),'Billing Cycle')]/following::div[contains(@class,'select')][1]")
    private WebElement billingCycleDropdown;

    // Start Date
    @FindBy(xpath = "//label[contains(text(),'Start Date')]/following::input[1]")
    private WebElement startDateInput;

    // Notes
    @FindBy(xpath = "//label[contains(text(),'Notes')]/following::textarea[1]")
    private WebElement notesTextarea;

    // Submit / Create Button
    @FindBy(xpath = "//button[contains(text(),'Create') or contains(text(),'Submit') or contains(text(),'Save')]")
    private WebElement submitButton;

    // ==================== Tab Actions ====================

    public void clickCustomersTab() {
        waitUtils.waitForClickability(customersTab).click();
    }

    public void clickSubscriptionsTab() {
        waitUtils.waitForClickability(subscriptionsTab).click();
    }

    public void clickPlansTab() {
        waitUtils.waitForClickability(plansTab).click();
    }

    public void clickDemoRequestsTab() {
        waitUtils.waitForClickability(demoRequestsTab).click();
    }

    // ==================== Add Customer Action ====================

    public void clickAddCustomer() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addCustomerButton));
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            button.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
    }

    // ==================== Create New Shop Modal Actions ====================

    public boolean isCreateNewShopModalDisplayed() {
        return waitUtils.isDisplayed(createNewShopModalTitle);
    }

    public void closeModal() {
        waitUtils.waitForClickability(modalCloseButton).click();
    }

    public void enterFullName(String fullName) {
        WebElement element = waitUtils.waitForVisibility(fullNameInput);
        element.clear();
        element.sendKeys(fullName);
    }

    public void enterEmail(String email) {
        WebElement element = waitUtils.waitForVisibility(emailInput);
        element.clear();
        element.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement element = waitUtils.waitForVisibility(passwordInput);
        element.clear();
        element.sendKeys(password);
    }

    public void enterRole(String role) {
        WebElement element = waitUtils.waitForVisibility(roleInput);
        element.clear();
        element.sendKeys(role);
    }

    public void enterShopName(String shopName) {
        WebElement element = waitUtils.waitForVisibility(shopNameInput);
        element.clear();
        element.sendKeys(shopName);
    }

    public void enterPhone(String phone) {
        WebElement element = waitUtils.waitForVisibility(phoneInput);
        element.clear();
        element.sendKeys(phone);
    }
    public void uploadImage(String absoluteFilePath) {
        // Make the file input visible if it is hidden
        WebElement fileInput = imageUploadInput;
        try {
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.display='block'; arguments[0].style.visibility='visible';", fileInput);
        } catch (Exception e) {
            // If JS fails, try directly
        }
        fileInput.sendKeys(absoluteFilePath);
    }

    /**
     * Upload an image by clicking the upload button first (for custom styled uploads)
     * and then sending the file path to the hidden input.
     *
     * @param absoluteFilePath the absolute path to the image file
     */
    public void uploadImageViaButton(String absoluteFilePath) {
        try {
            // Try to find and click the upload button/label
            waitUtils.waitForClickability(imageUploadButton).click();
            Thread.sleep(500); // Brief wait for file dialog
        } catch (Exception e) {
            // Upload button may not exist, proceed with direct file input
        }
        uploadImage(absoluteFilePath);
    }

    public void selectPlan(String planName) {
        WebElement element = waitUtils.waitForClickability(planDropdown);
        element.click();
        // Click the option with matching text
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
            org.openqa.selenium.By.xpath("//option[contains(text(),'" + planName + "')] | //div[contains(text(),'" + planName + "')]")
        ));
        option.click();
    }

    public void selectBillingCycle(String cycle) {
        WebElement element = waitUtils.waitForClickability(billingCycleDropdown);
        element.click();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
            org.openqa.selenium.By.xpath("//option[contains(text(),'" + cycle + "')] | //div[contains(text(),'" + cycle + "')]")
        ));
        option.click();
    }

    public void enterStartDate(String date) {
        WebElement element = waitUtils.waitForVisibility(startDateInput);
        element.clear();
        element.sendKeys(date);
    }

    public void enterNotes(String notes) {
        WebElement element = waitUtils.waitForVisibility(notesTextarea);
        element.clear();
        element.sendKeys(notes);
    }

    public void clickSubmit() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            button.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        }
    }

    public void fillCreateNewShopForm(String fullName, String email, String password,
                                       String role, String shopName, String phone,
                                       String imagePath, String plan, String billingCycle,
                                       String startDate, String notes) {
        enterFullName(fullName);
        enterEmail(email);
        enterPassword(password);
        enterRole(role);
        enterShopName(shopName);
        enterPhone(phone);
        if (imagePath != null && !imagePath.isEmpty()) {
            uploadImage(imagePath);
        }
        selectPlan(plan);
        selectBillingCycle(billingCycle);
        enterStartDate(startDate);
        enterNotes(notes);
        clickSubmit();
    }
}
