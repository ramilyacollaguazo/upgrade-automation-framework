package com.automation.pages;

import com.automation.utils.PropertyReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IncomeInfoPage extends BasePage{

    @FindBy (xpath = "//label[contains(@id,'borrowerIncome')]")
    WebElement individualAnnualIncomeTitle;
    @FindBy (xpath = "//input[@name='borrowerIncome']")
    WebElement individualAnnualIncomeInput;
    @FindBy (xpath = "//label[contains(@id,'borrowerAdditionalIncome')]")
    WebElement additionalAnnualIncomeTitle;
    @FindBy (xpath = "//input[@name='borrowerAdditionalIncome']")
    WebElement additionalAnnualIncomeInput;
    @FindBy (xpath = "//button[text()='Continue']")
    WebElement continueBtn;

    public void verifyIncomeInfoPage() {
        String strUrl = driver.getCurrentUrl();
        assertTrue(strUrl.contains("step=income"));
    }

    public void enterAnnualIncome(String annualIncome) {
        waitForElementToBeVisible(individualAnnualIncomeInput);
        assertTrue(individualAnnualIncomeTitle.getText().contains("Individual Annual Income"), "Incorrect label for the Individual Annual Income input field");
        individualAnnualIncomeInput.sendKeys(PropertyReader.getProperty(annualIncome));
    }

    public void enterAdditionalIncome(String additionalIncome) {
        waitForElementToBeVisible(additionalAnnualIncomeInput);
        assertTrue(additionalAnnualIncomeTitle.getText().contains("Additional Annual Income"), "Incorrect label for the Additional Annual Income input field");
        additionalAnnualIncomeInput.sendKeys(PropertyReader.getProperty(additionalIncome));
    }

    public void clickContinueBtn() {
        continueBtn.click();
    }
}
