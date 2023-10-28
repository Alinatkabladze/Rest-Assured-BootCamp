import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Crud {

    @BeforeClass
    public static void setup() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void deleteRequest() {
        int response =
                given()
                .header("Content-type", "application/json")
                .when()
                .delete("/posts/1")
                .then()
                .extract().statusCode();
        Assert.assertEquals(400, response);
    }


    @Test
    public void submitForm() {
        RestAssured.baseURI = "https://www.example.com";
        given().urlEncodingEnabled(true)
                .param("username", "user@site.com")
                .param("password", "Pas54321")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/login")
                .then().statusCode(200);
    }


    @Test
    public void test2() {
        JSONObject request = new JSONObject();
        request.put( "name", "morpheus");
        request.put( "job","leader");

        given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().log().body().statusCode(201);

    }
    @Test
    public void test3() {

        JSONObject request = new JSONObject();
        request.put("name", "chaya");
        request.put("job", "BAA");

        given().
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").
                then().statusCode(200);

    }

    @Test
    public void test4() {

        JSONObject request = new JSONObject();
        given().
                body(request.toJSONString()).
                when().
                delete("https://reqres.in/api/users/2").
                then().statusCode(204).
                log().ifStatusCodeIsEqualTo(204);

    }
}
