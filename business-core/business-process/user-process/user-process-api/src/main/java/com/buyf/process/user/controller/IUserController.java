package com.buyf.process.user.controller;

import com.buyf.domain.user.dto.UserDTO;

/**
 * @author buyf
 * @date 2021/2/3 15:56
 * @desc
 */
public interface IUserController {
    UserDTO queryByUsername(String username);
}

