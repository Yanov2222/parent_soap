package ua.nure.zakaz_service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.nure.entity.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


@Log4j
@Endpoint
public class ZakazEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private ZakazRepository zakazRepository;

    @Autowired
    public ZakazEndpoint(ZakazRepository zakazRepository) {
        this.zakazRepository = zakazRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getZakazRequest")
    @ResponsePayload
    public GetZakazResponse getZakaz(@RequestPayload GetZakazRequest request) throws DatatypeConfigurationException {
        User user = request.getUser();
        GetZakazResponse response = new GetZakazResponse();
        if (user.getRole().equalsIgnoreCase("ADMIN")) {
            response.setZakaz(zakazRepository.readAll());
            return response;
        }
        if (user.getRole().equalsIgnoreCase("DRIVER")) {
            response.setZakaz(zakazRepository.readForDriver(user.getId()));
            return response;
        } else {
            response.setZakaz(zakazRepository.readForUser(user.getId()));
            return response;
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getReadSnapshotRequest")
    @ResponsePayload
    public GetReadSnapshotResponse getZakazSnapshot(@RequestPayload GetReadSnapshotRequest request) throws DatatypeConfigurationException {

        User user = request.getUser();
        GetReadSnapshotResponse response = new GetReadSnapshotResponse();

        if (user.getRole().equals("admin")) {
            List<ZakazView> list = zakazRepository.readSnapshot();
            for(ZakazView z: list){
                System.out.println(z.getAssignDateTime());
            }
            response.setZakaz(list);
            return response;
        }
        if (user.getRole().equals("driver")) {
            response.setZakaz(zakazRepository.readDriverSnapshot(user.getId()));
            return response;
        } else {
            response.setZakaz(zakazRepository.readUserSnapshot(user.getId()));
            return response;
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postCreateZakazRequest")
    @ResponsePayload
    public PostCreateZakazResponse createZakaz(@RequestPayload PostCreateZakazRequest request) throws DatatypeConfigurationException {
        String message;
        PostCreateZakazResponse response = new PostCreateZakazResponse();
        User user = request.getUser();
        String addr1 = request.getAddress1();
        String addr2 = request.getAddress2();
        String categ = request.getCategory();
        Zakaz zakaz = new Zakaz();
        zakaz.setUserId(user.getId());
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(new Date().getTime());
        zakaz.setCreateDateTime(DatatypeFactory.newInstance().newXMLGregorianCalendar(gc));
        zakaz.setAddress1(addr1);
        zakaz.setAddress2(addr2);
        zakaz.setCategory(categ);
        zakaz.setOrderStatus("Open");
        zakazRepository.save(zakaz);
        message = "Success insert order!";
        response.setMessage(message);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postAssignZakazRequest")
    @ResponsePayload
    public PostAssignZakazResponse assignZakaz(@RequestPayload PostAssignZakazRequest request) throws DatatypeConfigurationException {
        PostAssignZakazResponse response = new PostAssignZakazResponse();
        User user = request.getUser();
        Auto auto = request.getAuto();
        Zakaz zakaz = request.getZakaz();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(new Date().getTime());
        zakaz.setAssignDateTime(DatatypeFactory.newInstance().newXMLGregorianCalendar(gc));
        zakaz.setOrderStatus("Assigned");
        zakaz.setAutoId(auto.getId());
        zakazRepository.update(zakaz);
        String message = "Sucess assign!!";
        response.setMessage(message);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postUpdateZakazRequest")
    @ResponsePayload
    public PostUpdateZakazResponse updateZakaz(PostUpdateZakazRequest request) throws DatatypeConfigurationException {
        PostUpdateZakazResponse response = new PostUpdateZakazResponse();
        User user = request.getUser();
        String status = request.getStatus();
        Zakaz zakaz = request.getZakaz();
        zakaz.setOrderStatus(status);
        zakazRepository.update(zakaz);
        response.setMessage("Sucess update!!");
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postDeleteZakazRequest")
    @ResponsePayload
    public PostDeleteZakazResponse deleteZakaz(PostDeleteZakazRequest request) throws DatatypeConfigurationException {
        PostDeleteZakazResponse response = new PostDeleteZakazResponse();
        User user = request.getUser();
        Zakaz zakaz = request.getZakaz();
        zakazRepository.delete(zakaz);
        response.setMessage("Success delete!!");
        return response;
    }

}
