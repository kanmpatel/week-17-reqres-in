package in.reqres.reqresin;

import in.reqres.model.UserPagePojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateTheSecoundLoginRecord extends TestBase {
    @Test
    public void createUserLoginRecord(){
        UserPagePojo userPagePojo = new UserPagePojo();
        userPagePojo.setEmail("eve.holt@reqres.in");
        userPagePojo.setPassword("cityslicka");

        Response response = given()
                .header("Content-Type","application/json")
                .body(userPagePojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
