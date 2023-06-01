package com.automation.pages;

import com.automation.utils.PropertyReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateAccountPage extends BasePage {

    @FindBy (xpath = "//label[contains(@id,'username')]")
    WebElement emailAddressTitle;
    @FindBy (xpath = "//input[@name='username']")
    WebElement emailAddressInput;
    @FindBy (xpath = "//label[contains(@id,'password')]")
    WebElement passwordTitle;
    @FindBy (xpath = "//input[@name='password']")
    WebElement passwordInput;
    @FindBy (xpath = "//input[@type='checkbox']//following::div[1]")
    WebElement agreeToTermsCheckBox;
    @FindBy (xpath = "//button[@type='submit']")
    WebElement checkYourRateBtn;

    public void verifyCreateAccountPage() {
        String strUrl = driver.getCurrentUrl();
        System.out.println(strUrl);
        assertTrue(strUrl.contains("step=login"));
    }

    public void enterEmail(String email) {
        waitForElementToBeVisible(emailAddressInput);
        assertTrue(emailAddressTitle.getText().contains("Email Address"), "Incorrect label for the Email Address input field");
        emailAddressInput.sendKeys(PropertyReader.getProperty(email));
    }

    public void enterPassword(String password) {
        waitForElementToBeVisible(passwordInput);
        assertTrue(passwordTitle.getText().contains("Password"), "Incorrect label for the Password input field");
        passwordInput.sendKeys(PropertyReader.getProperty(password));
    }

    public void clickAgreeToTermsCheckbox() {
        waitForElementToBeVisible(agreeToTermsCheckBox);
        agreeToTermsCheckBox.click();
    }

    public void clickCheckYourRateBtn() {
        waitForElementToBeVisible(checkYourRateBtn);
        checkYourRateBtn.click();
    }
}
