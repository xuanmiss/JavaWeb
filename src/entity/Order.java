package entity;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity
@Table(name = "order_form")
public class Order {
    //    消息类的标识属性
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "order_no")
    private int order_no;
    @Column(name = "price")
    private double price;
    @Column(name="date")
    private Date date;
    @Column(name="quantity")
    private String quantity;
    @Column(name="status")
    private String status;

    //    默认构造方法
    public Order() {
    }

    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver", referencedColumnName = "name")
    private Client receiver;

    @OneToOne(targetEntity = Model.class,fetch = FetchType.LAZY)
    @JoinColumn(name="model")
    private Model model;

    public Client getReceiver() {return receiver;}

    public void setReceiver(Client receiver) {this.receiver = receiver;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_no=" + order_no +
                ", price=" + price +
                ", date=" + date +
                ", quantity='" + quantity + '\'' +
                ", status='" + status + '\'' +
                ", receiver=" + receiver +
                ", model=" + model +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        if (getId() != order.getId()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + getOrder_no();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getQuantity().hashCode();
        result = 31 * result + getStatus().hashCode();
        result = 31 * result + getReceiver().hashCode();
        result = 31 * result + getModel().hashCode();
        return result;
    }
}
