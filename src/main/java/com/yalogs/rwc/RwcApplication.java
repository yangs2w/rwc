package com.yalogs.rwc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(basePackages = {"com.yalogs.rwc.*.dao"})
public class RwcApplication {

    public static void main(String[] args) {
        SpringApplication.run(RwcApplication.class, args);
    }

}
