package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

public class OfferPage extends BasePage{

    @FindBy(xpath = "//span[@data-auto='userLoanAmount']")
    WebElement loanAmount;

    @FindBy(xpath = "//h2[contains(text(),'Faster')]//following::div[1]//span[@data-auto='defaultMonthlyPayment']")
    WebElement fasterPayoffMonthlyPayment;
    @FindBy(xpath = "//h2[contains(text(),'Faster')]//parent::div//parent::div/following-sibling::div//div[@data-auto='defaultLoanTerm']")
    WebElement fasterPayoffTerm;
    @FindBy(xpath = "//h2[contains(text(),'Faster')]//parent::div//parent::div/following-sibling::div//div[@data-auto='defaultLoanInterestRate']")
    WebElement fasterPayoffInterestRate;
    @FindBy(xpath = "//h2[contains(text(),'Faster')]//parent::div//parent::div/following-sibling::div//div[@data-auto='defaultAPR']")
    WebElement fasterPayoffAPR;
    @FindBy(xpath = "//h2[contains(text(),'Lower')]//following::div[1]//span[@data-auto='defaultMonthlyPayment']")
    WebElement lowerAmountMonthlyPayment;
    @FindBy(xpath = "//h2[contains(text(),'Lower')]//parent::div//parent::div/following-sibling::div//div[@data-auto='defaultLoanTerm']")
    WebElement lowerAmountTerm;
    @FindBy(xpath = "//h2[contains(text(),'Lower')]//parent::div//parent::div/following-sibling::div//div[@data-auto='defaultLoanInterestRate']")
    WebElement lowerAmountInterestRate;
    @FindBy(xpath = "//h2[contains(text(),'Lower')]//parent::div//parent::div/following-sibling::div//div[@data-auto='defaultAPR']")
    WebElement lowerAmountAPR;

    @FindBy(xpath="//label[@class='header-nav__toggle']")
    WebElement menu;

    @FindBy(xpath="//a[contains(text(),'Sign Out')]")
    WebElement signOutBtn;


    public void verifyOfferPage() {
       // wait.until(ExpectedConditions.titleIs());
        String strUrl = driver.getCurrentUrl();
        System.out.println(strUrl);
        assertTrue(strUrl.contains("offer"));
    }

    Map<String,String> fasterPayoff = new HashMap<>();
    Map<String,String> lowerAmount = new HashMap<>();
    String loanAmountValue;

    public void storeValues(){

        loanAmountValue = loanAmount.getText();
        String fasterMP = fasterPayoffMonthlyPayment.getText();
        String fasterTerm = fasterPayoffTerm.getText();
        String fasterIR = fasterPayoffInterestRate.getText();
        String fasterAPR = fasterPayoffAPR.getText();
        fasterPayoff.put("Monthly Payment", fasterMP);
        fasterPayoff.put("Term", fasterTerm);
        fasterPayoff.put("Interest Rate", fasterIR);
        fasterPayoff.put("APR", fasterAPR);
        //
        String lowerMP = lowerAmountMonthlyPayment.getText();
        String lowerTerm = lowerAmountTerm.getText();
        String lowerIR = lowerAmountInterestRate.getText();
        String lowerAPR = lowerAmountAPR.getText();
        lowerAmount.put("Monthly Payment", lowerMP);
        lowerAmount.put("Term", lowerTerm);
        lowerAmount.put("Interest Rate", lowerIR);
        lowerAmount.put("APR", lowerAPR);
    }
    public void signOut(){
        waitForElementToBeVisible(menu);
        menu.click();
        waitForElementToBeVisible(signOutBtn);
        signOutBtn.click();
    }
    public void compareLoanAmount(){
        assertEquals(loanAmountValue,loanAmount.getText());
    }
    public void compareFasterOfferValues() {
        assertEquals(fasterPayoff.get("Monthly Payment"),fasterPayoffMonthlyPayment.getText());
        assertEquals(fasterPayoff.get("Term"),fasterPayoffTerm.getText());
        assertEquals(fasterPayoff.get("Interest Rate"),fasterPayoffInterestRate.getText());
        assertEquals(fasterPayoff.get("APR"),fasterPayoffAPR.getText());
    }
    public void compareLowerOfferValues(){
        assertEquals(lowerAmount.get("Monthly Payment"),lowerAmountMonthlyPayment.getText());
        assertEquals(lowerAmount.get("Term"),lowerAmountTerm.getText());
        assertEquals(lowerAmount.get("Interest Rate"),lowerAmountInterestRate.getText());
        assertEquals(lowerAmount.get("APR"),lowerAmountAPR.getText());
    }
}
