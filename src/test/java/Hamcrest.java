import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Hamcrest {

    @Test
    public void test_NumberOfCircuits_ShouldBe20_Parameterized() {

        String season = "2017";
        int numberOfRaces = 20;

        given().
                pathParam("raceSeason",season).
                when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitName[0]",equalTo("Albert Park Grand Prix Circuit"));
    }

    @Test
    void test2() {
        String season = "2017";

        given().
                pathParam("raceSeason",season).
                when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits",empty());
    }
    @Test
    void testWithSoftAssertion() {
        String season = "2017";

        given().
                pathParam("raceSeason",season).
                when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
                then().
                assertThat()
                .body("MRData.CircuitTable.Circuits.circuitName[0,1]",
                        hasItems("Albert Park Grand Prix Circuit","Circuit of the 87454")
                ,"MRData.CircuitTable.Circuits[0]",
                        hasKey("4444"));

    }


    @Test
    void test4(){
        String season = "2017";

        given().
                pathParam("raceSeason",season)
        .log().all().
                when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
                then().
                body("MRData.CircuitTable.Circuits.circuitName[0,1]",
                        anyOf(hasItems("Albert Park Grand Prix Circuit",
                                        "Circuit of the Americas")
                                ,hasItems("123","888")));

    }
    @Test
    void testForHasEntry(){
        String season = "2017";

        given().
                pathParam("raceSeason",season)
                .log().all().
                when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
                then().
                body("MRData.CircuitTable.Circuits[0].circuitId",
                                        equalTo("albert_park"));

    }
}

