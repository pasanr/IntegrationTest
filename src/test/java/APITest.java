import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class APITest {

    @Test
    public void api_GET_Books(){
        given().when().get("http://localhost:8081/user/books").then().statusCode(200).log()
                .all();
    }

    @Test
    public void api_GET_Search(){
        given().when().get("http://localhost:8081/user/books/search?name=ghost").then().statusCode(200).log()
                .all();
    }

    @Test
    public void api_POST_Login(){
        Map<String,String> loginPayload = new HashMap<String,String>();
        loginPayload.put("username","test");
        loginPayload.put("password","test");
        given().contentType("application/json").body(loginPayload).when().post("http://localhost:8081/login/user").then().statusCode(200).log()
                .all();
    }
}
