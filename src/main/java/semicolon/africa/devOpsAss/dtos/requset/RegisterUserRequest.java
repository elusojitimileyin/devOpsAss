package semicolon.africa.devOpsAss.dtos.requset;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String email;
    private String password;
}
