import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.lessThan;

public class JsonObjectExample {
    @Test
    public void CreatingNestedJsonObjectTest()
    {
        String objectAlternative = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("firstname", "Jim");
        jsonObject.put("lastname", "Brown");
        jsonObject.put("totalprice", 111);
        jsonObject.put("depositpaid", true);

        JSONObject bookingDatesMap =new JSONObject();
        bookingDatesMap.put("checkin", "2021-07-01");
        bookingDatesMap.put("checkout", "2021-07-01");

        jsonObject.put("bookingdates", bookingDatesMap);
        jsonObject.put("additionalneeds", "Breakfast");


        //GIVEN
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .contentType(ContentType.JSON)
                .body(jsonObject)
                .log()
                .all()
                // WHEN
                .when()
                .post()
                // THEN
                .then()
                .assertThat()
                .statusCode(200)
                .log()
                .ifStatusCodeMatches(lessThan(300));
    }

}
