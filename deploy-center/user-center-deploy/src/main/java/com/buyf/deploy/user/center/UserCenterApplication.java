package com.buyf.deploy.user.center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages={
                "com.buyf.domain.user",
                "com.buyf.process.user",
        }
)
@MapperScan(value = {"com.buyf.domain.user"})
public class UserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }

}
