package Deserialize;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetBook {
    @Test
    public void getBookExamplesWithJackonAndJsonPAth() {
        Response response = RestAssured.given().when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Book?ISBN=9781449325862");


        if(response.statusCode()==400){
           NotValidISBN notValidISBN = response.as(NotValidISBN.class);
            System.out.println(notValidISBN.getCode());
        }
        else if(response.statusCode()==200){
            Book book=response.as(Book.class);
            System.out.println(book.title);
        }
    }
    @Test
    public void getBookList() {



        BookList bookList=RestAssured.given().when()
                .get("https://bookstore.toolsqa.com/BookStore/v1/Books").as(BookList.class);


        System.out.println(bookList.books.get(0).pages);
    }

}

