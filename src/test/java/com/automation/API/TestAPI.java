package com.automation.API;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.json.JSONObject;

import static org.testng.Assert.assertEquals;

public class TestAPI extends BaseTestAPI{

    //1 Validate that for correct loanAppUuid provided in the payload below, the API response code is a 200 (OK)
    @Test
    public void testStatusCodeOK(){
        createValidPayload();
        Response response = apiRequest.postCall(validPayload);
        assertEquals(response.getStatusCode(),200);
    }
    //2 For the above use case, parse each json value in the response payload individually.
    // Then validate the productType attribute has value PERSONAL_LOAN
    @Test
    public void testAttributeValue(){
        createValidPayload();
        Response response = apiRequest.postCall(validPayload);
        assertEquals(response.getStatusCode(),200);

        JSONObject responseBody = new JSONObject(response.getBody().asString());
        for(String key: responseBody.keySet()){
            if(key.equals("productType")){
                assertEquals(responseBody.get(key),"PERSONAL_LOAN");
            }
        }
    }
    //3 Validate that in the initial POST request, if a different loanAppUuid is provided (that doesn't exist in our system) -
    // the API response is a 404 (NOT_FOUND)
    @Test
    public void testStatusCodeNotFound(){
        createInvalidPayload();
        Response response = apiRequest.postCall(invalidPayload);
        assertEquals(response.getStatusCode(),404);
    }
}
