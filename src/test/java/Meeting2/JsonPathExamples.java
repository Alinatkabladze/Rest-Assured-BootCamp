package Meeting2;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.hasItems;

public class JsonPathExamples {
    @Test
    public void extractValueUsingPath() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/";
        RequestSpecification request = RestAssured.given();

        JsonPath jsonPath = request.queryParam("q", "London,UK")
                .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
                .get("/weather").then().log().body().extract().jsonPath().get("base");

        Assert.assertEquals(jsonPath.get("base"),"stations");

        RestAssured.given().when()
                .get("https://chercher.tech/sample/api/product/read")
                .then()
                .body("records.id[1,2]",hasItems("4361","4360"));


    }
}
