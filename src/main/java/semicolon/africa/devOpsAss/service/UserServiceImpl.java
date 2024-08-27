package semicolon.africa.devOpsAss.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.africa.devOpsAss.dtos.requset.LoginUserRequest;
import semicolon.africa.devOpsAss.dtos.requset.RegisterUserRequest;
import semicolon.africa.devOpsAss.dtos.response.LoginUserResponse;
import semicolon.africa.devOpsAss.dtos.response.RegisterUserResponse;
import semicolon.africa.devOpsAss.model.User;
import semicolon.africa.devOpsAss.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse register(RegisterUserRequest request) {
        if (userRepository.findByEmail(request.getEmail()) != null) {
            throw new RuntimeException("A user with email " + request.getEmail() + " already exists.");
        }

        User user = new User();
        BeanUtils.copyProperties(request, user);

        User savedUser = userRepository.save(user);

        RegisterUserResponse response = new RegisterUserResponse();
        BeanUtils.copyProperties(savedUser, response);
        response.setMessage("User registered successfully.");

        return response;
    }


    @Override
    public User findUserBy(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User with email " + email + " not found");
        }
        return user;
    }

    @Override
    public LoginUserResponse login(LoginUserRequest loginUserRequest) {
        User user = findUserBy(loginUserRequest.getEmail());
        if (!user.getPassword().equals(loginUserRequest.getPassword())) {
            throw new RuntimeException("Invalid credentials.");
        }
        LoginUserResponse response = new LoginUserResponse();
        BeanUtils.copyProperties(user, response);
        response.setMessage("Logged in successfully.");
        return response;
    }

}
