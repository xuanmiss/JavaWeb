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

    private Integer id;

    private String order_no;

    private double price;

    private Date date;

    private int quantity;

    private int status;



    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver", referencedColumnName = "id",unique = true)
    private Client receiver;

    @OneToOne(targetEntity = Model.class,fetch = FetchType.LAZY)
    @JoinColumn(name="model",referencedColumnName = "id",unique = true)
    private Model model;

    public Client getReceiver() {return receiver;}

    public void setReceiver(Client receiver) {this.receiver = receiver;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
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
        return 17*31+id;
    }
}
