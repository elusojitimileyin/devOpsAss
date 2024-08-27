package semicolon.africa.devOpsAss.service;

import semicolon.africa.devOpsAss.dtos.requset.LoginUserRequest;
import semicolon.africa.devOpsAss.dtos.requset.RegisterUserRequest;
import semicolon.africa.devOpsAss.dtos.response.LoginUserResponse;
import semicolon.africa.devOpsAss.dtos.response.RegisterUserResponse;
import semicolon.africa.devOpsAss.model.User;

public interface UserService {
    RegisterUserResponse register(RegisterUserRequest request);
    LoginUserResponse login(LoginUserRequest loginUserRequest);

    User findUserBy(String username);
}
