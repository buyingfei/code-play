package com.buyf.domain.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buyf.domain.user.entity.Permission;

import java.util.List;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author buyf
 * @since 2021-01-31
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    List<String> selectPermissionValueByUserId(String id);

    List<String> selectAllPermissionValue();

    List<Permission> selectPermissionByUserId(String userId);
}
