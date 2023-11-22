package com.lemonwind.sbmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.lemonwind.sbmp.mapper")
@EnableTransactionManagement
public class JomkieSbmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(JomkieSbmpApplication.class, args);
    }

}
