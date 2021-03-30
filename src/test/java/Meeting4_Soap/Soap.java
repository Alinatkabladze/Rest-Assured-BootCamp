package Meeting4_Soap;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import java.io.FileInputStream;
import java.io.IOException;
import static org.hamcrest.Matchers.*;

public class Soap {
    @Test
    public void readXml() throws IOException {
        FileInputStream stream=new FileInputStream("src\\main\\resources\\test.xml");
        RestAssured.baseURI="http://currencyconverter.kowabunga.net";

        given().header("Content-Type","text/xml")
                .and().body(IOUtils.toString(stream,"UTF-8"))
                .when().post("/converter.asmx").then().assertThat().statusCode(200)
                .and().body(hasXPath("/Description",containsString("Alina")));



    }

}
