package model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String writer;
    private String image;
    private String url;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Product(int id, String name, double price, String writer , String image,String url) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.writer = writer;
        this.image = image;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", writer='" + writer + '\'' +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
