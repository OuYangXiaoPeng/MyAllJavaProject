package cn.cjxy.test;

import cn.cjxy.domain.User;
import cn.cjxy.mapper.UserMapper;
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
    UserMapper mapper = null;

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
        mapper = session.getMapper(UserMapper.class);
    }

    @After
    public void destory() throws IOException {
        is.close();
        session.close();
    }

    @Test
    public void testSelect() {
        List<User> empList = mapper.findAll();
        for (User user : empList) {
            System.out.println(user);
        }
    }

}
