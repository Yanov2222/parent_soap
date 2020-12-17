package ua.nure.zakaz_service;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import ua.nure.entity.Zakaz;
import ua.nure.entity.ZakazView;
import ua.nure.service.ZakazService;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j
@Component
public class ZakazRepository {
    ZakazService zakazService = new ZakazService();
    private List<Zakaz> zakazList;
    private List<ZakazView> listView;

    @PostConstruct
    public void initData() throws DatatypeConfigurationException {
        List<ua.nure.sql.Zakaz> sqlList = zakazService.readAll();
        zakazList = new ArrayList<>();
        for(ua.nure.sql.Zakaz z : sqlList){
            zakazList.add(Zakaz.toXmlType(z));
        }
        List<ua.nure.sql.ZakazView> sqlListView = zakazService.readSnapshot();
        listView = new ArrayList<>();
        for(ua.nure.sql.ZakazView z : sqlListView){
            listView.add(ZakazView.toXmlType(z));
            System.out.println();
        }
    }

    public List<Zakaz> readAll(){
        return zakazList;
    }

    public List<Zakaz> readForUser(int userId){
        return zakazList.stream().filter((p)->p.getUserId()==userId).collect(Collectors.toList());
    }

    public List<Zakaz> readForDriver(int driverId) throws DatatypeConfigurationException {
        List<ua.nure.sql.Zakaz> sqlList = zakazService.readForDriver(driverId);
        List<Zakaz> list = new ArrayList<>();
        for(ua.nure.sql.Zakaz z : sqlList){
            list.add(Zakaz.toXmlType(z));
        }
        return list;
    }

    public void save(Zakaz zakaz) throws DatatypeConfigurationException {
        zakazService.save(Zakaz.toSqlType(zakaz));
        initData();
    }

    public void update(Zakaz zakaz) throws DatatypeConfigurationException {
        zakazService.update(Zakaz.toSqlType(zakaz));
        initData();
    }

    public void delete(Zakaz zakaz) throws DatatypeConfigurationException {
        zakazService.delete(Zakaz.toSqlType(zakaz));
        initData();
    }

    public List<ZakazView> readSnapshot(){
        return listView;
    }

    public List<ZakazView> readUserSnapshot(int userId){
        return listView.stream().filter((p)->p.getUserId()==userId).collect(Collectors.toList());
    }

    public List<ZakazView> readDriverSnapshot(int driverId) throws DatatypeConfigurationException {
        List<ua.nure.sql.ZakazView> sqlListView = zakazService.readDriverSnapshot(driverId);
        List<ZakazView> list = new ArrayList<>();
        for(ua.nure.sql.ZakazView z : sqlListView){
            list.add(ZakazView.toXmlType(z));
        }
        return list;
    }
}
