package cn.cjxy.service;

import cn.cjxy.dao.UserDao;
import cn.cjxy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//负责处理业务逻辑
@Service//标注为service层并注入ioc容器
public class UserService {
    @Autowired
    private UserDao userDao;

    //查找
    public User findById(int id) {
        return userDao.findById(id);
    }

    // 添加用户
    public void addUser(User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            System.out.println("用户信息不完整");
        } else {
            userDao.addUser(user);
        }
    }

    //删除用户
    public void deleteUser(int id) {
        if (id <= 0) {
            System.out.println("ID 必须大于 0");
        } else {
            userDao.deleteUser(id);
        }
    }

    //更改用户
    public void updateUserById(int id, String username, String password) {
        userDao.updateUserById(id, username, password);
    }
}
