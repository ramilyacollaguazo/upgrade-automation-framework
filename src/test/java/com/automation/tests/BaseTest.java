package com.automation.tests;

import com.automation.pages.*;
import com.automation.utils.DriverUtils;
import com.automation.utils.PropertyReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    GetStartedPage getStartedPage;
    BasicInfoPage basicInfoPage;
    IncomeInfoPage incomeInfoPage;
    CreateAccountPage createAccountPage;
    OfferPage offerPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(Method test) {

        PropertyReader.initProperty();
        DriverUtils.createDriver(test);

        getStartedPage = new GetStartedPage();
        basicInfoPage = new BasicInfoPage();
        incomeInfoPage = new IncomeInfoPage();
        createAccountPage = new CreateAccountPage();
        offerPage = new OfferPage();
        loginPage = new LoginPage();

    }

    @AfterMethod
    public void cleanUp() {
        DriverUtils.getDriver().quit();
    }

}
