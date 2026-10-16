package com.nanbei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nanbei.mapper")
public class OperatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperatorApplication.class, args);
    }
}
