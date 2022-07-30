package Meeting2;



import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

public class RequestSpecExamples {
    @Test
    public void example1() throws Exception {
        // given:
        RequestSpecification request = given()
                .header("Content-Type", "application/json")


                .body("{\"platform_instance_id\":null,\"api_info_location\":null," +
                        "\"originating_identity\":null," +
                        "\"async_accepted\":false," +
                        "\"parameters\":{},\"context\":null,\"plan_id\":\"standard\"," +
                        "\"organization_guid\":null,\"space_guid\":null," +
                        "\"service_instance_id\":null,\"service_definition\":null," +
                        "\"service_id\":\"service-one-id\"}").log().method().log().body();

        // when:
        Response response = given().spec(request)
                .put("/v2/service_instances/service-instance-one-id?accepts_incomplete=false");
        // then:
        Assert.assertEquals(200,response.statusCode());
    }

    @Test
    public void example2() {

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "chaya");
        requestParams.put("job", "BAA");
        requestParams.get("name");

        // given:
        RequestSpecification request = given()
                .header("Content-Type", "application/json")
               // .body("{\"name\":chaya,\"job\":BAA\"}"); // bad practice
                .body(requestParams);
        // when:
        Response response =
                given()
                .spec(request)
                .put("https://reqres.in/api/users/2");
        response.then()
                //.assertThat().body("updatedAt",equalTo("2022-07-30T08:49:37.283Z"))
                .log().ifStatusCodeIsEqualTo(200);

        // then:
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.header("Content-Type"),"application/json; charset=utf-8");

    }
}
