package beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("car")
public class Car {
    @Value("玛莎拉蒂")
    private String name;
    @Value("黑金色")
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(){}

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void print(){
        System.out.println("Car: " + name+"\nColor:"+color);
    }
}
