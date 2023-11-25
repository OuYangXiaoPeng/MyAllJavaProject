package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component("user")
@Scope("singleton")
public class User {
    @Value("张三")
    private String name;
    @Value("18")
    private int age;
    @Autowired
    @Qualifier("house2")
    private House house;

//    @Autowired
//    @Qualifier("car")
    @Resource(name = "car")
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User() {
    }

    public User(String name, int age, House house, Car car) {
        this.name = name;
        this.age = age;
        this.house = house;
        this.car = car;
    }

    public void print() {
        System.out.println("我叫" + name + ",今年" + age + "岁");
        house.print();
        car.print();
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化执行完毕！");
    }

    @PreDestroy
    public void destroyed() {
        System.out.println("即将销毁对象！");
    }
}
