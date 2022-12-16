package com.nhnacademy.edu.restapi_final_project;

import com.nhnacademy.edu.restapi_final_project.config.SystemProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class RestApiFinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiFinalProjectApplication.class, args);
    }

}
