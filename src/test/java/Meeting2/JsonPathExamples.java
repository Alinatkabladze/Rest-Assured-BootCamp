package Meeting2;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class JsonPathExamples {
    @Test
    public void extractValueUsingPath() {

        RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/";
        RequestSpecification request = RestAssured.given();

        JsonPath jsonPath = request.queryParam("q", "London,UK")
                .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
                .get("/weather").then().log().body().extract().jsonPath();
        System.out.println(jsonPath.get("base").equals("stations"));
        System.out.println(jsonPath.get("base").toString());

    }
}
