package com.thread.scheduled;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@MapperScan("com.thread.scheduled")
public class ScheduledApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ScheduledApplication.class)
                .properties("spring.config.name:application", "spring.config.location:classpath:config")
                .build().run(ScheduledApplication.class, args);
    }

}
