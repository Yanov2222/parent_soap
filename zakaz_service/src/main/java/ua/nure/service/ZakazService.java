package ua.nure.service;

import ua.nure.dao.ZakazDao;
import ua.nure.sql.Zakaz;
import ua.nure.sql.ZakazView;

import java.util.List;

public class ZakazService {
    private ZakazDao zakazDao = new ZakazDao();

    public List<Zakaz> readAll(){
        return zakazDao.readAll();
    }

    public List<Zakaz> readForUser(int userId){
        return zakazDao.readForUser(userId);
    }

    public List<Zakaz> readForDriver(int driverId){
        return zakazDao.readForDriver(driverId);
    }

    public void save(Zakaz zakaz){
        zakazDao.save(zakaz);
    }

    public void update(Zakaz zakaz){
        zakazDao.update(zakaz);
    }

    public void delete(Zakaz zakaz){
        zakazDao.delete(zakaz);
    }

    public List<ZakazView> readSnapshot(){
        return zakazDao.readSnapshot();
    }

    public List<ZakazView> readUserSnapshot(int userId){
        return zakazDao.readUserSnapshot(userId);
    }

    public List<ZakazView> readDriverSnapshot(int driverId) {
        return zakazDao.readDriverSnapshot(driverId);
    }
}
