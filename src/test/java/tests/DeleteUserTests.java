package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.BaseSpec;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class DeleteUserTests extends BaseSpec {
    @DisplayName("Проверка метода удаления пользователя")
    @Test
    void deleteUserTest() {
        step("Удаление пользователя ", () -> {
            given(userRequestSpec())
                    .when()
                    .delete("/users/2")
                    .then()
                    .statusCode(204);
        });
    }
}
