package com.qd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.qd.mapper")
@SpringBootApplication
public class OrderSysZhoujunyuApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSysZhoujunyuApplication.class, args);
    }

}
