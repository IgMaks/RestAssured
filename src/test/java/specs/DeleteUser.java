package specs;

import io.restassured.specification.ResponseSpecification;


public class DeleteUser extends BaseSpec {
    public static ResponseSpecification deleteUserResponseSpec() {
        return userResponseSpec(204);
    }
}
