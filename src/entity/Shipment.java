package entity;

import javax.persistence.*;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity(name="shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne(targetEntity = Order.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "order_form", referencedColumnName = "id")
    private Order order_form;

    @OneToOne(targetEntity = Batch.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "batch", referencedColumnName = "id")
    private Batch batch;

    @OneToOne(targetEntity = Clerk.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "clerk", referencedColumnName = "id")
    private Clerk clerk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrder_form() {
        return order_form;
    }

    public void setOrder_form(Order order_form) {
        this.order_form = order_form;
    }

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

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;
        if(o instanceof Shipment)
            return id == ((Shipment)o).id;
        return false;
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
