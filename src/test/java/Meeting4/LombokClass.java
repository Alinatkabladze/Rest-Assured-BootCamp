package Meeting4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LombokClass {
    WithLombokUser user ;
    public Response sendRequest(RequestSpecification spec){
        return  given()
                .filter(new AllureRestAssured())
                .baseUri("https://restful-booker.herokuapp.com/booking")
                .contentType(ContentType.JSON)
                .spec(spec)
                .when()
                .post();
    }

    public String getJsonData() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        user = new WithLombokUser();
        user.setFirstName("Irina");
        user.setLastName("Inashvili");
        user.setTotalPrice(100);
        System.out.println(mapper.writeValueAsString(user));
        return mapper.writeValueAsString(user);
    }
    public RequestSpecification getRequestSpec(String jsonData){
        return new RequestSpecBuilder()
                .setBody(jsonData).build();
    }

    @Test
    public void getResponse() throws JsonProcessingException {
        RequestSpecification spec = getRequestSpec(getJsonData());
        Response response = sendRequest(spec);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(user.getFirstName(),"Irina");
    }
}
