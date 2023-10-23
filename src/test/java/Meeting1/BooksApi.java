package Meeting1;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class BooksApi {
    @BeforeMethod
    public void setup(){
        RestAssured.useRelaxedHTTPSValidation();
    }
    @Test
    public void getBooks() {
        RestAssured.
                given().
                when().
                get("https://bookstore.toolsqa.com/BookStore/v1/Books").
                then().
                assertThat()
                .body("books[0].author",equalTo("Richard E. Silverman"));
    }
    @Test
    public void getBook() {
        RestAssured.
                given().
                when().
                get("https://bookstore.toolsqa.com/BookStore/v1/Book?ISBN=9781449325862").
                then().
                assertThat()
                .body("author",equalTo("Richard E. Silverman"));
    }
    @Test
    public void getBookSecondWay() {
        RestAssured.
                given().
                param("ISBN","9781449325862").
                when().
                get("https://bookstore.toolsqa.com/BookStore/v1/Book").
                then().
                assertThat()
                .body("author",equalTo("Richard E. Silverman"));
    }
}
