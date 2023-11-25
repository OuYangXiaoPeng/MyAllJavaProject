package beans;

import java.util.List;

public class Student {

    private int id;
    private String name;
    private int age;
    private List<Teacher> teachers;
    private List<String> favorBookNames;

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<String> getFavorBookNames() {
        return favorBookNames;
    }

    public void setFavorBookNames(List<String> favorBookNames) {
        this.favorBookNames = favorBookNames;
    }

    public Student(){}

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println("id:"+id+"\nname:"+name+"\nage:"+age);
        System.out.println("---teacherInfo:");
        for(Teacher teacher:teachers){
            teacher.print();
        }
        System.out.println("---favorBookNames:");
        for(String name:favorBookNames){
            System.out.println(name);
        }
    }
}
