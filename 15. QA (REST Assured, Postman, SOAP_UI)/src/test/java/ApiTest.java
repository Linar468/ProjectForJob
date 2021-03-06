/**
 * Отправка REST-запросов на Json-сервер (localhost:3000)
 * Валидация Json-схемы
 * Запуск сервера:  1) npm install -g json-server
 *                  2) json-server --watch db.json
 */

import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.jayway.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ApiTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiTest.class);
    private static JSONObject requestParams = new JSONObject();

    @Test
    @Order(2)
    public void getSecondPosts() {
        when().
                get("http://localhost:3000/posts/2").
                then().
                statusCode(200).
                assertThat().body("author", equalTo("Linar"), "id", equalTo("2"));
        Response response = get("http://localhost:3000/posts/2");
        LOGGER.info("Second post has data: " + response.getBody().asString());
    }

    @Test
    @Order(1)
    public void postNewPost() {
        requestParams.put("id", "2");
        requestParams.put("title", "Second");
        requestParams.put("author", "Linar");
        given().
                contentType("application/json").body(requestParams.toString()).
                when().
                post("http://localhost:3000/posts").
                then().
                statusCode(201);
        LOGGER.info("New post has been added." + "\n");

        when().
                get("http://localhost:3000/posts/2").
                then().
                statusCode(200).
                assertThat().body("author", equalTo("Linar"));
        Response response = get("http://localhost:3000/posts/2");
        LOGGER.info("New post has data: " + response.getBody().asString());
    }

    @Test
    @Order(3)
    public void changeThePost() {
        given().
                contentType("application/json").body("{\n" +
                "      \"id\": 2,\n" +
                "      \"title\": \"second\",\n" +
                "      \"author\": \"noname\"\n" +
                "    }\n").
                when().
                put("http://localhost:3000/posts/2").
                then().
                statusCode(200);
        LOGGER.info("Post has been edited." + "\n");

        when().
                get("http://localhost:3000/posts/2").
                then().
                statusCode(200).
                assertThat().body("title", equalTo("second"))
                .body("author", equalTo("noname"));
        Response response = get("http://localhost:3000/posts/2");
        LOGGER.info("New data is : " + response.getBody().asString());
    }

    @Test
    @Order(4)
    public void deleteThePost() {
        when().
                delete("http://localhost:3000/posts/2").
                then().
                statusCode(200).
                assertThat().body("{}", Matchers.nullValue());
        LOGGER.info("Post has been deleted .");
    }

    @Test
    public void checkJSONSchemaValidation() {
        get("http://localhost:3000/posts/1").then().assertThat()
                .body(matchesJsonSchemaInClasspath("postSchema.json"));
    }

    @Test
    public void checkJSONSchemaValidationWithDraftVersion() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory
                .newBuilder()
                .setValidationConfiguration(
                        ValidationConfiguration.newBuilder()
                                .setDefaultVersion(SchemaVersion.DRAFTV4)
                                .freeze()).freeze();

        get("http://localhost:3000/posts/1")
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("postSchema.json").using(
                        jsonSchemaFactory));
    }
}
