package Meeting4_Soap;

import io.restassured.internal.path.xml.NodeChildrenImpl;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;


import org.testng.Assert;


import io.restassured.RestAssured;


import io.restassured.http.ContentType;


import static io.restassured.RestAssured.*;




public class GetXmlTest {


    @BeforeClass


    public void setBaseUri () {




        RestAssured.baseURI = "https://maps.googleapis.com";


    }




    @Test


    public void test () {




        NodeChildrenImpl res=given ().param ("query", "Churchgate Station")


                .param ("key", "Xyz")


                .when ()


                .get ("/maps/api/place/textsearch/xml")


                .then ()


                .contentType(ContentType.XML)


                .extract()


                .path("placesearchresponse.result[0].formatted_address");




        Assert.assertEquals (res, "Maharshi Karve Rd, Churchgate, Mumbai, Maharashtra 400020");





    }




}

