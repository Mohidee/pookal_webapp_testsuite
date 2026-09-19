package com.pookal.login;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pookal.utilityfiles.WaitUtils;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginLogoutpage {
	
	
	public LoginLogoutpage(WebDriver driver) {
	    this.driver = driver;
	    this.waitUtils = new WaitUtils(driver);
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    PageFactory.initElements(driver, this);
	}
	 private WebDriver driver;
	    private WaitUtils waitUtils;
	    private WebDriverWait wait;

	    @FindBy(css = "input[type='email'], input[name='email'], input#email, input[type='text']")
	    private WebElement usernameInput;

	    @FindBy(css = "input[type='password'], input[name='password'], input#password")
	    private WebElement passwordInput;

	    @FindBy(xpath = "//button[@class='btn auth-submit']")
	    private WebElement loginButton;

	    @FindBy(css = ".error-message, [role='alert'], .toast-error")
	    private WebElement errorMessage;

		/*
		 * public LoginPage(WebDriver driver) { this.driver = driver; this.waitUtils =
		 * new WaitUtils(driver); this.wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(10)); // Initialized here PageFactory.initElements(driver,
		 * this); }
		 */

	    public void enterUsername(String username) {
	        WebElement element = waitUtils.waitForVisibility(usernameInput);
	        element.clear();
	        element.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        WebElement element = waitUtils.waitForVisibility(passwordInput);
	        element.clear();
	        element.sendKeys(password);
	    }

	    public void clickLogin() {
	        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
	        try {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
	            button.click();
	        } catch (Exception e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	        }
	    }

	    public void performLogin(String username, String password) {
	        enterUsername(username);
	        enterPassword(password);
	        clickLogin();
	    }

	    public boolean isErrorMessageDisplayed() {
	        return waitUtils.isDisplayed(errorMessage);
	    }

	    public String getErrorMessageText() {
	        return waitUtils.waitForVisibility(errorMessage).getText();
	    }

	
}