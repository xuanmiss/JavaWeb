package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity
public class Purchase_Order {
//    消息类的标识
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToOne(targetEntity = Order.class,fetch = FetchType.LAZY)
    @JoinColumn(name="order_no")
    private Order order;

    @OneToOne(targetEntity = Model.class,fetch = FetchType.LAZY)
    @JoinColumn(name="model")
    private Model model;

    @Column(name="quantity")
    private String quantity;
    @Column(name="amount")
    private Double amount;
    @Column(name="date")
    private Date date;

    @ManyToOne(targetEntity = Clerk.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "clerk")
    private Clerk clerk;

    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase_Order)) return false;

        Purchase_Order that = (Purchase_Order) o;

        if (id != that.id) return false;
        if (!order.equals(that.order)) return false;
        if (!model.equals(that.model)) return false;
        if (!quantity.equals(that.quantity)) return false;
        if (!amount.equals(that.amount)) return false;
        if (!date.equals(that.date)) return false;
        if (!clerk.equals(that.clerk)) return false;
        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + order.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + quantity.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + clerk.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Purchase_Order{" +
                "id=" + id +
                ", order=" + order +
                ", model=" + model +
                ", quantity='" + quantity + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", clerk=" + clerk +
                ", type='" + type + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
