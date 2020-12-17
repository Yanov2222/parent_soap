package ua.nure.user_service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.nure.entity.*;

@Log4j
@Endpoint
public class UserEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private UserRepository userRepository;

    @Autowired
    public UserEndpoint(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse authentication(@RequestPayload GetUserRequest request){
        GetUserResponse response = new GetUserResponse();
        String login = request.getLogin();
        String password = request.getPassword();
        User user = userRepository.getUser(login);
        if (user==null){
            user = new User("","","","","","");
            response.setUser(user);
            return response;
        }
        else {
            response.setUser(user);
            return response;
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postUserRequest")
    @ResponsePayload
    public PostUserResponse registration(@RequestPayload PostUserRequest request){
        PostUserResponse response = new PostUserResponse();
        User user = request.getUser();
        User generated = userRepository.saveUser(user);
        response.setId(generated.getId());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "postUpdateUserRequest")
    @ResponsePayload
    public PostUpdateUserResponse updateUser(@RequestPayload PostUpdateUserRequest request){
        PostUpdateUserResponse response = new PostUpdateUserResponse();
        User user = request.getUser();
        User generated = userRepository.updateUser(user);
        response.setId(generated.getId());
        return response;
    }

}
