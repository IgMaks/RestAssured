package specs;

import io.restassured.specification.ResponseSpecification;


public class User extends BaseSpec {
    public static ResponseSpecification UserListResponseSpec() {
        return userResponseSpec(200);
    }
}
