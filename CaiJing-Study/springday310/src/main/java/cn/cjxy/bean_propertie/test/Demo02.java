package cn.cjxy.bean_propertie.test;

import cn.cjxy.bean_propertie.after_handler.MyProcess;
import cn.cjxy.bean_propertie.domain.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// IOC  控制反转
public class Demo02 {

    //获得springIOC容器
    ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("application.xml");

    //        1.
    @Test
    public void testBook05() {
        Book book = (Book) app.getBean("book05");
        System.out.println(book);
//        关闭容器
        app.close();
    }

    @Test
    public void testBook06() {
        Book book = (Book) app.getBean("book06");
        System.out.println(book);
//        关闭容器
        app.close();
    }

    @Test
    public void testBook07() {
        Book book = (Book) app.getBean("book07");
        System.out.println(book);
//        关闭容器
        app.close();
    }

    @Test
    public void testBook08() {
        Book book = (Book) app.getBean("book08");
        System.out.println(book);
//        关闭容器
        app.close();
    }

    @Test
    public void testBook09() {
        Book book = (Book) app.getBean("book09");
        System.out.println(book);
//        关闭容器
        app.close();
    }

    @Test
    public void testEmp01() {
        Emp emp = (Emp) app.getBean("emp01");
        System.out.println(emp);
//        关闭容器
        app.close();
    }

    @Test
    public void testDept02() {
        Dept dept = (Dept) app.getBean("dept02");
        System.out.println(dept);
//        关闭容器
        app.close();
    }

    @Test
    public void testEmp02() {
        Emp emp = (Emp) app.getBean("emp02");
        System.out.println(emp);
//        关闭容器
        app.close();
    }

    @Test
    public void testEmp03() {
        Emp emp = (Emp) app.getBean("emp03");
        System.out.println(emp);
//        关闭容器
        app.close();
    }

    @Test
    public void testDept03() {
        Dept dept = (Dept) app.getBean("dept03");
        System.out.println(dept);
//        关闭容器
        app.close();
    }

    @Test
    public void testPojo01() {
        Pojo pojo = (Pojo) app.getBean("pojo01");
        System.out.println(pojo);
//        关闭容器
        app.close();
    }

    @Test
    public void testPerson() {
        Person person = (Person) app.getBean("person");
        System.out.println(person);
//        关闭容器
        app.close();
    }

    @Test
    public void testProcess() {
        MyProcess myProcess = (MyProcess) app.getBean("myProcess");
        System.out.println(myProcess);
//        关闭容器
        app.close();
    }

    @Test
    public void testPerson01() {
        Person person = (Person) app.getBean("person01");
        System.out.println(person);
//        关闭容器
        app.close();
    }


}
