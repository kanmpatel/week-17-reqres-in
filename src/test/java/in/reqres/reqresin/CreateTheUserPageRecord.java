package in.reqres.reqresin;

import in.reqres.model.UserPagePojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateTheUserPageRecord extends TestBase {
    @Test
    public void createUserPageRecord(){
        UserPagePojo userPagePojo = new UserPagePojo();
        userPagePojo.setName("john");
        userPagePojo.setJob("smit");

        Response response = given()
                .header("Content-Type","application/json")
                .body(userPagePojo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
