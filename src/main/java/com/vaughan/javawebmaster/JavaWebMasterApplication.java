package com.vaughan.javawebmaster;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.vaughan.javawebmaster.mapper")
@SpringBootApplication
public class JavaWebMasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaWebMasterApplication.class, args);
    }

}
