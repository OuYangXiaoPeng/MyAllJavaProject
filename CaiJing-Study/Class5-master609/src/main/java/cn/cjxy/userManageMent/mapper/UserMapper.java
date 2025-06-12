package cn.cjxy.userManageMent.mapper;

import cn.cjxy.userManageMent.domain.User;

import java.util.List;

public interface UserMapper {
    User findByUsername(String username);
    List<User> findAll();

    User findById(Integer id);
    void update(User user);

    void delete(Integer id);

    void save(User user);
}
