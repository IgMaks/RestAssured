package tests;

import models.lombok.UserResponseData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.BaseSpec;
import specs.User;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTests extends BaseSpec {

    @DisplayName("Проверка данных пользователя")
    @Test
    void getUser() {
        UserResponseData response = step("Отправка запроса", () ->
                given(userRequestSpec())
                        .when()
                        .get("/users/2")
                        .then()
                        .spec(User.UserListResponseSpec())
                        .extract().as(UserResponseData.class));
        step("Проверка данных пользвателя", () -> {


            assertThat(response.getData().getFirstName()).isEqualTo("Janet");
            assertThat(response.getData().getLastName()).isEqualTo("Weaver");
            assertThat(response.getData().getEmail()).isEqualTo("janet.weaver@reqres.in");
            assertThat(response.getData().getAvatar()).isEqualTo("https://reqres.in/img/faces/2-image.jpg");
            assertThat(response.getData().getId()).isNotNull();
            assertThat(response.getSupport().getUrl()).isEqualTo("https://reqres.in/#support-heading");
            assertThat(response.getSupport().getText()).isEqualTo("To keep ReqRes free, contributions towards server costs are appreciated!");

        });

    }
}
