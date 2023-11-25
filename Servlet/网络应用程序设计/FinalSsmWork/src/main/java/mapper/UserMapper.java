package mapper;


import domain.User;
import domain.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer uid);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    User findUserByNameAndPassword(@Param("username")String username, @Param("password")String password);

    User selectByUsername(String username);

    List<User> findUsersByPage(@Param("start") int start, @Param("pageSize") int pageSize);
}