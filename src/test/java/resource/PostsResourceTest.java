package resource;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class PostsResourceTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost:8080/kwetter";
    }

    @Test
    public void index() {
        Response response = RestAssured.get("/posts");
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void show() {
        Response response = RestAssured.get("/posts/1");
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void showUserPosts() {
        Response response = RestAssured.get("/posts/user/1");
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void create() {
        String actual = "This is a new tweet";
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("content", actual);

        Response response = RestAssured.given()
                .header("apikey", "1")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(jsonAsMap).post("/posts");
        int statusCode = response.getStatusCode();

        String content = response.jsonPath().get("content");
        Assert.assertEquals(content, actual);
        Assert.assertEquals(statusCode, 200);
    }
}