package springDemos;

import beans.Student;
import beans.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) throws Exception {
        //创建Spring容器
//        while (true) {
//            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//            SayHandler bean = (SayHandler) context.getBean("SayHandler");
//            bean.saySomeThing();
//            Thread.sleep(5000);
//        }

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student stu = (Student) context.getBean("myStudent");
        stu.print();

        System.out.println("--------------------------------");
        User user = (User) context.getBean("user");
        user.print();
    }

}
