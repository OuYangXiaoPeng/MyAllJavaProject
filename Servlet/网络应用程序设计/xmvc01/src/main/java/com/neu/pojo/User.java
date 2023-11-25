package com.neu.pojo;

import lombok.Getter;

/**
 * user表对应的javaBean
 *
 * @author Admin
 */
@Getter
public class User {

    private String id;
    private String userName;
    private String password;


    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
