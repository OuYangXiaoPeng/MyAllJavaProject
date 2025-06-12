package cn.cjxy.bean_propertie.domain;

public class Book {
    private String id;
    private String name;
    private Double price;

    public Book() {
        System.out.println("book被初始化");
    }

    public Book(String id, String name, Double price) {
        System.out.println("有参构造执行了");
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Book(Double price, String id, String name) {
        System.out.println("有参构造执行了");
        this.id = id;
        this.name = name;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
