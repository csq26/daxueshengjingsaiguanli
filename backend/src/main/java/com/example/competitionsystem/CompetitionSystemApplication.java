package com.example.competitionsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.competitionsystem.mapper")
public class CompetitionSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompetitionSystemApplication.class, args);
    }
}
