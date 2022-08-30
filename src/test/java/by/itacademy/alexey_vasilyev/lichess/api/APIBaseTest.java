package by.itacademy.alexey_vasilyev.lichess.api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public abstract class APIBaseTest {

    protected final static String ACCESS_TOKEN = "lip_V9OtpgcbLh3642JomfRp";
    @BeforeTest
    public void setup() {
        RestAssured.baseURI = "https://lichess.org/";
    }
}
