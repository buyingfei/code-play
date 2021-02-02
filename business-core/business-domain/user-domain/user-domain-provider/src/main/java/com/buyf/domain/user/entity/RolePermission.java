package com.buyf.domain.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 角色权限
 * </p>
 *
 * @author buyf
 * @since 2021-01-31
 */
@TableName("sys_role_permission")
public class RolePermission extends BasicEntity {

    private static final long serialVersionUID = 1L;

    private String roleId;

    private String permissionId;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    private Boolean isDeleted;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
            "roleId=" + roleId +
            ", permissionId=" + permissionId +
            ", isDeleted=" + isDeleted +
        "}";
    }
}
