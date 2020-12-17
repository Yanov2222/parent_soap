package ua.nure.user_service;


import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import ua.nure.entity.User;
import ua.nure.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;

@Log4j
@Component
public class UserRepository {
    UserService userService = new UserService();
    private List<User> list;

    @PostConstruct
    public void initData(){
        list = userService.findAll();
    }

    public User getUser(String login){
        return userService.findByLogin(login);
    }

    public User saveUser(User user){
        userService.saveUser(user);
        User tmp = userService.findByLogin(user.getLogin());
        initData();
        return tmp;
    }

    public User updateUser(User user){
        userService.update(user);
        User tmp = userService.findByLogin(user.getLogin());
        initData();
        return tmp;
    }

}
