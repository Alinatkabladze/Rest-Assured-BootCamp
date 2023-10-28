import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.request.Booking;
import models.request.BookingDates;
import org.testng.annotations.Test;

public class CreateBookingTests {
    @Test
    public void getBookExamplesWithJackonAndJsonPAth() {

        RestAssured.useRelaxedHTTPSValidation();

        BookingDates bookingDates = new BookingDates();
        bookingDates.checkin = "2021-07-01";
        bookingDates.checkout = "2021-07-01";
        Booking root = new Booking();
        root.firstname = "Jim";
        root.lastname = "Brown";
        root.totalprice = 111;
        root.depositpaid = true;
        root.additionalneeds = "N";
        root.bookingdates = bookingDates;

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .contentType(ContentType.JSON)
                .body(root)
                .log()
                .body()
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200);

    }

}

