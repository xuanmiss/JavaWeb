package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity
@Table(name = "purchase")
public class Purchase {
    //    消息类的标识
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    //    默认构造方法
    public Purchase() {
    }

    @OneToOne(targetEntity = Batch.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "batch")
    private Batch batch;

    @ManyToOne(targetEntity = Clerk.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "clerk")
    private Clerk clerk;

    @OneToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_form")
    private Order order_form;

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public Order getOrder_form() {
        return order_form;
    }

    public void setOrder_form(Order order_form) {
        this.order_form = order_form;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", batch=" + batch +
                ", clerk=" + clerk +
                ", order_form=" + order_form +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;

        Purchase purchase = (Purchase) o;

        if (getId() != purchase.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getBatch().hashCode();
        result = 31 * result + getClerk().hashCode();
        result = 31 * result + getOrder_form().hashCode();
        return result;
    }
}
