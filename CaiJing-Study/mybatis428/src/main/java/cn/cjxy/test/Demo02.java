package cn.cjxy.test;

import cn.cjxy.domain.Emp;
import cn.cjxy.mapper.EmpMapper;
import cn.cjxy.pojo.QueryCondition;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo02 {

    InputStream is = null;
    SqlSession session = null;
    EmpMapper mapper = null;

    @Before//在执行任意方法之前会执行该方法
    public void init() throws IOException {
        //1.加载核心配置文件
        is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.根据配置文件创建一个sqlSession工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用工厂对象创建sqlsession true表示开启自动提交
        SqlSessionFactory factory = builder.build(is);
        session = factory.openSession();
        //4.通过session得到mapper对象
        mapper = session.getMapper(EmpMapper.class);


    }

    @After
    public void destory() throws IOException {
        is.close();
        session.close();
    }

    @Test
    public void findBySalary(){
        List<Emp> emps = mapper.findBySalary(6000, 8000);
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void findBySalary2(){
        List<Emp> emps = mapper.findBySalary2(6000, 8000);
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void findBySalary4(){
        Emp emp = new Emp();
        //名字中末尾有三的
        emp.setName("%三");
        QueryCondition condition = new QueryCondition();
        condition.setEmp(emp);
        condition.setStart(6000);
        condition.setEnd(8000);

        List<Emp> emps = mapper.findBySalary4(condition);
        for (Emp e : emps) {
            System.out.println(e);
        }
    }

}
