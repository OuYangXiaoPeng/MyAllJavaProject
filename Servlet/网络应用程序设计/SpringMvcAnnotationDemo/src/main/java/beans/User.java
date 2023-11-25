package beans;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String id;
    private String password;
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {

    }

    public User(String id, String password, int age) {
        this.id = id;
        this.password = password;
        this.age = age;
    }
}
