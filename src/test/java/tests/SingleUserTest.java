package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SingleUserTest {

    @Test
    public void informationOfUserShouldBeCorrect() {
        given().
                header("Content-Type", "application/json").
                log().all().
        when().
                get("https://reqres.in/api/users/2").
        then().
                log().all().
                statusCode(200).
                body("data.id", equalTo(2), "data.email", equalTo("janet.weaver@reqres.in"),
                        "data.first_name", equalTo("Janet"), "data.last_name", equalTo("Weaver"),
                        "data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));
    }

    @Test
    public void notFoundErrorShouldBeHandled() {
        given().
                header("Content-Type", "application/json").
                log().all().
        when().
                get("https://reqres.in/api/users/23").
        then().
                log().all().
                statusCode(404);
    }
}
