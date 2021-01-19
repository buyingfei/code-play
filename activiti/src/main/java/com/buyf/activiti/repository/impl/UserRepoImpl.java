package com.buyf.activiti.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buyf.activiti.dao.UserMapper;
import com.buyf.activiti.entity.User;
import com.buyf.activiti.repository.UserRepo;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author buyf
 * @since 2021-01-06
 */
@Service
public class UserRepoImpl extends ServiceImpl<UserMapper, User> implements UserRepo {

}
