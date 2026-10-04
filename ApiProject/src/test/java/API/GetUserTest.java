package API;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUserTest {

    @Test
    public void getUsers() {

        given()
        .when()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .header("Content-Type", containsString("application/json"))
            .body("data", not(empty()));
    }
}