import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.response.Book;
import models.response.BookList;
import models.response.NotValidISBN;
import org.testng.annotations.Test;

public class GetBookTests {
    @Test
    public void getBookExamplesWithJackonAndJsonPAth() {
        RestAssured.useRelaxedHTTPSValidation();

        Response response = RestAssured.given()
                .queryParam("ISBN", "9781449325862")
                .when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Book");


        if (response.statusCode() == 400) {
            NotValidISBN notValidISBN = response.as(NotValidISBN.class);
            System.out.println(notValidISBN.getCode());
        } else if (response.statusCode() == 200) {
            Book book = response.as(Book.class);
            System.out.println(book.title);
        }
    }

    @Test
    public void getBookList() {


        BookList bookList = RestAssured.given().when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books").as(BookList.class);


        System.out.println(bookList.books.get(0).pages);
    }

}

