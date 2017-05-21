package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by miss on 2017/5/6.
 */

@Entity(name="account_flow")
public class AccountFlow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double amount;
    @ManyToOne(targetEntity = Clerk.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "clerk",referencedColumnName = "id",unique = true)
    private Clerk clerk;
    private String description;
    private int type;
    private int order_no;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOrder_no() {
        return order_no;
    }

    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object a){
        if(a==null)
            return false;
        if(a instanceof AccountFlow)
            return id==((AccountFlow)a).id;
        else
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
