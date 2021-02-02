package com.buyf.domain.repository;

import com.buyf.domain.dto.UserDTO;

public interface IUserRepo {
    UserDTO selectByUsername(String username);
}
