package cn.cjxy.bean_propertie.domain;

public class Emp {
    private String id;
    private String name;
    private Dept dept = new Dept();
    public Emp() {}

    public Emp(String id, String name, Dept dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
