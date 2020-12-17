package ua.nure.dao;

import ua.nure.entity.User;
import ua.nure.service.UserService;

import java.util.List;

public class test {
    public static void main(String[] args) {
        UserService userService = new UserService();
        User temp = userService.findByLogin("Yanov");
        List<User> list = userService.findAll();
        System.out.println(temp.toString());
    }
}
