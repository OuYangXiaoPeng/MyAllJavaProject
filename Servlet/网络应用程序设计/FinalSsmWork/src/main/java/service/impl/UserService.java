package service.impl;


import domain.User;
import domain.UserExample;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAllUser() {
        UserExample example = new UserExample();
        List<User> users = userMapper.selectByExample(example);
        return users;

    }

    @Override
    public List<User> findUsersByPage(int page, int pageSize) {
        // 根据页码和每页数量计算偏移量，然后查询对应的用户数据
        int offset = (page - 1) * pageSize;
        return userMapper.findUsersByPage(offset, pageSize);
    }

    @Override
    public boolean userModify(User user) {

        User u = userMapper.selectByPrimaryKey(user.getUid());
        if (user.getUname() != null && !user.getUname().equals("")) {
            u.setUname(user.getUname());
        }
        if (user.getPassword() != null && !user.getPassword().equals("")) {
            u.setPassword(user.getPassword());
        }
        if (user.getGender() != null && !user.getGender().equals("")) {
            u.setGender(user.getGender());
        }
        if (user.getBirthday() != null && !user.getBirthday().equals("")) {
            u.setBirthday(user.getBirthday());
        }
        if (user.getEmail() != null && !user.getEmail().equals("")) {
            u.setEmail(user.getEmail());
        }
        UserExample example = new UserExample();
        UserExample.Criteria cri = example.createCriteria();
        cri.andUidEqualTo(user.getUid());
        if (userMapper.updateByExample(u, example) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public User findUserById(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public int deleteById(Integer uid) {
        return userMapper.deleteByPrimaryKey(uid);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public boolean updatePwd(Integer uid, String password, String newPassword) {
        UserExample example = new UserExample();
        UserExample.Criteria cri = example.createCriteria();
        cri.andUidEqualTo(uid);
        User user = userMapper.selectByPrimaryKey(uid);
        if (user.getPassword().equals(password)) {
            user.setPassword(newPassword);
            userMapper.updateByExample(user, example);
            return true;
        }
        return false;
    }

    @Override
    public User findUserByNameAndPassword(String username, String password) {
        return userMapper.findUserByNameAndPassword(username, password);
    }

    @Override
    public User findUserByName(String username) {
        return userMapper.selectByUsername(username);
    }

}
