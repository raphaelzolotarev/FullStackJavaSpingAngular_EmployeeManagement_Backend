package com.raphael.employeemanager;

import com.raphael.employeemanager.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(WebConfig.class)
@SpringBootApplication
public class AngularSpringEmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AngularSpringEmployeeApplication.class, args);
    }

}
