import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BasicAuth {

    @Test
    public void getData() {
        RequestSpecification httpRequest = RestAssured.given()
              .auth().basic("postman", "password");
        Response res = httpRequest.get("https://postman-echo.com/basic-auth");
        res.then().log().all();
        ResponseBody body = res.body();
        //Converting the response body to string
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);
    }
    @Test
    public void getUserData() {
        //Using the preemptive directive of basic auth to send credentials to the server
        RequestSpecification httpRequest = RestAssured
                .given()
                .auth()
                .preemptive()
                .basic("postman", "password");
        Response res = httpRequest.get("https://postman-echo.com/basic-auth");
        ResponseBody body = res.body();
        //Converting the response body to string
        String rbdy = body.asString();
        System.out.println("Data from the GET API- "+rbdy);
    }
}
