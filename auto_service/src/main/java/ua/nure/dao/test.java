package ua.nure.dao;

import ua.nure.entity.Auto;
import ua.nure.service.AutoService;

import java.util.List;

public class test {
    public static void main(String[] args) {
        AutoService autoService = new AutoService();
        List<Auto> list = autoService.findAll();
        System.out.println("");
    }
}
