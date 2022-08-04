package Deserialize;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class GetBook {
    @Test
    public void getBookExamplesWithJackonAndJsonPAth() {
        Book book = RestAssured.given().when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Book?ISBN=9781449325862")
                .as(Book.class);

        JsonPath response = RestAssured.given().when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Book?ISBN=9781449325862").jsonPath();


        System.out.println("JsonPath "+response.getString("pages"));
        System.out.println("Custom class "+book.pages);
        System.out.println(book.isbn);
    }
    @Test
    public void getBookList() {



        BookList bookList=RestAssured.given().when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books").as(BookList.class);


        System.out.println(bookList.books.get(0).pages);
    }

}

