package cn.cjxy.bean_propertie.test;

import cn.cjxy.bean_propertie.domain.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// IOC  控制反转
public class Demo01 {

    //获得springIOC容器
    ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("application.xml");

    //        1.
    @Test
    public void test() {
        Person person = (Person) app.getBean("person");
        System.out.println(person);
//        关闭容器
        app.close();
    }

    @Test
    public void test1() {
        Person person1 = (Person) app.getBean("person");
        Person person2 = (Person) app.getBean("person");
//        比较地址值
        System.out.println(person1 == person2);//true  表示是用一个bean单列模式
        app.close();
    }

    @Test
    public void test2() {
        Person person1 = (Person) app.getBean("person");
        Person person2 = (Person) app.getBean("person");
        System.out.println(person1 == person2);//false 不是同一个bean
        app.close();//容器管理多实例的bean不会随之销毁
    }

    @Test
    public void test3() {
        Person person1 = (Person) app.getBean("person01");
    }


}
