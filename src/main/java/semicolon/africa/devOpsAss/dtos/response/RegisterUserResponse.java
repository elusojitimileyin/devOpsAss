package semicolon.africa.devOpsAss.dtos.response;

import lombok.Data;

@Data
public class RegisterUserResponse {
    private Long Id;
    private String email;
    private String message;
    private boolean loggedIn;
}
