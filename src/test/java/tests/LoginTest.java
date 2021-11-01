package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {

    @Test
    public void userShouldBeSuccessfulLogin() {
        given().
                body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}").
                header("Content-Type", "application/json").
                log().all().
        when().
                post("https://reqres.in/api/login").
        then().
                log().all().
                statusCode(200).
                body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void userShouldNotLoginWithoutPassword() {
        given().
                body("{\n" +
                        "    \"email\": \"peter@klaven\"\n" +
                        "}").
                header("Content-Type", "application/json").
                log().all().
        when().
                post("https://reqres.in/api/login").
        then().
                log().all().
                statusCode(400).
                body("error", equalTo("Missing password"));
    }
}
