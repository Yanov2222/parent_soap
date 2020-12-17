package ua.nure.parent_soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@SpringBootApplication
@ComponentScan(basePackages = {"ua.nure.user_service"})
public class ParentSoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParentSoapApplication.class, args);

    }

}
