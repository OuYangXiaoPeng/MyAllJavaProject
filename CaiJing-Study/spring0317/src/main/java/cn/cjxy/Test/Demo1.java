package cn.cjxy.Test;

import cn.cjxy.config.SpringConfig;
import cn.cjxy.controller.UserController;
import cn.cjxy.domain.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {
    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserController userController = (UserController) context.getBean("userController");
        User byId = userController.findById(3);
        System.out.println(byId);
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserController userController = (UserController) context.getBean("userController");
        User byId = userController.findById(2);
        System.out.println(byId);
    }

    @Test
    public void test3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        MyDataSource dataSource = context.getBean(MyDataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void test4() {
        //创建ioc容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = context.getBean(UserController.class);
        System.out.println(userController.findById(2));
    }

    @Test
    public void testAddUser() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = context.getBean(UserController.class);
        User user = new User();
        user.setId(5);
        user.setUsername("王五");
        user.setPassword("123456");
        userController.addUser(user);
    }

    @Test
    public void testDeleteUser() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = context.getBean(UserController.class);
        userController.deleteUser(5);
    }

    @Test
    public void testUpdateUserById() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController userController = context.getBean(UserController.class);
        int id = 1;
        String setUsername = "13246";
        String setPassword = "147852";
        userController.updateUserById(id, setUsername, setPassword);
    }


}
