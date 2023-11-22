package tests;

import models.lombok.CreateBodyUser;
import models.lombok.UserUpdateResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.BaseSpec;
import specs.UpdateUser;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;



public class UpdateUsersTests extends BaseSpec {
    @DisplayName("Проверка обновления данных пользователя")
    @Test
    void UserUpdateTest() {
        CreateBodyUser bodyUsers = new CreateBodyUser();

        bodyUsers.setName("Ivan");
        bodyUsers.setJob("Qa Lead");

        UserUpdateResponse response = step("Отправка запроса", () ->
                given(userRequestSpec())
                        .body(bodyUsers)
                        .when()
                        .put("/users/2")
                        .then()
                        .spec(UpdateUser.updateUserResponseSpec())
                        .extract().as(UserUpdateResponse.class));
        step("Проверка response", () -> {

            assertThat(response.getName()).isEqualTo("Ivan");
            assertThat(response.getJob()).isEqualTo("Qa Lead");
            assertThat(response.getJob()).isNotNull();
        });
    }
}
