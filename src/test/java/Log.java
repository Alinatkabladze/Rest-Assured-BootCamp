import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Log {
    @BeforeClass
    public static void setup() {
        RestAssured.useRelaxedHTTPSValidation();
    }
    @Test
    void testLogging() {
        RestAssured.given()
                .when()
                .log()
                .uri()
                .get("https://chercher.tech/sample/api/product/read");
    }
    @Test
    void testLogging2() {
        RestAssured.given()
                .param("ISBN","9781593275846")
                .when()
                //.log().all() // after preparing request but not yet send to server
                .get("https://bookstore.toolsqa.com/BookStore/v1/Book")
                .then()
               .log().ifStatusCodeIsEqualTo(200); // after receiving the response from server
    }
}
