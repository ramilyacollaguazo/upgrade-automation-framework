package com.automation.pages;

import com.automation.utils.PropertyReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BasicInfoPage extends BasePage {


    @FindBy (xpath = "//fieldset[@role='radiogroup']//label[1]//input")
    WebElement loanApplicationType;

    @FindBy (xpath = "//input[@name='borrowerFirstName']")
    WebElement firstNameInputField;

    @FindBy (xpath = "//label[contains(@id,'borrowerFirstName')]")
    WebElement firstNameInputFieldTitle;

    @FindBy (xpath = "//input[@name='borrowerLastName']")
    WebElement lastNameInputField;

    @FindBy (xpath = "//label[contains(@id,'borrowerLastName')]")
    WebElement lastNameInputFieldTitle;

    @FindBy (xpath = "//input[@name='borrowerStreet']")
    WebElement homeAddressInputField;

    WebElement homeAddressInputList1;

    @FindBy (xpath = "//label[@for='geosuggest__input--borrowerStreet']")
    WebElement homeAddressInputFieldTitle;

    @FindBy (xpath = "//input[@name='borrowerCity']")
    WebElement cityInputField;

    @FindBy (xpath = "//label[contains(@id,'borrowerCity')]")
    WebElement cityInputFieldTitle;

    @FindBy (xpath = "//input[contains(@aria-labelledby,'borrowerState')]")
    WebElement stateInputField;

    @FindBy (xpath = "//label[contains(@id,'borrowerState')]")
    WebElement stateInputFieldTitle;

    @FindBy (xpath = "//input[@name='borrowerZipCode']")
    WebElement zipCodeInputField;

    @FindBy (xpath = "//label[contains(@id,'borrowerZipCode')]")
    WebElement zipCodeInputFieldTitle;

    @FindBy (xpath = "//input[@name='borrowerDateOfBirth']")
    WebElement dateOfBirthInputField;

    @FindBy (xpath = "//label[contains(@id,'borrowerDateOfBirth')]")
    WebElement dateOfBirthInputFieldTitle;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement continueBtn;

    public void verifyBasicInfoPage(){
        String strUrl = driver.getCurrentUrl();
        assertTrue(strUrl.contains("step=contact"));
    }

    public void selectLoanApplicationType(){
        waitForElementToBeVisible(loanApplicationType);
        loanApplicationType.click();
    }

    public void enterFirstName(){
        String firstName = faker.name().firstName();
        waitForElementToBeVisible(firstNameInputField);
        assertTrue(firstNameInputFieldTitle.getText().contains("First Name"), "Incorrect label for the First Name input field");
        firstNameInputField.sendKeys(firstName);
    }

    public void enterLastName(){
        String lastName = faker.name().lastName();
        waitForElementToBeVisible(lastNameInputField);
        assertTrue(lastNameInputFieldTitle.getText().contains("Last Name"), "Incorrect label for the Last Name input field");
        lastNameInputField.sendKeys(lastName);
    }

    public void enterHomeAddress(String s, String s1, String s2, String s3){
        String streetAddress = PropertyReader.getProperty(s);
        String city = PropertyReader.getProperty(s1);
        String state = PropertyReader.getProperty(s2);
        String zipCode = PropertyReader.getProperty(s3);

        waitForElementToBeVisible(homeAddressInputField);
        assertTrue(homeAddressInputFieldTitle.getText().contains("Home Address"), "Incorrect label for the Home Address input field");
        homeAddressInputField.sendKeys(streetAddress);
        List<WebElement> addresses = driver.findElements(By.className("geosuggest__suggests"));
        homeAddressInputList1=addresses.get(0);
        waitForElementToBeVisible(homeAddressInputList1);
        homeAddressInputList1.click();

        waitForElementToBeVisible(cityInputField);
        assertTrue(cityInputFieldTitle.getText().contains("City"), "Incorrect label for the City input field");
        cityInputField.clear();
        cityInputField.sendKeys(city);

        waitForElementToBeVisible(stateInputField);
        assertTrue(stateInputFieldTitle.getText().contains("State"), "Incorrect label for the State input field");
        stateInputField.clear();
        stateInputField.sendKeys(state);


        waitForElementToBeVisible(zipCodeInputField);
        assertTrue(zipCodeInputFieldTitle.getText().contains("Zip Code"), "Incorrect label for the Zip Code input field");
        zipCodeInputField.clear();
        zipCodeInputField.sendKeys(zipCode);
    }
    public void enterDateOfBirth(String dob){

        String dateOfBirth = PropertyReader.getProperty(dob);
        waitForElementToBeVisible(dateOfBirthInputField);
        assertTrue(dateOfBirthInputFieldTitle.getText().contains("Date of Birth"), "Incorrect label for the Date of Birth input field");
        dateOfBirthInputField.sendKeys(dateOfBirth);
    }

    public void clickContinueButton(){
        waitForElementToBeVisible(continueBtn);
        continueBtn.click();

    }

}
