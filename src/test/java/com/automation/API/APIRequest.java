package com.automation.API;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class APIRequest {
    Gson gson = new Gson();
    public Response postCall(Map<String, String> bodyPayload){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .headers("x-cf-source-id","coding-challenge",
                "x-cf-corr-id","b8096ec7-2150-405f-84f5-ae99864b3e96",
                "Content-Type", "application/json")
                .body(gson.toJson(bodyPayload))
                .when()
                .post("/byLeadSecret");
    }
}
