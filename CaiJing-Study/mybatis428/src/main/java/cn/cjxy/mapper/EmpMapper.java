package cn.cjxy.mapper;

import cn.cjxy.domain.Emp;
import cn.cjxy.pojo.QueryCondition;

import java.util.List;

public interface EmpMapper {

    List<Emp> findAll();

    int insert(Emp emp);

    int insert2(Emp emp);

    int updateById(Emp emp);

    int deleteById(int id);

    Emp findById(int id);

    Long count();

    //根据薪资范围查询员工信息
    List<Emp> findBySalary(int start,int end);

    List<Emp> findBySalary2(int start,int end);

    //根据薪资范围查询员工信息且要匹配姓名
    List<Emp> findBySalary4(QueryCondition queryCondition);
}
