package domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookOrder {
    private Integer oid;

    private String date;

    private String oname;

    private String address;

    private String status;

    private Integer uid;

    private List<OrderDetail> orderDetails;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname == null ? null : oname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "oid=" + oid +
                ", date='" + date + '\'' +
                ", oname='" + oname + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", uid=" + uid +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
