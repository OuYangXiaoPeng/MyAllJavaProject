package springbootshiro.model;

import java.io.Serializable;

/**
 * @ClassName Permission
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/3/3 13:55
 * @Version 1.0
 */

public class Permission implements Serializable {

    private Integer id;

    private String url;

    private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Permission(Integer id, String url, String name) {
		super();
		this.id = id;
		this.url = url;
		this.name = name;
	}
    
    
}
