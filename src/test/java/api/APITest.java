package api;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice.api.Client;
import practice.api.Request;
import practice.api.RequestRepo;
import practice.api.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class APITest {

    ResponseSpecification checkStatusCodeAndContentType =
            new ResponseSpecBuilder().
                    expectStatusCode(200).
                    expectContentType(ContentType.JSON).
                    build();

    @Test
    public void apiTest(){

        //prepare
        given()
                .pathParam("year","2017")

        //execute
       .when().
                get("http://ergast.com/api/f1/{year}/circuits.json").

        //validate
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(20))
                .and()
                .spec(checkStatusCodeAndContentType);
    }

    @Test
    public void customAPITest(){
        // prepare
        Request request = RequestRepo.getPostman();

        //execute
        Response response=new Client().send(request);

        //validate
        Assert.assertEquals(response.getStatusCode().intValue(),200,"invalid code");
    }
}
