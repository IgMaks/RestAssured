package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;


public class CreateUsersTests extends TestBase {
    @Test
    void successUserCreate() {
        String authBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        given()
                .log().uri()
                .log().method()
                .log().body()
                .body(authBody)
                .contentType(JSON)
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"));

    }

    @Test
    void successUserUpdate() {
        String authBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"Boss\"\n" +
                "}";
        given()
                .log().uri()
                .log().method()
                .log().body()
                .body(authBody)
                .contentType(JSON)
                .when()
                .patch("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("Boss"));

    }

    @Test
    void getUserList() {

        given()
                .log().uri()
                .log().method()
                .contentType(JSON)
                .when()
                .get("/users?page=2")
                .then()
                .log().body()
                .log().status()
                .statusCode(200)
                .body("per_page", is(6))
                .body("total", is(12))
                .body("total_pages", is(2))
                .body("page",is(2))
                .body("data[0].id", is(7))
                .body("data[0].first_name",is("Michael"))
                .body("data[0].email",is("michael.lawson@reqres.in"))
                .body("data[0].last_name",is("Lawson"));

    }
    @Test
    void deleteUser() {

        given()
                .log().uri()
                .log().method()
                .contentType(JSON)
                .when()
                .delete("/users/2")
                .then()
                .log().body()
                .log().status()
                .statusCode(204);

    }
    @Test
    void notFoundCheck() {

        given()
                .log().uri()
                .log().method()
                .contentType(JSON)
                .when()
                .get("/unknown/23")
                .then()
                .log().body()
                .log().status()
                .statusCode(404);

    }
}
