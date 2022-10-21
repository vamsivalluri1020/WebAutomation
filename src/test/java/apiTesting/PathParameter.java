package apiTesting;

import java.util.Scanner;
import static io.restassured.RestAssured.*;

public class PathParameter {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter path Parameter value");
        String id=sc.nextLine();
        sc.close();
        //Paramerterize path parameter value in URI
        given().baseUri("https://jsonplaceholder.typicode.com/posts/"+id)
                .when().get()
                .then().log().status().statusCode(200);

    }
}
