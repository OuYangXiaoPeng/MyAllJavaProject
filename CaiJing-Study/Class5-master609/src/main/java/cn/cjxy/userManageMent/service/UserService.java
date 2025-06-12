package cn.cjxy.userManageMent.service;

import cn.cjxy.userManageMent.domain.User;
import cn.cjxy.userManageMent.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param username
     * @return
     */
    public User login(String username) {
     return   userMapper.findByUsername(username);
    }

    /**
     * 查询所有
     * @return
     */
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    /**
     * 修改
     * @param user
     */
    public void update(User user) {
        userMapper.update(user);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    /**
     * 新增
     * @param user
     */
    public void save(User user) {
        userMapper.save(user);
    }
}
