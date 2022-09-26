package com.jomkie.sbmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jomkie.sbmp.mapper")
public class JomkieSbmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(JomkieSbmpApplication.class, args);
    }

}
