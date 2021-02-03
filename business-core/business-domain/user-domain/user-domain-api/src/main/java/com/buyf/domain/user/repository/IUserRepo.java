package com.buyf.domain.user.repository;

import com.buyf.domain.user.dto.UserDTO;

public interface IUserRepo {
    UserDTO selectByUsername(String username);
}
