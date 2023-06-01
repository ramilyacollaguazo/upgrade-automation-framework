package com.automation.pages;

import com.automation.utils.PropertyReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetStartedPage extends BasePage {
    @FindBy(xpath = "//h2")
    WebElement getStartedPageHeader;
    @FindBy(xpath="//span[@role='button']")
    WebElement closePopUpBtn;

    @FindBy(xpath = "//input[@name='desiredAmount']")
    WebElement loanAmountInput;

    @FindBy(xpath = "//label[contains(@id,'desiredAmount')]")
    WebElement loanAmountTitle;

    @FindBy(xpath = "//select")
    WebElement loanPurposeDropdown;

    @FindBy(xpath = "//label[@class = 'sc-bWOGAC sc-dkBdza hTxaXC dpQlpe']")
    WebElement loanPurposeDropdownTitle;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement checkYourRateBtn;



    public void verifyGetStartedPage(){
        String expHeader = "Get Started Here";
        String actHeader = getStartedPageHeader.getText();
        assertEquals(expHeader,actHeader);
    }
    public void enterLoanAmount(String loanAmount) {
        closePopUpBtn.click();
        waitForElementToBeVisible(loanAmountInput);
        assertTrue(isPresent(loanAmountInput));
        assertTrue(loanAmountTitle.getText().contains("Loan Amount ($1,000 to $50,000)"), "Incorrect label for the Loan Amount input field");
        loanAmountInput.sendKeys(PropertyReader.getProperty(loanAmount));
    }

    public void selectLoanPurpose(String loanPurpose) {
        waitForElementToBeVisible(loanPurposeDropdown);
        assertTrue(loanPurposeDropdownTitle.getText().contains("Loan Purpose"), "Incorrect label for the Loan Purpose dropdown");
        Select dropdown = new Select(loanPurposeDropdown);
        dropdown.selectByVisibleText(PropertyReader.getProperty(loanPurpose));
    }

    public void clickCheckYourRateButton() {
        waitForElementToBeVisible(checkYourRateBtn);
        checkYourRateBtn.click();
    }

}
