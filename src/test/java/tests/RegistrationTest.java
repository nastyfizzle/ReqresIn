package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RegistrationTest {

    @Test
    public void userShouldBeSuccessfulRegistered() {
        given().
                body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"pistol\"\n" +
                        "}").
                header("Content-Type", "application/json").
                log().all().
        when().
                post("https://reqres.in/api/register").
        then().
                log().all().
                statusCode(200).
                body("id", equalTo(4), "token", equalTo("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void userShouldNotBeRegisteredWithoutPassword() {
        given().
                body("{\n" +
                        "    \"email\": \"sydney@fife\"\n" +
                        "}").
                header("Content-Type", "application/json").
                log().all().
        when().
                post("https://reqres.in/api/register").
        then().
                log().all().
                statusCode(400).
                body("error", equalTo("Missing password"));
    }
}
