package beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("house2")
public class House {
    @Value("200")
    private Integer Size;
    @Value("true")
    private Boolean withGarden;

    public Integer getSize() {
        return Size;
    }

    public void setSize(Integer size) {
        Size = size;
    }

    public Boolean getWithGarden() {
        return withGarden;
    }

    public void setWithGarden(Boolean withGarden) {
        this.withGarden = withGarden;
    }

    public House(){}

    public House(Integer size, Boolean withGarden) {
        this.Size = size;
        this.withGarden = withGarden;
    }

    public void print() {
        if(withGarden)
            System.out.println("我住的房子大小为:" + Size + "平方,\n并且带有花园(" + withGarden+")");
        else
            System.out.println("我住的房子大小为:" + Size + "平方,\n并且没有花园(" + withGarden+")");
    }
}
