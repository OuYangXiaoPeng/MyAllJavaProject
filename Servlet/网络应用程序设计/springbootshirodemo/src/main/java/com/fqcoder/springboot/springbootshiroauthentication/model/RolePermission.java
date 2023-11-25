package com.fqcoder.springboot.springbootshiroauthentication.model;

import lombok.Data;

/**
 * @ClassName RolePermission
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/3/3 13:55
 * @Version 1.0
 */

public class RolePermission {

    private Integer roleId;

    private Integer permissionId;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public RolePermission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RolePermission(Integer roleId, Integer permissionId) {
		super();
		this.roleId = roleId;
		this.permissionId = permissionId;
	}
    
    
}
