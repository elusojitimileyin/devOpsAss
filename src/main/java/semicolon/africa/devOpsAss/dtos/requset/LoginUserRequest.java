package semicolon.africa.devOpsAss.dtos.requset;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String email;
    private String password;
}
