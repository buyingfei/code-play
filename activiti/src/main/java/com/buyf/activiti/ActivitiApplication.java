package com.buyf.activiti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(
//        scanBasePackages={"com.buyf.activiti"}
)
@ImportResource(value = {"classpath*:mappers/*.xml"})
@MapperScan("com.buyf.activiti.dao")
public class ActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiApplication.class, args);
    }

}
