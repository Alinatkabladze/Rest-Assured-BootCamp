package Meeting2;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class ExtractMethodExamples {
    @Test
    public void extractStatusCode() {
        int responseCode =
                given()
                        .header("Content-type", "application/json")
                        .when()
                        .delete("/posts/1")
                        .then()
                        .extract().statusCode();
        Assert.assertEquals(responseCode,403);
    }
    @Test
    public void extractResponse() {
        RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/";
        RequestSpecification request = RestAssured.given();

        JsonPath jsonPath = request
                .queryParam("q", "London,UK")
                .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
                .get("/weather")
                .then()
                .extract()
                .jsonPath();


        Assert.assertEquals(jsonPath.getString("base"),"stations");
        Assert.assertEquals(jsonPath.getString("wind.speed"),"4.1");
    }
    @Test
    public void extractTimeIn() {
        RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/";
        RequestSpecification request = RestAssured.given();

        long timeIn = request.queryParam("q", "London,UK")
                .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
                .get("/weather").then().log().body().extract().timeIn(TimeUnit.MILLISECONDS);

        Assert.assertEquals(3000, timeIn);
    }

}
