package com.restassured;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

//import javax.xml.ws.Response;

public class MathJSPostAPITest {

    @Test
    public void mathapi_post_testCase001() {
        RestAssured.baseURI = "http://api.mathjs.org/";
        String reqBody = "{\n" +
                "    \"expr\": [\n" +
                "      \"a = 1.2 * (2 + 4.5)\"\n" +
                "      \n" +
                "    ],\n" +
                "    \"precision\": 14\n" +
                "  }";
        Response postResponse = (Response) given()
                .header("content-type","application/json")
                .body(reqBody)
                .post("/v4/");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(),200,"Expected 200"+postResponse.getStatusCode());

    }

    @Test
    public void mathapi_post_testCase002() {
        RestAssured.baseURI = "http://api.mathjs.org/";
        String reqBody ="{\n" +
                "    \"expr\": [\n" +
                "      \"b = [-1, 2; 3, 1]\"\n" +
                "      \n" +
                "    ],\n" +
                "    \"precision\": 14\n" +
                "  }";
        Response postResponse = (Response) given()
                .header("content-type","application/json")
                .body(reqBody)
                .post("/v4/");
        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.getBody().asString());
        Assert.assertEquals(postResponse.getStatusCode(),200,"Expected 200"+postResponse.getStatusCode());

    }


}
