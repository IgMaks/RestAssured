package models.lombok;

import lombok.Data;

@Data
public class UserUpdateResponse {
    private String name, job, updatedAt;
}
