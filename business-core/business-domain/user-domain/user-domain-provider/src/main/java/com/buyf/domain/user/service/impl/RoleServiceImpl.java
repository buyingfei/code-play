package com.buyf.domain.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buyf.domain.user.dao.RoleMapper;
import com.buyf.domain.user.entity.Role;
import com.buyf.domain.user.service.RoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
