package com.fqcoder.springboot.springbootshiroauthentication.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Role
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/3/3 13:55
 * @Version 1.0
 */

public class Role  implements Serializable {

    private Integer id;

    private String name;

    private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Integer id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
    
    
}
