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
import java.util.List;

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
        //5.调用方法
        List<Emp> empList = mapper.findAll();
        //遍历
        for (Emp emp : empList) {
            System.out.println(emp);
        }
    }

    @Test
    public void testInsert() throws Exception {
        Emp emp = new Emp(null, "oyxp", 20, "重庆", 6500);
        int isTrue = mapper.insert(emp);

        if (isTrue == 1) {
            //提交事务
            session.commit();
            System.out.println(emp);
            System.out.println("插入成功！");
        }
    }

    @Test
    public void testInsert2() throws Exception {
        Emp emp = new Emp(null, "张三", 20, "重庆", 6000);
        int isTrue = mapper.insert2(emp);

        if (isTrue == 1) {
            //提交事务
            session.commit();
            System.out.println(emp);
            System.out.println("插入成功！");
        }
    }

    @Test
    public void testupdateById() throws Exception {
        Emp emp = new Emp(6, "oyxp", 21, "重庆", 1500);
        int isTrue = mapper.updateById(emp);
        if (isTrue == 1) {
            //提交事务
            session.commit();
            System.out.println(emp);
            System.out.println("修改成功！");
        }
    }

    @Test
    public void testdeletById() throws Exception {
        int id = 31;
        // 先查询要删除的记录是否存在
        Emp emp = mapper.findById(id);
        if (emp != null) {
            // 记录存在，执行删除
            int isTrue = mapper.deleteById(id);
            if (isTrue == 1) {
                //提交事务
                session.commit();
                System.out.println("删除成功！删除的记录是：" + emp);
            }
        } else {
            System.out.println("要删除的记录不存在！");
        }
    }

    @Test
    public void testfindById() throws IOException {
        Emp emp = mapper.findById(29);
        System.out.println(emp);
    }

    @Test
    public void testcount() throws IOException {
        mapper.count();
    }
}
