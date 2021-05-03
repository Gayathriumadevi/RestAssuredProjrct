package com.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class MathJSGetAPITest {


    @Test
    public void MathJS_get_api_test() {
        Response response = given()
                .header("content-type","application/json")
                .get("http://api.mathjs.org/v4/?expr=2*55");
        System.out.println("******** "+response.asString());
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());
        Assert.assertEquals(response.body().asString(),"110","Expected answer is 110 but found"+response.asString());

    }

    @Test
    public void MathJS_Get() {

        RestAssured.baseURI = "http://api.mathjs.org/";
        Response response = given()
                .header("content-type","application/json")
                .get("/v4/?expr=2*55");
        System.out.println("******** "+response.asString());
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());
        Assert.assertEquals(response.body().asString(),"110","Expected answer is 110 but found"+response.asString());

    }

    @Test
    public void GetAPI() {
        RestAssured.baseURI = "http://api.mathjs.org/";
        Response response = given()
                .header("content-type","application/json")
                .param("expr","2*55")
                .get("/v4/");
        System.out.println("******** "+response.asString());
        Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());
        Assert.assertEquals(response.body().asString(),"110","Expected answer is 110 but found"+response.asString());

    }

    @DataProvider(name = "testdata")
    public Object[][] testdatafile()
    {
        return new Object[][]
                {
                        {"1*2","2"},
                        {"1*3","3"},
                        {"1*4","4"},
                        {"1*5","5"},
                        {"1*20","20"},
                        {"1+2","3"}



                };
    }
@Test(dataProvider = "testdata")
public void GetAPI_4(String erpr,String expected) {
    RestAssured.baseURI = "http://api.mathjs.org/";
    Response response = given()
            .header("content-type","application/json")
            .param("expr","2*55")
            .get("/v4/");
    System.out.println("******** "+response.asString());
    Assert.assertEquals(response.statusCode(),200,"Expected response code is 200 but found "+response.statusCode());
    Assert.assertEquals(response.body().asString(),"110","Expected answer "+expected+"  but found"+response.asString());

}


}
