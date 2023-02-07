package AutoGeneratedPOJOs.ResourceList;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetListSteps {
    @Test
    public void getList(){
        ResourceList response = RestAssured.given().when()
                .get("https://reqres.in/api/unknown")
                .as(ResourceList.class);

        System.out.println(response.getSupport().getText());
    }
}
