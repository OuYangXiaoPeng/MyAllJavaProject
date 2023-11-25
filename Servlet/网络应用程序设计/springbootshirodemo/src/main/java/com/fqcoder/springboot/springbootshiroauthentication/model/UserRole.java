package com.fqcoder.springboot.springbootshiroauthentication.model;

import lombok.Data;

/**
 * @ClassName UserRole
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/3/3 13:55
 * @Version 1.0
 */

public class UserRole {

    private Integer userId;

    private Integer roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(Integer userId, Integer roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}
    
    
}
