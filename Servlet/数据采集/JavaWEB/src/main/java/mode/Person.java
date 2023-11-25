package mode;

public class Person {
    private int id;
    private String name;
    private String sales;
    private String profit;
    private String country;

    public Person(int id,String name, String sales, String profit, String country) {
        this.id = id;
        this.name = name;
        this.sales = sales;
        this.profit = profit;
        this.country = country;
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

    public String getSales() {
        return sales;
    }

    public String getProfit() {
        return profit;
    }

    public String getCountry() {
        return country;
    }
}