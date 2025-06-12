package cn.cjxy.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class City {
    private Integer id;
    private String cityName;
    private Double GDP;
    private Boolean capital;

    public City(Integer id, String cityName, Double GDP, Boolean capital) {
        this.id = id;
        this.cityName = cityName;
        this.GDP = GDP;
        this.capital = capital;
    }

    public City() {
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", GDP=" + GDP +
                ", capital=" + capital +
                '}';
    }
}
