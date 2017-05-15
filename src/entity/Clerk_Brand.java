package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ymcvalu on 2017/5/6.
 */
@Entity
@Table(name="clerk_brand")
public class Clerk_Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private Date date;
    private Integer status;
    @OneToOne(targetEntity = Clerk.class)
    @JoinColumn(name = "clerk", referencedColumnName = "id", unique = true)
    private Clerk clerk;

    @OneToOne(targetEntity = Brand.class)
    @JoinColumn(name = "brand", referencedColumnName = "id", unique = true)
    private Brand brand;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }



    @Override

    public boolean equals(Object a){
        if(a==null)
            return false;
        if(a instanceof Clerk_Brand)
            return id==((Clerk_Brand)a).id;
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

    @Override
    public String toString() {
        return "Clerk_Brand{" +
                "id=" + id +
                ", date=" + date +
                ", status=" + status +
                ", clerk=" + clerk +
                ", brand=" + brand +
                '}';
    }
}
