package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CRUDTest {

    @Test
    public void userShouldBeCreated() {
        given().
                body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}").
                header("Content-Type", "application/json").
                log().all().
        when().
                post("https://reqres.in/api/users").
        then().
                log().all().
                statusCode(201).
                body("name", equalTo("morpheus"), "job", equalTo("leader"));
    }

    @Test
    public void userShouldBeUpdatedUsingPut() {
        given().
                body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}").
                header("Content-Type", "application/json").
                log().all().
        when().
                put("https://reqres.in/api/users/2").
        then().
                log().all().
                statusCode(200).
                body("name", equalTo("morpheus"), "job", equalTo("zion resident"));
    }

    @Test
    public void userShouldBeUpdatedUsingPatch() {
        given().
                body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}").
                header("Content-Type", "application/json").
                log().all().
        when().
                patch("https://reqres.in/api/users/2").
        then().
                log().all().
                statusCode(200).
                body("name", equalTo("morpheus"), "job", equalTo("zion resident"));
    }

    @Test
    public void userShouldBeDeleted() {
        given().
                header("Content-Type", "application/json").
                log().all().
        when().
                delete("https://reqres.in/api/users/2").
        then().
                log().all().
                statusCode(204);
    }
}
