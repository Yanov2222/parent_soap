package ua.nure.auto_service;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import ua.nure.entity.Auto;
import ua.nure.service.AutoService;

import javax.annotation.PostConstruct;
import java.util.List;

@Log4j
@Component
public class AutoRepository {
    AutoService autoService = new AutoService();
    private List<Auto> list;

    @PostConstruct
    public void initData(){
        list = autoService.findAll();
    }

    public List<Auto> findAll(){
        return list;
    }

    public List<Auto> findFilter(String category){
        List<Auto> listAuto = autoService.findFilter(category);
        return listAuto;
    }

    public void save(Auto auto){
        autoService.save(auto);
        initData();
    }

    public void update(Auto auto){
        autoService.update(auto);
        initData();
    }

    public void delete(Auto auto){
        autoService.delete(auto);
        initData();
    }

}
