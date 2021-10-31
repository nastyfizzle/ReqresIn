package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DelayTest {

    @Test
    public void getDelayedResponse() {
        given().
                header("Content-Type", "application/json").
                log().all().
        when().
                get("https://reqres.in/api/users?delay=3").
        then().
                log().all().
                statusCode(200).
                body("total", equalTo(12));
    }
}
