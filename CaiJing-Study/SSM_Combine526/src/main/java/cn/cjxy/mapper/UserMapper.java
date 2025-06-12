package cn.cjxy.mapper;

import cn.cjxy.domain.User;
import java.util.List;

public interface UserMapper {
    // 查询所有用户
    List<User> findAll();

    // 根据ID查询用户
    User findById(Integer id);

    // 添加用户
    void addUser(User user);

    // 更新用户
    void updateUser(User user);

    // 根据ID删除用户
    void deleteUser(Integer id);
}