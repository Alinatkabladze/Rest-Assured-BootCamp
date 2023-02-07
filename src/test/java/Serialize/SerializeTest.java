package Serialize;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class SerializeTest {
    @Test
    public void getBookExamplesWithJackonAndJsonPAth() {

       /* Map<String,Object> jsonBodyUsingMap = new HashMap<String,Object>();
        jsonBodyUsingMap.put("firstname", "Jim");
        jsonBodyUsingMap.put("lastname", "Brown");
        jsonBodyUsingMap.put("totalprice", 111);
        jsonBodyUsingMap.put("depositpaid", true);*/
        BookingDates bookingDates = new BookingDates();
        bookingDates.checkin = "2021-07-01";
        bookingDates.checkout = "2021-07-01";
        Root root = new Root();
        root.firstname = "Jim";
        root.lastname = "Brown";
        root.totalprice = 111;
        root.depositpaid = true;
        root.additionalneeds = "N";
        root.bookingdates =  bookingDates;

       /* Map<String,String> bookingDatesMap = new HashMap<String,String>();
        bookingDatesMap.put("checkin", "2021-07-01");
        bookingDatesMap.put("checkout", "2021-07-01");*/


    /*    jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");*/


        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .contentType(ContentType.JSON)
                .body(root)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200);

    }

    }

