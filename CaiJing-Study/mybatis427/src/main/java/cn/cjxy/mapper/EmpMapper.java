package cn.cjxy.mapper;

import cn.cjxy.domain.Emp;

import java.util.List;

public interface EmpMapper {

    List<Emp> findAll();

    Emp findById(int id);

    int insert(Emp emp);

    int deleteById(int id);

    int updateById(Emp emp);
}
