package com.buyf.process.user.controller;

import com.buyf.domain.user.dto.UserDTO;
import com.buyf.domain.user.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author buyf
 * @date 2021/2/3 15:56
 * @desc
 */
@RestController
@RequestMapping("/user")
public class UserController implements IUserController {
    @Autowired
    private IUserRepo userRepo;

    @PostMapping("/queryByUsername")
    @Override
    public UserDTO queryByUsername(@PathVariable("username") String username){
         return userRepo.selectByUsername(username);
    }
}

