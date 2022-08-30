package by.itacademy.alexey_vasilyev.lichess.api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class GetAccountDataTest extends APIBaseTest{
    @Test
    public void getProfileDataTest(){
        String username = "taf-test1";

        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(ACCESS_TOKEN)
                .when()
                .get("/api/account")
                .then()
                .assertThat().statusCode(200)
                .body("id", is(username))
                .body("username", is(username));
    }
}
