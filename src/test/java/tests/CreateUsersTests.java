package tests;

import models.lombok.CreateBodyUser;
import models.lombok.CreateUserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.BaseSpec;
import specs.CreatedUser;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;



public class CreateUsersTests extends BaseSpec {
    @DisplayName("Проверка response при создании пользователя")
    @Test
    void successUserCreateTest() {
        CreateBodyUser bodyUsers = new CreateBodyUser();

        bodyUsers.setName("Ivan");
        bodyUsers.setJob("Qa auto");

        CreateUserResponse response = step("Отправка запроса", () ->
                given(userRequestSpec())
                        .body(bodyUsers)
                        .when()
                        .post("/users")
                        .then()
                        .spec(CreatedUser.createdUserResponseSpec())
                        .extract().as(CreateUserResponse.class));
        step("Проверка создания пользователя", () -> {
            assertThat(response.getName()).isEqualTo("Ivan");
            assertThat(response.getJob()).isEqualTo("Qa auto");
            assertThat(response.getId()).isNotNull();
        });
    }
}