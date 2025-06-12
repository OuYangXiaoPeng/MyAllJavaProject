package cn.cjxy.test;

import cn.cjxy.domain.Emp;
import cn.cjxy.mapper.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Demo01 {

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
    public void testSelect() throws Exception {
        List<Emp> empList = mapper.findAll();
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }

    /**
     * 基本类型
     *
     * @throws Exception
     */
    @Test
    public void count() throws Exception {
        Long count = mapper.count();
        System.out.println(count);
    }

    @Test
    public void findByNameLike() throws Exception {
        List<Emp> emps = mapper.findByNameLike("%张%");
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    /**
     * 返回为map类型
     *
     * @throws Exception
     */
    @Test
    public void findByIdMap() throws Exception {
        System.out.println(mapper.findByIdMap(3));
    }

    @Test
    public void findAllMaps() throws Exception {
        List<Map<String, Object>> emps = mapper.findAllMaps();
        for (Map<String, Object> emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void findEmpByIdAndName() {
//        select * from emp where 1=1 and id = ? and name = ?
        System.out.println(mapper.findEmpByIdAndName(3, "王五"));
//         select * from emp where 1=1 and id = ?
        System.out.println(mapper.findEmpByIdAndName(3, null));
//          select * from emp where 1=1 and name = ?
        System.out.println(mapper.findEmpByIdAndName(null, "王五"));
    }

    @Test
    public void findEmpByIdAndName2() {
//        select * from emp where 1=1 and id = ? and name = ?
        System.out.println(mapper.findEmpByIdAndName2(3, "王五"));
//         select * from emp where 1=1 and id = ?
        System.out.println(mapper.findEmpByIdAndName2(3, null));
//          select * from emp where 1=1 and name = ?
        System.out.println(mapper.findEmpByIdAndName2(null, "王五"));
    }

    @Test
    public void findByIds() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Emp> emps = mapper.findByIds(list);
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void findByIds2() {
        Set<Integer> ids = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        //select * from emp where id in ( ? , ? , ? , ? )
        List<Emp> emps = mapper.findByIds2(ids);
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void findByIds3() {
        Integer[] id = new Integer[]{1, 2, 3, 4, 5};
        List<Emp> emps = mapper.findByIds3(id);
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

    @Test
    public void findByEmp() {
        Emp emp = new Emp();
        emp.setId(5);
        mapper.findByEmp(emp);

    }

    @Test
    public void updateEmp(){
        mapper.updateEmp(new Emp(29,"oyxp",null,null,null));
    }

    @Test
    public void findByIdOrName(){
        mapper.findByIdOrName(29,"张三");
    }

}
