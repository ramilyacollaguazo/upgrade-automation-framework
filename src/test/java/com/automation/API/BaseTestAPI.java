package com.automation.API;

import com.automation.utils.PropertyReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

public class BaseTestAPI {
    APIRequest apiRequest = new APIRequest();
    public Map<String,String> validPayload = new HashMap<>();
    public Map<String,String> invalidPayload = new HashMap<>();
    public void createValidPayload(){
        validPayload.put("loanAppUuid","2bc53d36-a4fb-46fd-92db-37fd7ddfeb1d");
        validPayload.put("skipSideEffects","true");
    }
    public void createInvalidPayload(){
        invalidPayload.put("loanAppUuid","2bc53d36-a4fb-46fd-92db-37fd7ddfeb7d");
        invalidPayload.put("skipSideEffects","true");
    }
    @BeforeMethod
    public void setUp() {
        PropertyReader.initProperty();
        RestAssured.baseURI = PropertyReader.getProperty("base.url");
    }
}
