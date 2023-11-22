package models.lombok;

import lombok.Data;

@Data
public class CreateUserResponse {
    private String name, job, createdAt;
    private Integer id;
}
