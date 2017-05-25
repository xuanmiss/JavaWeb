package entity;

import javax.persistence.*;

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
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(targetEntity = Batch.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "batch",referencedColumnName = "id")
    private Batch batch;

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    @ManyToOne(targetEntity = Clerk.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "clerk",referencedColumnName = "id")
    private Clerk clerk;

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    @OneToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_form",referencedColumnName = "id")
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
    public int hashCode(){
        int result=17;
        result=result*31+id;
        result=result*31+id*id;
        result=result*31+id*id*id;
        return result;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", batch=" + batch +
                ", clerk=" + clerk +
                ", order=" + order +
                '}';
    }
}
