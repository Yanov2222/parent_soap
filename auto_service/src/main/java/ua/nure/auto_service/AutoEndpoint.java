package ua.nure.auto_service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.nure.entity.*;


@Log4j
@Endpoint
public class AutoEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private AutoRepository autoRepository;

    @Autowired
    public AutoEndpoint(AutoRepository autoRepository){
        this.autoRepository = autoRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAutoRequest")
    @ResponsePayload
    public GetAllAutoResponse allAuto(@RequestPayload GetAllAutoRequest request){
        GetAllAutoResponse response = new GetAllAutoResponse();
        response.setAuto(autoRepository.findAll());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFilterAutoRequest")
    @ResponsePayload
    public GetFilterAutoResponse filterAuto(@RequestPayload GetFilterAutoRequest request){
        GetFilterAutoResponse response = new GetFilterAutoResponse();
        String category = request.getCategory();
        response.setAuto(autoRepository.findFilter(category));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postAddAutoRequest")
    @ResponsePayload
    public PostAddAutoResponse add(@RequestPayload PostAddAutoRequest request){
        PostAddAutoResponse response = new PostAddAutoResponse();
        Auto auto = request.getAuto();
        autoRepository.save(auto);
        String msg = "Success insert!!!";
        response.setMessage(msg);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postDeleteAutoRequest")
    @ResponsePayload
    public PostDeleteAutoResponse add(@RequestPayload PostDeleteAutoRequest request){
        PostDeleteAutoResponse response = new PostDeleteAutoResponse();
        Auto auto = request.getAuto();
        autoRepository.delete(auto);
        String msg = "Success delete!!!";
        response.setMessage(msg);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postUpdateAutoRequest")
    @ResponsePayload
    public PostUpdateAutoResponse add(@RequestPayload PostUpdateAutoRequest request){
        PostUpdateAutoResponse response = new PostUpdateAutoResponse();
        Auto auto = request.getAuto();
        autoRepository.update(auto);
        String msg = "Success update!!!";
        response.setMessage(msg);
        return response;
    }

}
