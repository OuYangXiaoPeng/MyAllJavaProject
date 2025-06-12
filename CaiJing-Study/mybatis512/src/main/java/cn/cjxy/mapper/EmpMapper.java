package cn.cjxy.mapper;

import cn.cjxy.domain.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EmpMapper {
    List<Emp> findAll();
    Long count();
    //pojo类型 根据员工类型模糊查询
    List<Emp> findByNameLike(String name);
    List<Emp> findByNameLike2(String name);

    //map类型  根据id查询用户，结果集为map
    Map<String,Object>  findByIdMap(Integer id);
    //查询所有用户
    List<Map<String,Object>> findAllMaps();
    //查询所有用户
    List<Emp> findAlLEmp();

    /**
     * 动态sql
     */

    //根据id和用户名查询员工
    //id如果不为空可以根据id查询，select * from emp where id=#{id}
    // name如果也不为空则id和name一起匹配， select * from emp where id=#{id} and name=#{name}
    // id为空，name有值select * from emp where name=#{name}
    //两者都为空select * from emp
    Emp findEmpByIdAndName(@Param("id") Integer id,@Param("name") String name);
    Emp findEmpByIdAndName2(@Param("id") Integer id,@Param("name") String name);
    //动态sql-foreach
    //通过id批量查询员工
    List<Emp> findByIds(List<Integer> ids);
    List<Emp> findByIds2(Set<Integer> ids);
    List<Emp> findByIds3(Integer[] ids);

    List<Emp> findByEmp(Emp emp);

    void updateEmp(Emp emp);

    List<Emp> findByIdOrName(@Param("id") Integer id,@Param("name") String name);
}
