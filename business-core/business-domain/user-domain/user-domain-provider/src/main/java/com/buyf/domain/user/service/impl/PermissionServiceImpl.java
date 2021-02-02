package com.buyf.domain.user.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.buyf.domain.user.dao.PermissionMapper;
import com.buyf.domain.user.entity.Permission;
import com.buyf.domain.user.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author buyf
 * @since 2021-02-02
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
