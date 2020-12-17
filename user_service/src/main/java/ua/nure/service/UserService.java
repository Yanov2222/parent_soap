package ua.nure.service;

import ua.nure.dao.UserDao;
import ua.nure.entity.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();

    public UserService(){

    }

    public User findByLogin(String login){
        return userDao.findByLogin(login);
    }

    public void saveUser(User user){
        userDao.save(user);
    }

    public void update(User user){
        userDao.update(user);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }
}
