package org.example.test;

import org.example.domain.Book;
import org.example.service.HelloService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// IOC  控制反转
public class Demo01 {

//        1.
    @Test
    public void test0() {
        //获得springIOC容器
        ClassPathXmlApplicationContext Context = new ClassPathXmlApplicationContext("springConfig.xml");
        //根据id获取
        HelloService helloService = (HelloService) Context.getBean("helloService");
        helloService.sayHello();
    }

    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        Book book1 = (Book) context.getBean("book01");
        System.out.println("普通创建方式: " + book1);
        context.close();
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        Book book2 = (Book) context.getBean("book02");
        System.out.println("工厂方式创建: " + book2);
        context.close();
    }

    @Test
    public void test3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        Book book3 = (Book) context.getBean("book03");
        System.out.println("静态工厂创建: " + book3);
        context.close();
    }

    @Test
    public void test4() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        Book book4 = (Book) context.getBean("book04");
        System.out.println("FactoryBean 创建: " + book4);
        context.close();
    }
}
