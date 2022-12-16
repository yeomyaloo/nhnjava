package com.nhnacademy.edu.restapi_final_project.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Configuration
@ConfigurationProperties(prefix = "init.file")
@Getter
@Setter
public class SystemProperties {
    String name;
}
