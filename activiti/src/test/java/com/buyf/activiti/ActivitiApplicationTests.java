package com.buyf.activiti;

import com.buyf.activiti.entity.User;
import com.buyf.activiti.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ActivitiApplicationTests {

    @Autowired
    UserRepo userRepo;
    @Test
    void contextLoads() {
        User user = userRepo.getById(1);
        System.out.printf(user.toString());
    }

}
