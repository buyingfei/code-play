package com.buyf.domain.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buyf.domain.user.dao.UserRoleMapper;
import com.buyf.domain.user.dto.UserDTO;
import com.buyf.domain.user.entity.User;
import com.buyf.domain.user.entity.UserRole;
import com.buyf.domain.user.service.UserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author buyf
 * @since 2021-02-02
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {


}
