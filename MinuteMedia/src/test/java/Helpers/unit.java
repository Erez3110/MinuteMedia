package Helpers;

import Extensions.apiActions;
import Utilities.base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class unit
{
    String url = "https://swapi.dev/api";
    RequestSpecification httpRequest;
    Response response;
    JsonPath jp;

    @Test
    public void test()
    {
//        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type","application/json");

        response = httpRequest.get(url + "/planets/1/");
        jp = response.jsonPath();
        System.out.println(jp.get("diameter"));
        assertEquals(jp.get("diameter"),"10465");
    }
}
