package API;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostUserTest {

    @Test
    public void registerUser() {

        String requestBody = "{"
                + "\"email\":\"eve.holt@reqres.in\","
                + "\"password\":\"pistol\""
                + "}";

        given()
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .post("https://reqres.in/api/register")
        .then()
            .statusCode(200)
            .header("Content-Type", containsString("application/json"))
            .body("id", notNullValue())
            .body("token", notNullValue());
    }
}