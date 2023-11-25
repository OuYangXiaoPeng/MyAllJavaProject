package springbootshiro.mapper;


import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import springbootshiro.model.Permission;

import java.util.List;

/**
 * @ClassName RolePermissionMapper
 * @Description TODO
 * @Author fqCoder
 * @Date 2020/3/3 14:19
 * @Version 1.0
 */
@Repository
public interface RolePermissionMapper {

    /**
     * 通过角色id查询权限
     * @param roleId
     * @return
     */
    @Select("select p.id,p.url,p.name from tb_permission p " +
            "left join tb_role_permission rp on(p.id=rp.permission_id)" +
            "left join tb_role r on(r.id=rp.role_id)" +
            "where r.id=#{roleId}")
    List<Permission> findByRoleId(Integer roleId);
}
