package API;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutUserTest {

    @Test
    public void updateUser() {

        String requestBody = "{"
                + "\"name\":\"Dipali\","
                + "\"job\":\"Software Tester\""
                + "}";

        given()
            .header("Content-Type", "application/json")
            .body(requestBody)
        .when()
            .put("https://reqres.in/api/users/2")
        .then()
            .statusCode(200)
            .header("Content-Type", containsString("application/json"))
            .body("name", equalTo("Dipali"))
            .body("job", equalTo("Software Tester"));
    }
}