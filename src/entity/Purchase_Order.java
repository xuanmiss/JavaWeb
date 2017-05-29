package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity
@Table(name = "purchase_order")
public class Purchase_Order {
//    消息类的标识
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;

    private String order_no;

    @ManyToOne(targetEntity = Model.class,fetch = FetchType.LAZY)
    @JoinColumn(name="model")
    private Model model;

    @Column(name="quantity")
    private int quantity;
    @Column(name="amount")
    private Double amount;
    @Column(name="date")
    private Date date;

    @ManyToOne(targetEntity = Clerk.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "clerk")
    private Clerk clerk;



    private int type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
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

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase_Order)) return false;
        Purchase_Order that = (Purchase_Order) o;
        if (id != that.id) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result=17;
        result=result*31+id;
        result=result*31+id*id;
        result=result*31+id*id*id;
        return result;
    }
}
