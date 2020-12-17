package ua.nure.dao;

import ua.nure.entity.User;
import ua.nure.entity.Zakaz;
import ua.nure.entity.ZakazView;
import ua.nure.service.ZakazService;
import ua.nure.zakaz_service.ZakazRepository;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.time.Instant;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Test {
    public static void main(String[] args) throws DatatypeConfigurationException {
        ZakazRepository zakazRepository = new ZakazRepository();
        zakazRepository.initData();
        List<ZakazView> list = zakazRepository.readSnapshot();
        System.out.println();
    }


    public static void testInsert( ZakazRepository zakazRepository) throws DatatypeConfigurationException {
        User user = new User();
        user.setId(1);
        Zakaz zakaz = new Zakaz();
        zakaz.setUserId(user.getId());
        zakaz.setAddress1("AAAAA1");
        zakaz.setAddress2("AAAAA2");
        zakaz.setOrderStatus("Open");
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(new Date().getTime());
        zakaz.setCreateDateTime(DatatypeFactory.newInstance().newXMLGregorianCalendar(gc));
        zakaz.setCategory("Electro");
        zakazRepository.save(zakaz);
    }

    public static void snapshot(ZakazRepository zakazRepository){

    }
}
