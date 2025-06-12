package cn.cjxy.test;

import cn.cjxy.domain.Emp;
import cn.cjxy.mapper.EmpMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo01 {

    @Test
    public void testSelect() throws Exception {
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.根据配置文件创建一个sqlSession工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用工厂对象创建sqlsession true表示开启自动提交
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();
        //4.通过session得到mapper对象
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        //5.调用方法
        List<Emp> empList = mapper.findAll();
        //遍历
        for (Emp emp : empList) {
            System.out.println(emp);
        }
        //关流
        is.close();
        session.close();
    }

    @Test
    public void testfindById() throws IOException {
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.根据配置文件创建一个sqlSession工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用工厂对象创建sqlsession true表示开启自动提交
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();

        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = mapper.findById(29);
        System.out.println(emp);

        //关流
        is.close();
        session.close();
    }

    @Test
    public void testInsert() throws Exception {
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.根据配置文件创建一个sqlSession工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用工厂对象创建sqlsession true表示开启自动提交
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();

        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = new Emp(29, "张三", 20, "重庆", 6000);
        int isTrue = mapper.insert(emp);
        if (isTrue == 1) {
            //提交事务
            session.commit();
            System.out.println(emp);
            System.out.println("插入成功！");
        }

        //关流
        is.close();
        session.close();
    }

    @Test
    public void testdeletById() throws Exception {
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.根据配置文件创建一个sqlSession工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用工厂对象创建sqlsession true表示开启自动提交
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();

        EmpMapper mapper = session.getMapper(EmpMapper.class);
        int isTrue = mapper.deleteById(29);
        if (isTrue == 1) {
            //提交事务
            session.commit();
            System.out.println("删除成功！");
        }

        //关流
        is.close();
        session.close();
    }

    @Test
    public void testupdateById() throws Exception {
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.根据配置文件创建一个sqlSession工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用工厂对象创建sqlsession true表示开启自动提交
        SqlSessionFactory factory = builder.build(is);
        SqlSession session = factory.openSession();

        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = new Emp(29,"oyxp",21,"重庆",1500);
        int isTrue = mapper.updateById(emp);
        if (isTrue == 1) {
            //提交事务
            session.commit();
            System.out.println(emp);
            System.out.println("修改成功！");
        }

        //关流
        is.close();
        session.close();
    }
}
