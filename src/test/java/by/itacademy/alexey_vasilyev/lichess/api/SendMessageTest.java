package by.itacademy.alexey_vasilyev.lichess.api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class SendMessageTest extends APIBaseTest {

    @Test
    public void sendMessageTest(){
        String addressee = "taf-test2";
        String textMessage = "Hello!";

        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2(ACCESS_TOKEN)
                .param("text", textMessage)
                .when()
                .post(String.format("/inbox/%s", addressee))
                .then()
                .assertThat().statusCode(200)
                .body("ok", is(true));
    }
}
