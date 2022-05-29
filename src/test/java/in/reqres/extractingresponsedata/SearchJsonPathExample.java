package in.reqres.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath="/api";
        response = given()
                .queryParam("page",2)
                .when()
                .get("/users")
                .then()
                .statusCode(200);
    }


    // 1] to verify page=2
    @Test
    public void test001() {
        int page = response.extract().path("page");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of page is : " + page);
        System.out.println("------------------End of Test---------------------------");
    }
    // 2] to verify per_page = 6
    @Test
    public void test002() {
        int perPage = response.extract().path("per_page");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of perPage is : " + perPage);
        System.out.println("------------------End of Test---------------------------");
    }
    // 3] to verify data[1].id = 8
    @Test
    public void test003() {
        int id = response.extract().path("data[1].id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of 1th store is : " + id);
        System.out.println("------------------End of Test---------------------------");
    }
    // 4] to veryfy4.data[3].first_name = Byron
    @Test
    public void test004() {
        String firstName = response.extract().path("data[3].first_name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Value of firstname of data[3] : "+firstName);
        System.out.println("------------------End of Test---------------------------");
    }
    // 5] to veryfy5.list of data = 6
    @Test
    public void test005() {
        List<String> data = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The List Of  ID :"+ data.size());

        System.out.println("------------------End of Test---------------------------");
    }
    // 6] to veryfy data[5].avatar
    @Test
    public void test006() {
        List<String> wholeData = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of data list : " + wholeData.size());
        System.out.println("------------------End of Test---------------------------");
    }
    // 7. support.url :https://reqres.in/#support-heading
    @Test
    public void test007() {
        String url= response.extract().path("support.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("support of url : " + url);
        System.out.println("------------------End of Test---------------------------");
    }
    // 8. support.txt  :To keep ReqRes free, contributions towards server costs are appreciated!
    @Test
    public void test008() {
        String text = response.extract().path("support.text");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("support of text : " + text);
        System.out.println("------------------End of Test---------------------------");
    }

}
