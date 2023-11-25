package com.neu.mapper;

import com.neu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserMapper {

    User findUserByName(String var1);

    User findUserById(String var1);

    List<User> findUserByKeyword(@Param("keyword") String keyword);

    List<User> findAll();

    int insert(User var1);

    int update(User var1);

    int delete(String var1);

}
