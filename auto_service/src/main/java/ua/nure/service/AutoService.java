package ua.nure.service;

import ua.nure.dao.AutoDao;
import ua.nure.entity.Auto;

import java.util.List;

public class AutoService {

    private AutoDao autoDao = new AutoDao();

    public List<Auto> findAll(){
        return autoDao.findAll();
    }

    public List<Auto> findFilter(String category){
        return autoDao.findFilter(category);
    }

    public void save(Auto auto){
        autoDao.save(auto);
    }

    public void update(Auto auto){
        autoDao.update(auto);
    }

    public void delete(Auto auto){
        autoDao.delete(auto);
    }
}
