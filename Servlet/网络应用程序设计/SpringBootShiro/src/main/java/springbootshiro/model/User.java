package springbootshiro.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/2/29 3:31
 * @Version 1.0
 */

public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;

    private Date createTime;

    private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String username, String password, Date createTime, Integer status) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createTime = createTime;
		this.status = status;
	}
    
    
}
