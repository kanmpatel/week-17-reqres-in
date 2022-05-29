package in.reqres.reqresin;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetUserGivenById extends TestBase {
    @Test
    public void getSingleUser(){
        Response response = given()
                .pathParam("id",2)
                .when()
                .get("/users/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
