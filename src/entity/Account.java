package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by miss on 2017/5/6.
 */

@Entity(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private double flow;
    private double fixed;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFlow() {
        return flow;
    }

    public void setFlow(double flow) {
        this.flow = flow;
    }

    public double getFixed() {
        return fixed;
    }

    public void setFixed(double fixed) {
        this.fixed = fixed;
    }
}
