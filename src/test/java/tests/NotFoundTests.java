package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.BaseSpec;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class NotFoundTests extends BaseSpec {
    @DisplayName("Проверка 404")
    @Test
    void notFoundTest() {
        step("Проверка валидации статуса", () -> {
            given(userRequestSpec())
                    .when()
                    .get("h/unknown/23")
                    .then()
                    .statusCode(404);
        });
    }
}
