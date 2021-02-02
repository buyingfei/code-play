package com.buyf.domain.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buyf.domain.user.dao.RolePermissionMapper;
import com.buyf.domain.user.entity.RolePermission;
import com.buyf.domain.user.service.RolePermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色权限 服务实现类
 * </p>
 *
 * @author buyf
 * @since 2021-02-02
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

}
