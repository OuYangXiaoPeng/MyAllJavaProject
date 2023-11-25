package springbootshiro.mapper;


import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootshiro.model.User;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/2/29 3:30
 * @Version 1.0
 */
@Repository
public interface UserMapper {


    @Select("select * from tb_user where username=#{username}")
    User selectByName(String username);

}
