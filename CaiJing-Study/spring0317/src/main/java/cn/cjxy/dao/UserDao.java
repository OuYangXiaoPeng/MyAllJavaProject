package cn.cjxy.dao;

import cn.cjxy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//负责处理数据库
@Repository//标注为dao层并注入ioc容器
public class UserDao {
    //    数据库
    @Autowired
    private DataSource dataSource;

    //    d根据id查用户
    public User findById(Integer id) {
        try {
            //得到
            PreparedStatement ps = dataSource.getConnection().prepareStatement("select * from user where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    //    添加用户
    public void addUser(User user) {
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement("insert into user(id,username,password) values(?,?,?)");
            ps.setInt(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
            System.out.println("添加成功！");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //    删除用户
    public void deleteUser(Integer id) {
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement("delete from user where id=?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("用户删除成功！");
            } else {
                System.out.println("未找到用户，删除失败！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //  更改
    public void updateUserById(Integer id,String username,String password) {
        try {
            PreparedStatement ps = dataSource.getConnection().prepareStatement("UPDATE user SET username = ?, password = ? WHERE id = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("用户更新成功！");
            } else {
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
