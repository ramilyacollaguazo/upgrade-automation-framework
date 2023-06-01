package com.automation.tests;

import org.testng.annotations.Test;

public class GetOfferTest extends BaseTest {

    @Test
    public void verifyUserCanGetOffer() {
        getStartedPage.verifyGetStartedPage();
        getStartedPage.enterLoanAmount("loan.amount");
        getStartedPage.selectLoanPurpose("loan.purpose");
        getStartedPage.clickCheckYourRateButton();

        basicInfoPage.verifyBasicInfoPage();
        basicInfoPage.enterFirstName();
        basicInfoPage.enterLastName();
        basicInfoPage.enterHomeAddress("street.address", "city", "state", "zipcode");
        basicInfoPage.enterDateOfBirth("dateOfBirth");
        basicInfoPage.clickContinueButton();

        incomeInfoPage.verifyIncomeInfoPage();
        incomeInfoPage.enterAnnualIncome("annual.income");
        incomeInfoPage.enterAdditionalIncome("additional.income");
        incomeInfoPage.clickContinueBtn();

        createAccountPage.verifyCreateAccountPage();
        createAccountPage.enterEmail("email");
        createAccountPage.enterPassword("password");
        createAccountPage.clickAgreeToTermsCheckbox();
        createAccountPage.clickCheckYourRateBtn();

        //offerPage.verifyOfferPage();
        offerPage.storeValues();
        offerPage.signOut();

        loginPage.navigateToURL("login.url");
        loginPage.verifyLoginPage();
        loginPage.login("email", "password");
        loginPage.clickSignInToYourAccountButton();

       // offerPage.verifyOfferPage();
        offerPage.compareLoanAmount();
        offerPage.compareFasterOfferValues();
        offerPage.compareLowerOfferValues();
    }
}
