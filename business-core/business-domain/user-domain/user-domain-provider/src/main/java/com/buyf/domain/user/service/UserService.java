package com.buyf.domain.user.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.buyf.domain.user.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author buyf
 * @since 2021-02-02
 */
public interface UserService extends IService<User> {
    // 从数据库中取出用户信息
    User selectByUsername(String username);
}
