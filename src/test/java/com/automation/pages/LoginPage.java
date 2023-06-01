package com.automation.pages;

import com.automation.utils.PropertyReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage{
    @FindBy (xpath="//h2")
    WebElement loginPageHeader;
    @FindBy (xpath="//input[@name='username']")
    WebElement emailAddressInput;
    @FindBy (xpath="//label[contains(@id,'username')]")
    WebElement emailAddressTitle;
    @FindBy (xpath="//input[@name='password']")
    WebElement passwordInput;
    @FindBy (xpath="//label[contains(@id,'password')]")
    WebElement passwordTitle;

    @FindBy (xpath="//button[@type='submit']")
    WebElement signInButton;

    public void navigateToURL(String url) {
        driver.get(PropertyReader.getProperty(url));
    }

    public void verifyLoginPage() {
        String strUrl = driver.getCurrentUrl();
        assertTrue(strUrl.contains("portal/login"));
        waitForElementToBeVisible(loginPageHeader);
        String expPageHeader = "Welcome Back!";
        String actPageHeader = loginPageHeader.getText();
        assertEquals(actPageHeader, expPageHeader);
    }
    public void login(String email, String password) {
        waitForElementToBeVisible(emailAddressInput);
        assertTrue(emailAddressTitle.getText().contains("Email Address"), "Incorrect label for the Email Address (username) input field");
        emailAddressInput.sendKeys(PropertyReader.getProperty(email));
        waitForElementToBeVisible(passwordInput);
        assertTrue(passwordTitle.getText().contains("Password"), "Incorrect label for the Password input field");
        passwordInput.sendKeys(PropertyReader.getProperty(password));
    }
    public void clickSignInToYourAccountButton(){
        waitForElementToBeVisible(signInButton);
        signInButton.click();
    }
}
