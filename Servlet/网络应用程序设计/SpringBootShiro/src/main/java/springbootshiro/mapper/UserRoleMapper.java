package springbootshiro.mapper;


import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootshiro.model.Role;

import java.util.List;

/**
 * @ClassName UserRoleMapper
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/3/3 14:01
 * @Version 1.0
 */
@Repository
public interface UserRoleMapper {

    /**
     *
     * 查询用户角色（可能一个用户有多个角色）
     * @param username
     * @return
     */
    @Select("select r.id,r.name,r.description from tb_role r " +
            "left join tb_user_role ur on(r.id = ur.role_id)" +
            "left join tb_user u on(u.id=ur.user_id)" +
            "where u.username =#{username}")
    List<Role> findByUserName(String username);

}
