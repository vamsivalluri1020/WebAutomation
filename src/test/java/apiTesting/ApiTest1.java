package apiTesting;
 import static io.restassured.RestAssured.*;

public class ApiTest1 {
    public static void main(String[] args) {
        given().baseUri("")
                .when().get()
                .then().log().body();


    }
}
