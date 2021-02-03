package com.buyf.domain.user.repository;

import com.buyf.common.tools.ObjectUtils;
import com.buyf.domain.user.dto.UserDTO;
import com.buyf.domain.user.service.UserService;
import com.buyf.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepo implements IUserRepo {
    @Autowired
    private UserService userService;
    @Override
    public UserDTO selectByUsername(String username) {
        User user = userService.selectByUsername(username);
        return ObjectUtils.cglibCopyProperties(user, UserDTO.class);
    }
}
