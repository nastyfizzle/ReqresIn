package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ListUsersTest {

    @Test
    public void amountOfUsersShouldBeCorrect() {
        given().
                header("Content-Type", "application/json").
                log().all().
        when().
                get("https://reqres.in/api/users?page=2").
        then().
                log().all().
                statusCode(200).
                body("total", equalTo(12));
    }
}
